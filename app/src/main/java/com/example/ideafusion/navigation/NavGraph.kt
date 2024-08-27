package com.example.ideafusion.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ideafusion.presentation.AboutScreen
import com.example.ideafusion.presentation.ArchivedScreen
import com.example.ideafusion.presentation.HomeScreen
import com.example.ideafusion.presentation.SettingsScreen
import com.example.ideafusion.presentation.TrashScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    scope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
) {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val menus = arrayOf(
        DrawerMenu(Icons.Default.Home, "Home", Screen.Home.route),
        DrawerMenu(Icons.Default.DateRange, "Archived", Screen.Archived.route),
        DrawerMenu(Icons.Default.Delete, "Trash", Screen.Trash.route),
        DrawerMenu(Icons.Default.Settings, "Settings", Screen.Home.route),
        DrawerMenu(Icons.Default.Info, "Info", Screen.About.route)
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = modifier.height(16.dp))

                Text(modifier = Modifier.padding(start = 16.dp),text = "Idea Fusion", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = modifier.height(12.dp))

               menus.forEachIndexed { index, item ->
                   NavigationDrawerItem(
                       label = {
                       Text(text =item.title)
                               },
                       selected = index == selectedItemIndex,
                       onClick = {
                           navController.navigate(item.route)
                           selectedItemIndex = index
                           scope.launch {
                               drawerState.close()
                           }
                       },
                       icon = {
                           Icon(imageVector = item.icon, contentDescription = null )
                       },
                       modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding))
               }
            }
        }) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route){
                HomeScreen(drawerState = drawerState)
            }
            composable(Screen.Archived.route) {
                ArchivedScreen(drawerState = drawerState)
            }
            composable(Screen.Trash.route) {
                TrashScreen(drawerState = drawerState)
            }
            composable(Screen.About.route){
                AboutScreen(drawerState = drawerState)
            }
            composable(Screen.Settings.route){
                SettingsScreen(drawerState = drawerState)
            }

        }

    }

}




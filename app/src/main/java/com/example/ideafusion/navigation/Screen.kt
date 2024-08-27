package com.example.ideafusion.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

enum class Screen(
    val route: String,
) {
    Home("home"),
    Archived("archived"),
    Trash("trash"),
    Settings("settings"),
    About("about")
//    data object Home: Screen(
//        route = "home",
//        title = "Home",
//        icon = Icons.Default.Home
//    )
//    data object Archived: Screen(
//        route = "archived",
//        title = "Archived",
//        icon = Icons.Default.Email
//    )
//    data object Trash: Screen(
//        route = "trash",
//        title = "Trash",
//        icon = Icons.Default.Delete
//    )
//    data object Settings: Screen(
//        route = "settings",
//        title = "Settings",
//        icon = Icons.Default.Email
//    )
//    data object About: Screen(
//        route = "about",
//        title = "About",
//        icon = Icons.Default.Email
//    )
}
package com.example.ideafusion.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    drawerState: DrawerState?,
    text: String,
) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 24.dp, top = 20.dp)
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(onClick = {
                if (drawerState != null) {
                    scope.launch {
                        drawerState.open()
                    }
                }
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = text,
                fontSize = 28.sp,
                color = MaterialTheme.colorScheme.onSurface
            )


        }
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(modifier = Modifier.blur(25.dp))
    }

}
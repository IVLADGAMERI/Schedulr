package com.cmd.schedulr.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.cmd.schedulr.R
import com.cmd.schedulr.ui.screen.NavRoute

@Composable
fun BottomNavigationBar(
    selectedItem: NavRoute,
    onItemSelected: (NavRoute) -> Unit
) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row (
            modifier = Modifier
                .padding(horizontal = 18.dp, vertical = 20.dp)
                .clip(RoundedCornerShape(50))
                .fillMaxWidth()
                .background(colorResource(id = R.color.primary)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            BottomNavigationBarButton(
                iconResId = R.drawable.list_task,
                selected = selectedItem == NavRoute.Home,
                onClick = { onItemSelected(NavRoute.Home) }
            )
            BottomNavigationBarButton(
                iconResId = R.drawable.calendar3,
                selected = selectedItem == NavRoute.Calendar,
                onClick = {
                    Log.d("Main", "Pressed")
                    onItemSelected(NavRoute.Calendar)
                }
            )
            BottomNavigationBarButton(
                iconResId = R.drawable.puzzle,
                selected = selectedItem == NavRoute.Templates,
                onClick = { onItemSelected(NavRoute.Templates) }
            )
            BottomNavigationBarButton(
                iconResId = R.drawable.clipboard_data,
                selected = selectedItem == NavRoute.Statistics,
                onClick = { onItemSelected(NavRoute.Statistics) }
            )
        }
    }
}
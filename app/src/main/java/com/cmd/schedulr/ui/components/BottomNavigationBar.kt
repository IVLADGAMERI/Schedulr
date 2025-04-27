package com.cmd.schedulr.ui.components

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

@Composable
fun BottomNavigationBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
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
                selected = selectedIndex == 0,
                onClick = { onItemSelected(0) }
            )
            BottomNavigationBarButton(
                iconResId = R.drawable.calendar3,
                selected = selectedIndex == 1,
                onClick = { onItemSelected(1) }
            )
            BottomNavigationBarButton(
                iconResId = R.drawable.puzzle,
                selected = selectedIndex == 2,
                onClick = { onItemSelected(2) }
            )
            BottomNavigationBarButton(
                iconResId = R.drawable.clipboard_data,
                selected = selectedIndex == 3,
                onClick = { onItemSelected(3) }
            )
        }
    }
}
package com.cmd.schedulr.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cmd.schedulr.R

@Composable
fun BottomNavigationBarButton(iconResId: Int, selected: Boolean, onClick: () -> Unit) {
    val buttonBackground = if (selected)
        colorResource(R.color.button_active)
    else
        colorResource(R.color.button_inactive)
    val iconTint = if (selected)
        colorResource(R.color.icon_active)
    else
        colorResource(R.color.icon_inactive)
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clip(RoundedCornerShape(50))
            .background(color = buttonBackground)
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier
                .padding(7.dp)
                .size(52.dp)
        )
    }
}
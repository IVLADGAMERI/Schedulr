package com.cmd.schedulr.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.cmd.schedulr.domain.viewModel.TaskViewModel

@Composable
fun CalendarScreen(navController: NavController) {
    val taskViewModel: TaskViewModel = viewModel()
    Text("Aboba Calendar", modifier = Modifier.padding(26.dp))
    val tasks = taskViewModel.tasks.collectAsState().value
}
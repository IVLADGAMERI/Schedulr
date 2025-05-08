package com.cmd.schedulr.ui.screen

sealed class NavRoute(val route: String) {
    object Home : NavRoute("home")
    object Calendar : NavRoute("calendar")
    object Templates : NavRoute("templates")
    object Statistics : NavRoute("statistics")

    companion object {
        fun fromRoute(route: String?): NavRoute = when (route) {
            Home.route -> Home
            Calendar.route -> Calendar
            Templates.route -> Templates
            Statistics.route -> Statistics
            else -> Home
        }
    }
}
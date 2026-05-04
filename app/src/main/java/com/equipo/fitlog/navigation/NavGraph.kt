package com.equipo.fitlog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.equipo.fitlog.ui.screens.*
import com.equipo.fitlog.ui.viewmodel.SessionViewModel

@Composable
fun NavGraph(vm: SessionViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {

        composable("list") {
            SessionListScreen(navController, vm)
        }

        composable("add") {
            AddSessionScreen(navController, vm)
        }

        composable("detail/{sessionId}") { backStackEntry ->

            val id = backStackEntry.arguments?.getString("sessionId")?.toInt() ?: 0

            DetailScreen(vm, id)
        }
    }
}
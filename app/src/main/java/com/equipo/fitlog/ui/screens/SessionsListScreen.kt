package com.equipo.fitlog.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.equipo.fitlog.ui.viewmodel.SessionViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SessionListScreen(navController: NavController, vm: SessionViewModel) {

    val sessions by vm.sessions.collectAsState()

    LaunchedEffect(Unit) {
        vm.loadSessions()
    }

    Column {
        Button(onClick = { navController.navigate("add") }) {
            Text("Nueva sesión")
        }

        LazyColumn {
            items(sessions) { session ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { navController.navigate("detail") }
                ) {
                    Column(Modifier.padding(8.dp)) {
                        Text(session.routineName)
                        Text(session.date)
                        Text(if (session.completed) "Completada" else "Pendiente")
                    }
                }
            }
        }
    }
}
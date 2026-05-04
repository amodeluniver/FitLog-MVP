package com.equipo.fitlog.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            "Historial de sesiones",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { navController.navigate("add") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Nueva sesión")
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn {
            items(sessions) { session ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp)
                        .clickable {
                            navController.navigate("detail/${session.id}")
                        }
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {

                        Text(session.routineName, style = MaterialTheme.typography.titleMedium)
                        Text(session.date)

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            if (session.completed) "Completada" else "Pendiente",
                            color = if (session.completed) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }
    }
}
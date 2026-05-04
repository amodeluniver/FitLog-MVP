package com.equipo.fitlog.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import com.equipo.fitlog.ui.viewmodel.SessionViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(vm: SessionViewModel, sessionId: Int) {

    val sessions by vm.sessions.collectAsState()
    val session = sessions.find { it.id == sessionId } ?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(session.routineName, style = MaterialTheme.typography.headlineSmall)
        Text(session.date)

        Spacer(modifier = Modifier.height(12.dp))

        Text("Ejercicios", style = MaterialTheme.typography.titleMedium)

        LazyColumn {
            items(session.exercises) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(it.name)
                        Text("${it.series} x ${it.reps}")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { vm.toggleStatus(session) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (session.completed) "Marcar Pendiente" else "Marcar Completada")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { vm.deleteSession(session) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Eliminar sesión")
        }
    }
}
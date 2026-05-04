package com.equipo.fitlog.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.equipo.fitlog.data.model.Exercise
import com.equipo.fitlog.data.model.Session
import com.equipo.fitlog.ui.viewmodel.SessionViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun AddSessionScreen(navController: NavController, vm: SessionViewModel) {

    var routine by remember { mutableStateOf("") }
    val exercises = remember { mutableStateListOf<Exercise>() }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        TextField(
            value = routine,
            onValueChange = { routine = it },
            label = { Text("Nombre de rutina") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            exercises.add(Exercise("Ejercicio", 3, 10))
        }) {
            Text("Agregar ejercicio")
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn {
            items(exercises) {
                Text("${it.name} - ${it.series}x${it.reps}")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                vm.addSession(
                    Session(
                        id = Random.nextInt(),
                        date = "2026-05-04",
                        routineName = routine,
                        exercises = exercises.toList(),
                        completed = false
                    )
                )
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "Nueva sesión",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}
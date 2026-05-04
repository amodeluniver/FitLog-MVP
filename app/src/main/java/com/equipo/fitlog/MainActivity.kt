package com.equipo.fitlog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.equipo.fitlog.navigation.NavGraph
import com.equipo.fitlog.ui.viewmodel.SessionViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm: SessionViewModel = viewModel()
            NavGraph(vm)
        }
    }
}
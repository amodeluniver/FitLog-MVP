package com.equipo.fitlog.data.model

data class Session(
    val id: Int,
    val date: String,
    val routineName: String,
    val exercises: List<Exercise>,
    var completed: Boolean
)
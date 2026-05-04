package com.equipo.fitlog.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.equipo.fitlog.data.model.Session
import com.equipo.fitlog.data.repository.SessionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SessionViewModel : ViewModel() {

    private val repository = SessionRepository()

    private val _sessions = MutableStateFlow<List<Session>>(emptyList())
    val sessions: StateFlow<List<Session>> = _sessions

    fun loadSessions() {
        _sessions.value = repository.getSessions()
    }

    fun addSession(session: Session) {
        repository.addSession(session)
        loadSessions()
    }

    fun deleteSession(session: Session) {
        repository.deleteSession(session)
        loadSessions()
    }

    fun toggleStatus(session: Session) {
        repository.toggleStatus(session)
        loadSessions()
    }
}
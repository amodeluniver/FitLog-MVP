package com.equipo.fitlog.data.repository

import com.equipo.fitlog.data.model.Session

class SessionRepository {

    private val sessions = mutableListOf<Session>()

    fun getSessions(): List<Session> {
        return sessions.sortedByDescending { it.date }
    }

    fun addSession(session: Session) {
        sessions.add(session)
    }

    fun deleteSession(session: Session) {
        sessions.remove(session)
    }

    fun toggleStatus(session: Session) {
        session.completed = !session.completed
    }
}
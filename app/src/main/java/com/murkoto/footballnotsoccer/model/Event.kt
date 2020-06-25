package com.murkoto.footballnotsoccer.model

class Events (
    val events: List<Event>
)

class Event (
    val idEvent: String,
    val strHomeTeam: String,
    val strAwayTeam: String,
    val intHomeScore: Int?,
    val intAwayScore: Int?,
    val dateEvent: String?,
    val strTime: String?
) {
    fun isFinished(): Boolean {
        this.intAwayScore.let {
            return true
        }
        return false
    }
}
package fr.alexander.apicsharp.service

import fr.alexander.apicsharp.models.Conference
import java.util.Optional

interface ConferenceService {
    fun createConference(conference: Conference) : Conference
    fun editConference(id: Long, conference: Conference) : Conference
    fun readConference() : List<Conference>
    fun getConferenceById(id: Long) : Optional<Conference>
    fun deleteConference(id: Long) : String
}
package fr.alexander.apicsharp.service

import fr.alexander.apicsharp.models.Conference
import fr.alexander.apicsharp.repository.ConferenceRepository
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
@AllArgsConstructor
class ConferenceServiceimpl (
        @Autowired
        val conferenceRepository: ConferenceRepository
) : ConferenceService {

    override fun createConference(conference: Conference): Conference = conferenceRepository.save(conference)

    override fun editConference(id: Long, conference: Conference): Conference {
        return conferenceRepository.findById(id)
                .map {
                    it.name = conference.name
                    it.sigle = conference.sigle
                    it.theme = conference.theme
                    it.dateSoumission = conference.dateSoumission
                    it.dateResultat = conference.dateResultat
                    it.dateInscription = conference.dateInscription
                    it.dateDeroulement = conference.dateDeroulement
                    return@map conferenceRepository.save(it)
                }.orElseThrow{ RuntimeException("Conference non trouvée") }
    }

    override fun readConference(): List<Conference> = conferenceRepository.findAll()

    override fun getConferenceById(id: Long): Optional<Conference> = conferenceRepository.findById(id)

    override fun deleteConference(id: Long): String {
        conferenceRepository.deleteById(id)
        val message = "Suppression de le Conference avec Succès"
        return message
    }
}
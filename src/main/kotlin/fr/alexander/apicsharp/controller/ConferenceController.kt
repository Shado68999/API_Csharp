package fr.alexander.apicsharp.controller

import fr.alexander.apicsharp.models.Conference
import fr.alexander.apicsharp.service.ConferenceService
import lombok.AllArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/ApiSharp/api/v1")
class ConferenceController(
      private val conferenceService: ConferenceService
) {

    @PostMapping("/Conference/create")
    fun create(@RequestBody conference : Conference) : Conference = conferenceService.createConference(conference)

    @GetMapping("/Conference/read")
    fun read() : List<Conference> = conferenceService.readConference()

    @GetMapping("/Conference/get/{id}")
    fun getConferenceById(@PathVariable id: Long): ResponseEntity<Conference> {
        val conference = conferenceService.getConferenceById(id)
        return if (conference.isPresent) {
            ResponseEntity.ok(conference.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/Conference/update/{id}")
    fun update(@RequestBody conference : Conference, @PathVariable id: Long) : Conference = conferenceService.editConference(id, conference)

    @DeleteMapping("/Conference/delete/{id}")
    fun delete(@PathVariable id: Long) : String = conferenceService.deleteConference(id)
}


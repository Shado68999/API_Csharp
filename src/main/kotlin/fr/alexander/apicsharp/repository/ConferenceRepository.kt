package fr.alexander.apicsharp.repository


import fr.alexander.apicsharp.models.Conference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ConferenceRepository : JpaRepository<Conference, Long>
{}
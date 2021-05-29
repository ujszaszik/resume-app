package hu.ujszaszik.resumeapp.resume.datasource

import com.google.firebase.database.DatabaseReference
import hu.ujszaszik.resumeapp.extensions.fetchValues
import hu.ujszaszik.resumeapp.resume.overview.model.ContactData
import hu.ujszaszik.resumeapp.resume.personal.language.model.LanguageData
import hu.ujszaszik.resumeapp.resume.personal.personality.model.PersonalityData
import hu.ujszaszik.resumeapp.resume.personal.quotes.QuoteData
import hu.ujszaszik.resumeapp.resume.projects.model.ProjectData
import hu.ujszaszik.resumeapp.resume.repository.*
import hu.ujszaszik.resumeapp.resume.skills.model.SkillData
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResumeRemoteDataSource @Inject constructor() {

    @Inject
    @Contact
    lateinit var contacts: DatabaseReference

    @Inject
    @Experience
    lateinit var experiences: DatabaseReference

    @Inject
    @Language
    lateinit var languages: DatabaseReference

    @Inject
    @Personality
    lateinit var personality: DatabaseReference

    @Inject
    @Project
    lateinit var projects: DatabaseReference

    @Inject
    @Quote
    lateinit var quotes: DatabaseReference


    fun getContacts(): PublishSubject<List<ContactData>> {
        return contacts.fetchValues()
    }

    fun getExperiences(): PublishSubject<List<SkillData>> {
        return experiences.fetchValues()
    }

    fun getLanguages(): PublishSubject<List<LanguageData>> {
        return languages.fetchValues()
    }

    fun getPersonalityRemarks(): PublishSubject<List<PersonalityData>> {
        return personality.fetchValues()
    }

    fun getProjects(): PublishSubject<List<ProjectData>> {
        return projects.fetchValues()
    }

    fun getQuotes(): PublishSubject<List<QuoteData>> {
        return quotes.fetchValues()
    }
}
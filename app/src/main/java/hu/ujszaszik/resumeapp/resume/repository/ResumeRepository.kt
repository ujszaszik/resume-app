package hu.ujszaszik.resumeapp.resume.repository

import hu.ujszaszik.resumeapp.resume.datasource.ResumeRemoteDataSource
import hu.ujszaszik.resumeapp.resume.overview.model.ContactData
import hu.ujszaszik.resumeapp.resume.personal.language.LanguageData
import hu.ujszaszik.resumeapp.resume.personal.personality.PersonalityData
import hu.ujszaszik.resumeapp.resume.personal.quotes.QuoteData
import hu.ujszaszik.resumeapp.resume.projects.model.ProjectData
import hu.ujszaszik.resumeapp.resume.skills.SkillData
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResumeRepository @Inject constructor(
    private val remoteDataSource: ResumeRemoteDataSource
) {

    fun getContacts(): PublishSubject<List<ContactData>> = remoteDataSource.getContacts()

    fun getExperiences(): PublishSubject<List<SkillData>> = remoteDataSource.getExperiences()

    fun getLanguages(): PublishSubject<List<LanguageData>> = remoteDataSource.getLanguages()

    fun getPersonalityData(): PublishSubject<List<PersonalityData>> =
        remoteDataSource.getPersonalityRemarks()

    fun getProjects(): PublishSubject<List<ProjectData>> = remoteDataSource.getProjects()

    fun getQuotes(): PublishSubject<List<QuoteData>> = remoteDataSource.getQuotes()

}
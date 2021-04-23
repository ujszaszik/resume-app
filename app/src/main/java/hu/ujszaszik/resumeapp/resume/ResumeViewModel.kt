package hu.ujszaszik.resumeapp.resume

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hu.ujszaszik.resumeapp.extensions.subscribeToList
import hu.ujszaszik.resumeapp.resume.overview.model.ContactData
import hu.ujszaszik.resumeapp.resume.personal.language.LanguageData
import hu.ujszaszik.resumeapp.resume.personal.personality.PersonalityData
import hu.ujszaszik.resumeapp.resume.personal.quotes.QuoteData
import hu.ujszaszik.resumeapp.resume.projects.ProjectData
import hu.ujszaszik.resumeapp.resume.repository.ResumeRepository
import hu.ujszaszik.resumeapp.resume.skills.SkillData
import javax.inject.Inject

class ResumeViewModel @Inject constructor(
    private val repository: ResumeRepository,
) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _contacts = MutableLiveData<List<ContactData>>()
    val contacts: LiveData<List<ContactData>> get() = _contacts

    private val _projects = MutableLiveData<List<ProjectData>>()
    val projects: LiveData<List<ProjectData>> get() = _projects

    private val _skills = MutableLiveData<List<SkillData>>()
    val skills: LiveData<List<SkillData>> get() = _skills

    private val _languages = MutableLiveData<List<LanguageData>>()
    val languages: LiveData<List<LanguageData>> get() = _languages

    private val _personalityData = MutableLiveData<List<PersonalityData>>()
    val personalityData: LiveData<List<PersonalityData>> get() = _personalityData

    private val _quotes = MutableLiveData<List<QuoteData>>()
    val quotes: LiveData<List<QuoteData>> get() = _quotes

    init {
        _isLoading.postValue(true)
        fetchContacts()
        fetchProjects()
        fetchSkills()
        fetchLanguages()
        fetchPersonalityData()
        fetchQuotes()
    }

    private fun fetchContacts() {
        repository.getContacts()
            .subscribeToList {
                _contacts.postValue(it)
                _isLoading.postValue(false)
            }
    }

    private fun fetchProjects() {
        repository.getProjects().subscribeToList { _projects.postValue(it) }
    }

    private fun fetchSkills() {
        repository.getExperiences().subscribeToList { _skills.postValue(it) }
    }

    private fun fetchLanguages() {
        repository.getLanguages().subscribeToList { _languages.postValue(it) }
    }

    private fun fetchPersonalityData() {
        repository.getPersonalityData().subscribeToList { _personalityData.postValue(it) }
    }

    private fun fetchQuotes() {
        repository.getQuotes().subscribeToList { _quotes.postValue(it) }
    }

}
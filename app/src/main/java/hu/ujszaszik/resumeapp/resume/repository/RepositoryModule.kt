package hu.ujszaszik.resumeapp.resume.repository

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    companion object {
        const val CONTACTS = "contact"
        const val EXPERIENCE = "experience"
        const val PROJECTS = "projects"
        const val LANGUAGES = "languages"
        const val PERSONALITY = "personality"
        const val QUOTES = "quotes"
    }

    @Provides
    fun provideFirebaseDatabase(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage {
        return FirebaseStorage.getInstance()
    }

    @Provides
    @Contact
    fun provideContacts(database: FirebaseDatabase): DatabaseReference {
        return database.getReference(CONTACTS)
    }

    @Provides
    @Experience
    fun provideExperiences(database: FirebaseDatabase): DatabaseReference {
        return database.getReference(EXPERIENCE)
    }

    @Provides
    @Project
    fun provideProjects(database: FirebaseDatabase): DatabaseReference {
        return database.getReference(PROJECTS)
    }

    @Provides
    @Language
    fun provideLanguages(database: FirebaseDatabase): DatabaseReference {
        return database.getReference(LANGUAGES)
    }

    @Provides
    @Personality
    fun providePersonality(database: FirebaseDatabase): DatabaseReference {
        return database.getReference(PERSONALITY)
    }

    @Provides
    @Quote
    fun provideQuotes(database: FirebaseDatabase): DatabaseReference {
        return database.getReference(QUOTES)
    }
}
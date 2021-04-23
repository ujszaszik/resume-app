package hu.ujszaszik.resumeapp.login.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LoginModule {

    companion object {
        private const val LOGIN_PREFERENCES_NAME = "login_preferences"
    }

    @Provides
    @Singleton
    fun provideDataStore(context: Context): DataStore<Preferences> {
        return context.createDataStore(LOGIN_PREFERENCES_NAME)
    }
}
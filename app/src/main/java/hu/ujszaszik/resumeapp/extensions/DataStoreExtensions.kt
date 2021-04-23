package hu.ujszaszik.resumeapp.extensions

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

suspend fun DataStore<Preferences>.getBoolean(key: String): Boolean {
    return data.map { prefs -> prefs[booleanPreferencesKey(key)] ?: false }.first()
}

suspend fun DataStore<Preferences>.saveBoolean(key: String, value: Boolean) {
    edit { prefs -> prefs[booleanPreferencesKey(key)] = value }
}

suspend fun DataStore<Preferences>.getInt(key: String): Int {
    return data.map { prefs -> prefs[intPreferencesKey(key)] ?: 0 }.first()
}

suspend fun DataStore<Preferences>.saveInt(key: String, value: Int) {
    edit { prefs -> prefs[intPreferencesKey(key)] = value }
}

suspend fun DataStore<Preferences>.saveString(key: String, value: String) {
    edit { prefs -> prefs[stringPreferencesKey(key)] = value }
}

suspend fun DataStore<Preferences>.getString(key: String): String {
    return data.map { prefs -> prefs[stringPreferencesKey(key)] ?: "" }.first()
}

suspend fun DataStore<Preferences>.resetInt(key: String) = saveInt(key, 0)

suspend fun DataStore<Preferences>.increment(key: String) {
    edit { prefs ->
        val currentValue = prefs[intPreferencesKey(key)] ?: 0
        prefs[intPreferencesKey(key)] = currentValue + 1
    }
}
package hu.ujszaszik.resumeapp.auth

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth

class FirebaseUserLiveData : LiveData<Boolean?>() {

    private val firebaseAuth = FirebaseAuth.getInstance()
    private val authStateListener =
        FirebaseAuth.AuthStateListener {
            postValue(it.currentUser != null)
        }

    override fun onActive() {
        firebaseAuth.addAuthStateListener(authStateListener)
    }

    override fun onInactive() {
        firebaseAuth.removeAuthStateListener(authStateListener)
    }
}
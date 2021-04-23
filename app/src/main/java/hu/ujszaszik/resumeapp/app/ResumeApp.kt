package hu.ujszaszik.resumeapp.app

import android.app.Application
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import hu.ujszaszik.resumeapp.extensions.turnOffDarkMode
import javax.inject.Inject

class ResumeApp : Application(), HasAndroidInjector {

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate() {
        appComponent = DaggerAppComponent.builder().context(this).build()
        appComponent.inject(this)
        super.onCreate()
        turnOffDarkMode()
    }

    override fun onTerminate() {
        Firebase.auth.signOut()
        super.onTerminate()
    }
}
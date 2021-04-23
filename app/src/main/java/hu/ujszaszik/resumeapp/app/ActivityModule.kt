package hu.ujszaszik.resumeapp.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hu.ujszaszik.resumeapp.login.LoginActivity
import hu.ujszaszik.resumeapp.register.RegisterActivity
import hu.ujszaszik.resumeapp.resume.ResumeActivity
import hu.ujszaszik.resumeapp.verification.VerificationActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    @ActivityScope
    abstract fun provideLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    @ActivityScope
    abstract fun provideResumeActivity(): ResumeActivity

    @ContributesAndroidInjector
    @ActivityScope
    abstract fun provideRegisterActivity(): RegisterActivity

    @ContributesAndroidInjector
    @ActivityScope
    abstract fun provideVerificationActivity(): VerificationActivity
}
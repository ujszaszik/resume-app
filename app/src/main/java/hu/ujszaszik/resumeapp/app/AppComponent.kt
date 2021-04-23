package hu.ujszaszik.resumeapp.app

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import hu.ujszaszik.resumeapp.login.repository.LoginModule
import hu.ujszaszik.resumeapp.resume.repository.RepositoryModule
import hu.ujszaszik.resumeapp.resume.ViewModelModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        LoginModule::class,
        RepositoryModule::class,
        ViewModelModule::class]
)
@Singleton
interface AppComponent {

    fun inject(app: ResumeApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent

    }
}
package hu.ujszaszik.resumeapp.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import hu.ujszaszik.resumeapp.resume.ResumeViewModel

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ResumeViewModel::class)
    internal abstract fun bindResumeViewModel(viewModel: ResumeViewModel): ViewModel
}
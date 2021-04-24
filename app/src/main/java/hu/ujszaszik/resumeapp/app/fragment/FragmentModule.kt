package hu.ujszaszik.resumeapp.app.fragment

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import hu.ujszaszik.resumeapp.resume.overview.OverviewFragment
import hu.ujszaszik.resumeapp.resume.personal.ProfileFragment
import hu.ujszaszik.resumeapp.resume.projects.ProjectsFragment
import hu.ujszaszik.resumeapp.resume.skills.SkillsFragment

@Module(
    subcomponents = [
        OverviewFragmentComponent::class,
        ProfileFragmentComponent::class,
        ProjectsFragmentComponent::class,
        SkillsFragmentComponent::class
    ]
)
interface FragmentModule {

    @Binds
    @IntoMap
    @ClassKey(OverviewFragment::class)
    fun bindOverviewFragmentInjectorFactory(factory: OverviewFragmentComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(ProfileFragment::class)
    fun bindProfileFragmentInjectorFactory(factory: ProfileFragmentComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(ProjectsFragment::class)
    fun bindProjectsFragmentInjectorFactory(factory: ProjectsFragmentComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(SkillsFragment::class)
    fun bindSkillsFragmentInjectorFactory(factory: SkillsFragmentComponent.Factory): AndroidInjector.Factory<*>
}
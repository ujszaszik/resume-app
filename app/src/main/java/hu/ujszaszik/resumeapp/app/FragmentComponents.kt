package hu.ujszaszik.resumeapp.app

import dagger.Subcomponent
import dagger.android.AndroidInjector
import hu.ujszaszik.resumeapp.resume.overview.OverviewFragment
import hu.ujszaszik.resumeapp.resume.personal.ProfileFragment
import hu.ujszaszik.resumeapp.resume.projects.ProjectsFragment
import hu.ujszaszik.resumeapp.resume.skills.SkillsFragment

@Subcomponent
interface OverviewFragmentComponent : AndroidInjector<OverviewFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<OverviewFragment>
}

@Subcomponent
interface ProfileFragmentComponent : AndroidInjector<ProfileFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ProfileFragment>
}

@Subcomponent
interface ProjectsFragmentComponent : AndroidInjector<ProjectsFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ProjectsFragment>
}

@Subcomponent
interface SkillsFragmentComponent : AndroidInjector<SkillsFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<SkillsFragment>
}
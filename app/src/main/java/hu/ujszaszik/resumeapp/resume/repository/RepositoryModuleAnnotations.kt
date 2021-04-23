package hu.ujszaszik.resumeapp.resume.repository

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Contact

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Experience

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Project

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Personality

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Language

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Quote
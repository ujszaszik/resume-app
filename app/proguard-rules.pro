-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt # core serialization annotations

# kotlinx-serialization-json specific. Add this if you have java.lang.NoClassDefFoundError kotlinx.serialization.json.JsonObjectSerializer
-keepclassmembers class kotlinx.serialization.json.** {
    *** Companion;
}
-keepclasseswithmembers class kotlinx.serialization.json.** {
    kotlinx.serialization.KSerializer serializer(...);
}

-keep,includedescriptorclasses class com.yourcompany.yourpackage.**$$serializer { *; } # <-- change package name to your app's
-keepclassmembers class hu.ujszaszik.resumeapp.** { # <-- change package name to your app's
    *** Companion;
}
-keepclasseswithmembers class hu.ujszaszik.resumeapp.** { # <-- change package name to your app's
    kotlinx.serialization.KSerializer serializer(...);
}

-keepclassmembers class * extends java.lang.Enum {
    <fields>;
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep public enum hu.ujszaszik.resumeapp.**{
    *;
}

-keepnames class hu.ujszaszik.resumeapp.general.ContactActionType

#KEEP SERIALIZABLE MODEL CLASSES
-keep class hu.ujszaszik.resumeapp.resume.overview.model.ContactData
-keep class hu.ujszaszik.resumeapp.resume.skills.model.SkillData
-keep class hu.ujszaszik.resumeapp.resume.personal.quotes.QuoteData
-keep class hu.ujszaszik.resumeapp.resume.personal.language.LanguageData
-keep class hu.ujszaszik.resumeapp.resume.personal.personality.PersonalityData
-keep class hu.ujszaszik.resumeapp.resume.projects.model.ProjectData
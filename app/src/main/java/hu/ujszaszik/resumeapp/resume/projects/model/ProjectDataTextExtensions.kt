package hu.ujszaszik.resumeapp.resume.projects.model

internal const val DESCRIPTION_TITLE_LENGTH = 12
internal const val ROLES_TITLE_LENGTH = 6
internal const val TECHNOLOGIES_TITLE_LENGTH = 13

val ProjectData.descriptionPair: Pair<String, String>
    get() = getStringPair(description, DESCRIPTION_TITLE_LENGTH)

val ProjectData.rolesPair: Pair<String, String>
    get() = getStringPair(roles, ROLES_TITLE_LENGTH)

val ProjectData.technologiesPair: Pair<String, String>
    get() = getStringPair(technologies, TECHNOLOGIES_TITLE_LENGTH)

private fun getStringPair(text: String, upTo: Int): Pair<String, String> {
    return text.substring(0, upTo) to text.substring(upTo + 1)
}
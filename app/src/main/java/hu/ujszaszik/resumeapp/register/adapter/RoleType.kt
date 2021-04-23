package hu.ujszaszik.resumeapp.register.adapter

import com.ujszaszik.resumeapp.R

enum class RoleType(val textId: Int) {
    SELECTOR(R.string.role_type_select),
    HR(R.string.role_type_hr),
    TECH_LEAD(R.string.role_type_tech_lead),
    DEVELOPER(R.string.role_type_developer),
    INQUIRER(R.string.role_type_inquirer);

}
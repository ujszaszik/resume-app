package hu.ujszaszik.resumeapp.general

import android.app.Activity

interface ContactAction {

    fun execute(activity: Activity, parameter: String)
}
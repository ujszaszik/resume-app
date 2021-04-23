package hu.ujszaszik.resumeapp.register.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.extensions.findTextViewById

class RoleDropDownViewHolder private constructor(val view: View) {

    companion object {

        private lateinit var layoutInflater: LayoutInflater

        fun from(position: Int, parent: ViewGroup): RoleDropDownViewHolder {
            layoutInflater = LayoutInflater.from(parent.context)
            return RoleDropDownViewHolder(getDropDownView(position, parent))
        }

        private fun getDropDownView(position: Int, parent: ViewGroup): View {
            val currentRole = RoleType.values()[position]
            return layoutInflater.inflate(R.layout.layout_spinner_roletype, parent, false)
                .apply { setText(this, currentRole) }
        }

        private fun setText(view: View, currentRole: RoleType) {
            with(view) {
                findTextViewById(R.id.roleText).text = context.getString(currentRole.textId)
            }
        }
    }
}
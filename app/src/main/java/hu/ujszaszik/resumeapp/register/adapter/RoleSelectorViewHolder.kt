package hu.ujszaszik.resumeapp.register.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.extensions.findTextViewById

class RoleSelectorViewHolder private constructor(val view: View) {

    companion object {

        private lateinit var layoutInflater: LayoutInflater

        fun from(position: Int, parent: ViewGroup): RoleSelectorViewHolder {
            layoutInflater = LayoutInflater.from(parent.context)
            val view = when (position) {
                0 -> getSelectorView(parent)
                else -> getSelectedView(position, parent)
            }
            return RoleSelectorViewHolder(view)
        }

        private fun getSelectorView(parent: ViewGroup): View {
            return layoutInflater.inflate(R.layout.layout_spinner_selector, parent, false)
        }

        private fun getSelectedView(position: Int, parent: ViewGroup): View {
            val currentRole = RoleType.values()[position]
            return layoutInflater.inflate(R.layout.layout_spinner_roletype_selected, parent, false)
                .apply { setValues(this, currentRole) }
        }

        private fun setValues(view: View, currentRole: RoleType) {
            with(view) {
                findTextViewById(R.id.hintText).text = context.getString(R.string.label_user_role)
                findTextViewById(R.id.roleText).text = context.getString(currentRole.textId)
            }
        }
    }
}
package hu.ujszaszik.resumeapp.register.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class RoleAdapter(context: Context) :
    ArrayAdapter<RoleType>(context, 0, RoleType.values()) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return RoleSelectorViewHolder.from(position, parent).view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return RoleDropDownViewHolder.from(position, parent).view
    }

    override fun getItem(position: Int): RoleType? = getItem(position - 1)

    override fun getCount() = RoleType.values().size

}
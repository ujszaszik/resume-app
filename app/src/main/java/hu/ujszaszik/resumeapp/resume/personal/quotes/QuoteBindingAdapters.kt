package hu.ujszaszik.resumeapp.resume.personal.quotes

import androidx.databinding.BindingAdapter
import com.google.firebase.storage.FirebaseStorage
import de.hdodenhof.circleimageview.CircleImageView
import hu.ujszaszik.resumeapp.extensions.getImage

@BindingAdapter("app:quoteImage")
fun CircleImageView.quoteImage(storedName: String) {
    FirebaseStorage.getInstance()
        .getImage(context.resources, storedName)
        .subscribe { setImageDrawable(it) }
}
package hu.ujszaszik.resumeapp.extensions

import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.FirebaseStorage
import hu.ujszaszik.resumeapp.auth.FirebaseListener
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject


inline fun <reified T> DatabaseReference.fetchValues(): PublishSubject<List<T>> {
    val subject = PublishSubject.create<List<T>>()
    addListenerForSingleValueEvent(FirebaseListener(T::class.java, subject))
    return subject
}

private const val ONE_MEGABYTE: Long = 1024 * 1024

fun FirebaseStorage.getImage(
    resources: Resources,
    storedName: String
): Subject<Drawable> {
    val subject = PublishSubject.create<Drawable>()
    getReference(storedName).getBytes(ONE_MEGABYTE)
        .addOnSuccessListener {
            subject.onNext(BitmapDrawable(resources, BitmapFactory.decodeByteArray(it, 0, it.size)))
        }
        .addOnFailureListener {
            subject.onError(it)
        }
    return subject
}
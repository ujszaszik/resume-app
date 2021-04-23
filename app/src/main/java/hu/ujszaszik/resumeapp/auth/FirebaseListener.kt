package hu.ujszaszik.resumeapp.auth

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.rxjava3.subjects.PublishSubject

@Suppress("UNCHECKED_CAST")
class FirebaseListener<T>(
    private val type: Class<T>,
    private val subject: PublishSubject<List<T>>
) : ValueEventListener {

    override fun onCancelled(error: DatabaseError) {
        subject.onError(error.toException())
    }

    override fun onDataChange(snapshot: DataSnapshot) {
        val results = mutableListOf<T>()
        snapshot.children.forEach {
            val current = it.getValue(type) as T
            results.add(current)
        }
        subject.onNext(results)
    }
}
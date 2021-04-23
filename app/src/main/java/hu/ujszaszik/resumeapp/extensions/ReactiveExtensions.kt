package hu.ujszaszik.resumeapp.extensions

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

fun <T> PublishSubject<List<T>>.subscribeToList(block: (List<T>) -> Unit) {
    subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { block.invoke(it) }
}
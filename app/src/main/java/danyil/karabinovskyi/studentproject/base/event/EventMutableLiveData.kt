package danyil.karabinovskyi.studentproject.base.event

/**
 * Created by Android Studio on 11/13/2020 6:12 PM
 * Developer: Sergey Zorych
 */

class EventMutableLiveData<T> : EventLiveData<T> {

    constructor(value: T) : super(value)
    constructor() : super()


    fun postEvent(value: T) {
        super.postValue(Event(value))
    }

    fun setEvent(value: T) {
        super.setValue(Event(value))
    }
}

fun EventMutableLiveData<Unit>.call() {
    postEvent(Unit)
}
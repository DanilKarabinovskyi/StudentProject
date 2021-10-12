package danyil.karabinovskyi.studentproject.base.event

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
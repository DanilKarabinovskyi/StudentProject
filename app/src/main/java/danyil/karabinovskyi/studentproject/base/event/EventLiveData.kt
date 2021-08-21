package danyil.karabinovskyi.studentproject.base.event

import androidx.lifecycle.LiveData

abstract class EventLiveData<T> : LiveData<Event<T>> {
    internal constructor() : super()
    internal constructor(value: T) : super(Event<T>(value))
}
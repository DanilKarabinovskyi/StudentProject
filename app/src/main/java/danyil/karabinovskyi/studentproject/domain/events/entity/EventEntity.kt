package danyil.karabinovskyi.studentproject.domain.events.entity

data class EventEntity(
    var id: String = "",
    var url: String = "",
    var title: String = "",
    var description: String = "",
    var time: String = "16.08 01.09.2077",
    var place: String = "16.08 01.09.2077",
)

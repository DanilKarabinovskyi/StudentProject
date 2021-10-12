package danyil.karabinovskyi.studentproject.base

sealed class Result <out T : Any, out U : Any> {
    data class Success <T: Any>(val data : T) : Result<T, Nothing>()
    data class Error <U : Any>(val rawResponse: U) : Result<Nothing, U>()
}
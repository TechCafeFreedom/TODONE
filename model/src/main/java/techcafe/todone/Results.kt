package techcafe.todone

sealed class Results<out T> {
    data class Loading<out T>(val data: T?) : Results<T>()
    data class Success<out T>(val data: T) : Results<T>()
    data class Failure<out T>(val throwable: Throwable) : Results<T>()
}

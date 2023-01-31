package rustam.urazov.fitnesskit.core.exception

sealed class Failure {
    object NetworkConnection : Failure()
    object NoDataError : Failure()
    data class ServerError(val errorMessage: String) : Failure()
    object UnexpectedError : Failure()
}

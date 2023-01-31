package rustam.urazov.fitnesskit.core.interactor

import kotlinx.coroutines.*
import rustam.urazov.fitnesskit.core.exception.Failure
import rustam.urazov.fitnesskit.core.functional.Either

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(
        params: Params,
        scope: CoroutineScope = GlobalScope,
        onResult: (Either<Failure, Type>) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                run(params)
            }
            onResult(deferred.await())
        }
    }

}
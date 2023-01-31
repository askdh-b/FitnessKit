package rustam.urazov.fitnesskit.core.functional

sealed class Either<out L, out R> {

    data class Left<out L>(val a: L) : Either<L, Nothing>()
    data class Right<out R>(val b: R) : Either<Nothing, R>()

    val isRight get() = this is Right<R>
    val isLeft get() = this is Left<L>

    fun <L> left(a: L) = Left(a)

    fun <R> right(b: R) = Right(b)

    fun fold(funcL: (L) -> Any, funcR: (R) -> Any): Any =
        when (this) {
            is Left -> funcL(a)
            is Right -> funcR(b)
        }
}

fun <A, B, C> ((A) -> B).compose(f: (B) -> C): (A) -> C = {
    f(this(it))
}

fun <T, L, R> Either<L, R>.flatmap(func: (R) -> Either<L, T>): Either<L, T> =
    when (this) {
        is Either.Left -> Either.Left(a)
        is Either.Right -> func(b)
    }

fun <T, L, R> Either<L, R>.map(func: (R) -> (T)): Either<L, T> = this.flatmap(func.compose(::right))

fun <L, R> Either<L, R>.getOrElse(value: R): R =
    when (this) {
        is Either.Left -> value
        is Either.Right -> b
    }

fun <L, R> Either<L, R>.onFailure(func: (failure: L) -> Unit): Either<L, R> =
    this.apply { if (this is Either.Left) func(a) }

fun <L, R> Either<L, R>.onSuccess(func: (success: R) -> Unit): Either<L, R> =
    this.apply { if (this is Either.Right) func(b) }
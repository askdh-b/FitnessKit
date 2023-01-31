package rustam.urazov.fitnesskit.data.repositories

import rustam.urazov.fitnesskit.core.exception.Failure
import rustam.urazov.fitnesskit.core.functional.Either
import rustam.urazov.fitnesskit.domain.models.Data

interface LessonsRepository {

    suspend fun getLessons(clubId: String): Either<Failure, Data>

}
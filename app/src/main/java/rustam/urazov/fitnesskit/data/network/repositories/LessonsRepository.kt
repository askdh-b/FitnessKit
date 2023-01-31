package rustam.urazov.fitnesskit.data.network.repositories

import rustam.urazov.fitnesskit.core.exception.Failure
import rustam.urazov.fitnesskit.core.functional.Either
import rustam.urazov.fitnesskit.domain.models.Lesson

interface LessonsRepository {

    suspend fun getLessons(clubId: String): Either<Failure, List<Lesson>>

}
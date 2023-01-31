package rustam.urazov.fitnesskit.domain.useCases

import rustam.urazov.fitnesskit.core.exception.Failure
import rustam.urazov.fitnesskit.core.functional.Either
import rustam.urazov.fitnesskit.core.interactor.UseCase
import rustam.urazov.fitnesskit.data.repositories.LessonsRepository
import rustam.urazov.fitnesskit.domain.models.Data
import javax.inject.Inject

class GetLessons @Inject constructor(private val lessonsRepository: LessonsRepository) : UseCase<Data, GetLessons.Params>() {

    override suspend fun run(params: Params): Either<Failure, Data> = lessonsRepository.getLessons(params.id)

    data class Params(val id: String)
}
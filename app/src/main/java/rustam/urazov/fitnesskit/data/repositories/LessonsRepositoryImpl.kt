package rustam.urazov.fitnesskit.data.repositories

import rustam.urazov.fitnesskit.core.exception.Failure
import rustam.urazov.fitnesskit.core.functional.Either
import rustam.urazov.fitnesskit.core.functional.map
import rustam.urazov.fitnesskit.core.platform.NetworkHandler
import rustam.urazov.fitnesskit.data.FitnessKitService
import rustam.urazov.fitnesskit.data.models.toData
import rustam.urazov.fitnesskit.domain.models.Data
import javax.inject.Inject

class LessonsRepositoryImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val service: FitnessKitService
) : LessonsRepository {

    override suspend fun getLessons(clubId: String): Either<Failure, Data> =
        when (networkHandler.isNetworkAvailable()) {
            true -> service.getLessons(clubId).map { dataResponse -> dataResponse.toData() }
            false -> Either.Left(Failure.NetworkConnection)
        }

}
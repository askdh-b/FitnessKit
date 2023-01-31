package rustam.urazov.fitnesskit.data.network

import retrofit2.Retrofit
import rustam.urazov.fitnesskit.core.exception.Failure
import rustam.urazov.fitnesskit.core.functional.Either
import rustam.urazov.fitnesskit.data.network.models.DataResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FitnessKitService @Inject constructor(retrofit: Retrofit) : FitnessKitApi {

    private val fitnessKitApi by lazy { retrofit.create(FitnessKitApi::class.java) }

    override suspend fun getLessons(clubId: String): Either<Failure, DataResponse> =
        fitnessKitApi.getLessons(clubId)

}
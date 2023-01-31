package rustam.urazov.fitnesskit.data

import retrofit2.http.GET
import retrofit2.http.Query
import rustam.urazov.fitnesskit.core.exception.Failure
import rustam.urazov.fitnesskit.core.functional.Either
import rustam.urazov.fitnesskit.data.models.DataResponse

internal interface FitnessKitApi {

    companion object {
        private const val CLUB_ID = "club_id"
    }

    @GET("get_v3/")
    suspend fun getLessons(@Query(CLUB_ID) clubId: String): Either<Failure, DataResponse>
}
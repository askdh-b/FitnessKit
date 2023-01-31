package rustam.urazov.fitnesskit.data.network.repositories

import rustam.urazov.fitnesskit.core.exception.Failure
import rustam.urazov.fitnesskit.core.functional.Either
import rustam.urazov.fitnesskit.core.functional.map
import rustam.urazov.fitnesskit.core.platform.NetworkHandler
import rustam.urazov.fitnesskit.data.network.FitnessKitService
import rustam.urazov.fitnesskit.data.network.models.toData
import rustam.urazov.fitnesskit.data.storage.LessonEntity
import rustam.urazov.fitnesskit.data.storage.LessonsDao
import rustam.urazov.fitnesskit.domain.models.Lesson
import rustam.urazov.fitnesskit.domain.models.toLessonEntity
import javax.inject.Inject

class LessonsRepositoryImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val service: FitnessKitService,
    private val dao: LessonsDao
) : LessonsRepository {

    override suspend fun getLessons(clubId: String): Either<Failure, List<Lesson>> = try {
        val lessons = getLessons()
        when (lessons.isEmpty()) {
            true -> when (networkHandler.isNetworkAvailable()) {
                true -> {
                    val result = service.getLessons(clubId).map { dataResponse -> dataResponse.toData().lessons }
                    when (result.isRight) {
                        true -> saveLessons((result as Either.Right).b.map { it.toLessonEntity() })
                        false -> Either.Left(Failure.NoDataError)
                    }
                    result
                }
                false -> Either.Left(Failure.NetworkConnection)
            }
            false -> Either.Right(getLessons().map { toLesson(it) })
        }


    } catch (e: Exception) {
        Either.Left(Failure.NoDataError)
    }
    private suspend fun getLessons(): List<LessonEntity> = dao.getLessons()

    private suspend fun saveLessons(lessons: List<LessonEntity>) = dao.insertLessons(lessons)

    private fun toLesson(lessonEntity: LessonEntity): Lesson = Lesson(
        id = lessonEntity.lessonId,
        trainer = lessonEntity.trainer,
        name = lessonEntity.name,
        place = lessonEntity.place,
        startTime = lessonEntity.startTime,
        endTime = lessonEntity.endTime,
        date = lessonEntity.date,
        color = lessonEntity.color
    )

}
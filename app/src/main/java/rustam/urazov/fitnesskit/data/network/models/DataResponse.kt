package rustam.urazov.fitnesskit.data.network.models

import com.google.gson.annotations.SerializedName
import rustam.urazov.fitnesskit.domain.models.Data
import rustam.urazov.fitnesskit.domain.models.Lesson

data class DataResponse(
    @SerializedName("trainers") val trainers: List<TrainerResponse>,
    @SerializedName("lessons") val lessons: List<LessonResponse>
)

fun DataResponse.toData(): Data {
    val lessons = mutableListOf<Lesson>()
    for (lesson in this.lessons) {
        lessons.add(Lesson(
            id = lesson.appointmentId,
            trainer = this.trainers.find { it.id == lesson.coachId }?.fullName.orEmpty(),
            name = lesson.tab,
            place = lesson.place,
            startTime = lesson.startTime,
            endTime = lesson.endTime,
            date = lesson.date,
            color = lesson.color
        ))
    }
    return Data(lessons)
}
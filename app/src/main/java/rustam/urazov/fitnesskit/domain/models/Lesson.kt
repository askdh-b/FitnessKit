package rustam.urazov.fitnesskit.domain.models

import rustam.urazov.fitnesskit.data.storage.LessonEntity

data class Lesson(
    val id: String,
    val trainer: String,
    val name: String,
    val place: String,
    val startTime: String,
    val endTime: String,
    val date: String,
    val color: String
)

fun Lesson.toLessonEntity(): LessonEntity = LessonEntity(
    lessonId = id,
    trainer = trainer,
    name = name,
    place = place,
    startTime = startTime,
    endTime = endTime,
    date = date,
    color = color
)
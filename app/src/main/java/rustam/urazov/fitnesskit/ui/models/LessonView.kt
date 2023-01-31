package rustam.urazov.fitnesskit.ui.models

import java.util.Date

data class LessonView(
    val startTime: String,
    val endTime: String,
    val lessonName: String,
    val trainerName: String,
    val color: String,
    val location: String,
    val date: Date?
)
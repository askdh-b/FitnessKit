package rustam.urazov.fitnesskit.ui.models

data class LessonView(
    val startTime: String,
    val endTime: String,
    val lessonName: String,
    val trainerName: String,
    val color: Int,
    val location: String
)
package rustam.urazov.fitnesskit.domain.models

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
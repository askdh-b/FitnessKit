package rustam.urazov.fitnesskit.ui.models

data class TimetableView(
    val lessons: List<LessonView>,
    val date: String?
)
package rustam.urazov.fitnesskit.domain.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import rustam.urazov.fitnesskit.core.platform.BaseViewModel
import rustam.urazov.fitnesskit.domain.models.Data
import rustam.urazov.fitnesskit.domain.useCases.GetLessons
import rustam.urazov.fitnesskit.ui.models.LessonView
import rustam.urazov.fitnesskit.ui.models.TimetableView
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class LessonsViewModel @Inject constructor(
    private val getLessons: GetLessons
) : BaseViewModel() {

    private val mutableLessonsList: MutableLiveData<List<TimetableView>> = MutableLiveData()
    val lessonsList: LiveData<List<TimetableView>> = mutableLessonsList

    fun getLessons(clubId: String) = getLessons(GetLessons.Params(clubId), viewModelScope) {
        it.fold(
            ::handleFailure,
            ::handleLessons
        )
    }

    private fun handleLessons(data: Data) {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")

        val lessons = data.lessons.map { lesson ->
            LessonView(
                startTime = lesson.startTime,
                endTime = lesson.endTime,
                lessonName = lesson.name,
                trainerName = lesson.trainer,
                color = lesson.color,
                location = lesson.place,
                date = formatter.parse("${lesson.date} ${lesson.startTime}")
            )
        }.sortedBy { it.date }

        val format = SimpleDateFormat("EEEE, dd MMMM", Locale("ru"))
        val dates = mutableListOf<String?>()

        lessons.forEach { lesson ->
            if (!dates.contains(lesson.date?.let { format.format(it) })) dates.add(lesson.date?.let {
                format.format(
                    it
                )
            })
        }

        val timetables = mutableListOf<TimetableView>()

        dates.forEach { date ->
            timetables.add(
                TimetableView(
                    lessons = lessons.filter { it.date?.let { format.format(it) } == date },
                    date = date
                )
            )
        }

        mutableLessonsList.value = timetables
    }

}
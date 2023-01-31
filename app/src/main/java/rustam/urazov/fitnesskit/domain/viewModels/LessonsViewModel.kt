package rustam.urazov.fitnesskit.domain.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import rustam.urazov.fitnesskit.core.platform.BaseViewModel
import rustam.urazov.fitnesskit.domain.models.Data
import rustam.urazov.fitnesskit.domain.useCases.GetLessons
import rustam.urazov.fitnesskit.ui.models.LessonView
import javax.inject.Inject

@HiltViewModel
class LessonsViewModel @Inject constructor(
    private val getLessons: GetLessons
) : BaseViewModel() {

    private val mutableLessonsList: MutableLiveData<List<LessonView>> = MutableLiveData()
    val lessonsList: LiveData<List<LessonView>> = mutableLessonsList

    fun getLessons(clubId: String) = getLessons(GetLessons.Params(clubId), viewModelScope) {
        it.fold(
            ::handleFailure,
            ::handleLessons
        )
    }

    private fun handleLessons(data: Data) {
        mutableLessonsList.value = data.lessons.map { lesson -> LessonView(
            startTime = lesson.startTime,
            endTime = lesson.endTime,
            lessonName = lesson.name,
            trainerName = lesson.trainer,
            color = lesson.color,
            location = lesson.place
        ) }
    }

}
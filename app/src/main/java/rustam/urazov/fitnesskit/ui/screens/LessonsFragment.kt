package rustam.urazov.fitnesskit.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import rustam.urazov.fitnesskit.R
import rustam.urazov.fitnesskit.core.exception.Failure
import rustam.urazov.fitnesskit.core.extension.failure
import rustam.urazov.fitnesskit.core.extension.observe
import rustam.urazov.fitnesskit.domain.viewModels.LessonsViewModel
import rustam.urazov.fitnesskit.ui.adapters.LessonAdapter
import rustam.urazov.fitnesskit.ui.models.LessonView

@AndroidEntryPoint
class LessonsFragment : Fragment(R.layout.fragment_lessons) {

    private val lessonsViewModel by viewModels<LessonsViewModel>()
    private lateinit var rvLessons: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(lessonsViewModel) {
            observe(lessonsList, ::renderLessonsList)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvLessons = view.findViewById(R.id.rvTimetable)

        rvLessons.layoutManager = LinearLayoutManager(context)

        lessonsViewModel.getLessons("2")

    }

    private fun renderLessonsList(lessons: List<LessonView>?) {
        lessons?.let {
            rvLessons.adapter = LessonAdapter(it)
        }
    }
    private fun handleFailure(failure: Failure?) {
        when (failure) {
            Failure.NetworkConnection -> {}
            Failure.NoDataError -> {}
            is Failure.ServerError -> {}
            Failure.UnexpectedError -> {}
            null -> {}
        }
    }
}
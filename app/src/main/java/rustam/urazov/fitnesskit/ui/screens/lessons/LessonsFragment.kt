package rustam.urazov.fitnesskit.ui.screens.lessons

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import rustam.urazov.fitnesskit.R
import rustam.urazov.fitnesskit.ui.adapters.LessonAdapter
import rustam.urazov.fitnesskit.ui.models.LessonView

class LessonsFragment : Fragment(R.layout.fragment_lessons) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = requireContext()

        val rvLessons = view.findViewById<RecyclerView>(R.id.rvTimetable)

        rvLessons.layoutManager = LinearLayoutManager(context)

        val lessons = mutableListOf<LessonView>()
        lessons.add(
            LessonView(
                "asd",
                "asd",
                "asd",
                "asd",
                ContextCompat.getColor(context, R.color.black_overlay),
                "asd"
            )
        )
        lessons.add(
            LessonView(
                "asd",
                "asd",
                "asd",
                "asd",
                ContextCompat.getColor(context, R.color.black_overlay),
                "asd"
            )
        )
        lessons.add(
            LessonView(
                "asd",
                "asd",
                "asd",
                "asd",
                ContextCompat.getColor(context, R.color.black_overlay),
                "asd"
            )
        )
        rvLessons.adapter = LessonAdapter(lessons)
    }

}
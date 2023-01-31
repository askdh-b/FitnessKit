package rustam.urazov.fitnesskit.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import rustam.urazov.fitnesskit.R
import rustam.urazov.fitnesskit.ui.models.LessonView

class LessonsAdapter(
    private val lessons: List<LessonView>
) : RecyclerView.Adapter<LessonsAdapter.LessonViewHolder>() {

    class LessonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val vLeft: View = itemView.findViewById(R.id.vLeft)
        val tvStartTime: AppCompatTextView = itemView.findViewById(R.id.tvStartTime)
        val tvEndTime: AppCompatTextView = itemView.findViewById(R.id.tvEndTime)
        val tvLessonName: AppCompatTextView = itemView.findViewById(R.id.tvLessonName)
        val tvTrainerName: AppCompatTextView = itemView.findViewById(R.id.tvTrainerName)
        val tvLocation: AppCompatTextView = itemView.findViewById(R.id.tvLocation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_lesson, parent, false)
        return LessonViewHolder(itemView)
    }

    override fun getItemCount(): Int = lessons.size

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.tvStartTime.text = lessons[position].startTime
        holder.tvEndTime.text = lessons[position].endTime
        holder.tvLessonName.text = lessons[position].lessonName
        holder.tvTrainerName.text = lessons[position].trainerName
        holder.tvLocation.text = lessons[position].location
        holder.vLeft.setBackgroundColor(Color.parseColor(lessons[position].color))
    }

}
package rustam.urazov.fitnesskit.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import rustam.urazov.fitnesskit.R
import rustam.urazov.fitnesskit.ui.models.TimetableView

class TimetableAdapter(
    private val timetables: List<TimetableView>,
) :
    RecyclerView.Adapter<TimetableAdapter.TimetableViewHolder>() {

    class TimetableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDate: AppCompatTextView = itemView.findViewById(R.id.tvDate)
        val rvLessons: RecyclerView = itemView.findViewById(R.id.rvLessons)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimetableViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_date, parent, false)
        return TimetableViewHolder(itemView)
    }

    override fun getItemCount(): Int = timetables.size

    override fun onBindViewHolder(holder: TimetableViewHolder, position: Int) {
        holder.tvDate.text = timetables[position].date
        holder.rvLessons.layoutManager = LinearLayoutManager(holder.rvLessons.context)
        holder.rvLessons.adapter = LessonsAdapter(timetables[position].lessons)
    }

}
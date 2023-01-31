package rustam.urazov.fitnesskit.data.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import rustam.urazov.fitnesskit.core.extension.empty

@Entity(tableName = "Lessons")
data class LessonEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "lessonId") val id: Int = 0,
    @ColumnInfo(name = "id") val lessonId: String = String.empty(),
    @ColumnInfo(name = "trainer") val trainer: String = String.empty(),
    @ColumnInfo(name = "name") val name: String = String.empty(),
    @ColumnInfo(name = "place") val place: String = String.empty(),
    @ColumnInfo(name = "startTime") val startTime: String = String.empty(),
    @ColumnInfo(name = "endTime") val endTime: String = String.empty(),
    @ColumnInfo(name = "date") val date: String = String.empty(),
    @ColumnInfo(name = "color") val color: String = String.empty()
)
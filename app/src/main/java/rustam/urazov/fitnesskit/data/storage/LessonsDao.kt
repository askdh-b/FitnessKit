package rustam.urazov.fitnesskit.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LessonsDao {

    @Insert
    suspend fun insertLessons(lessons: List<LessonEntity>)

    @Query("SELECT * FROM Lessons")
    suspend fun getLessons(): List<LessonEntity>

}
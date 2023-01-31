package rustam.urazov.fitnesskit.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LessonEntity::class], version = 1)
abstract class LessonsDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "lessonsDb"
    }

    abstract fun getLessonsDao(): LessonsDao
}
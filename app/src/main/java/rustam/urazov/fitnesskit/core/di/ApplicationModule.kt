package rustam.urazov.fitnesskit.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rustam.urazov.fitnesskit.data.network.FitnessKitCallAdapterFactory
import rustam.urazov.fitnesskit.data.network.repositories.LessonsRepository
import rustam.urazov.fitnesskit.data.network.repositories.LessonsRepositoryImpl
import rustam.urazov.fitnesskit.data.storage.LessonEntity
import rustam.urazov.fitnesskit.data.storage.LessonsDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    companion object {
        private const val FITNESS_KIT_BASE_URL =
            "https://olimpia.fitnesskit-admin.ru/schedule/"
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(FITNESS_KIT_BASE_URL)
        .addCallAdapterFactory(FitnessKitCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providesLessonsRepository(lessonsRepository: LessonsRepositoryImpl): LessonsRepository =
        lessonsRepository

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LessonsDatabase =
        Room.databaseBuilder(context, LessonsDatabase::class.java, LessonsDatabase.DB_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideLessonsDao(db: LessonsDatabase) = db.getLessonsDao()

    @Provides
    fun provideLessonEntity() = LessonEntity()

}
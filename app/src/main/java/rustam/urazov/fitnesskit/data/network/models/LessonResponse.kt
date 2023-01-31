package rustam.urazov.fitnesskit.data.network.models

import com.google.gson.annotations.SerializedName

data class LessonResponse(
    @SerializedName("place") val place: String,
    @SerializedName("coach_id") val coachId: String,
    @SerializedName("startTime") val startTime: String,
    @SerializedName("endTime") val endTime: String,
    @SerializedName("date") val date: String,
    @SerializedName("color") val color: String,
    @SerializedName("appointment_id") val appointmentId: String,
    @SerializedName("tab") val tab: String
)
package rustam.urazov.fitnesskit.data.models

import com.google.gson.annotations.SerializedName

data class TrainerResponse(
    @SerializedName("id") val id: String,
    @SerializedName("full_name") val fullName: String
)
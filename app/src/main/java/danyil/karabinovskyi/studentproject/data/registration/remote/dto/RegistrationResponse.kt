package danyil.karabinovskyi.studentproject.data.registration.remote.dto

import com.google.gson.annotations.SerializedName

data class RegistrationResponse (
    @SerializedName("token") var token: String? = null,
)
package danyil.karabinovskyi.studentproject.domain.login.requests

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("code") val email: String,
    @SerializedName("password") val password: String
)
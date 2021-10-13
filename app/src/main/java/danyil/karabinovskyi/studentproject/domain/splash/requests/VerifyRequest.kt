package danyil.karabinovskyi.studentproject.domain.splash.requests

import com.google.gson.annotations.SerializedName

data class VerifyRequest (
        @SerializedName("token") val ticket: String = "",
)
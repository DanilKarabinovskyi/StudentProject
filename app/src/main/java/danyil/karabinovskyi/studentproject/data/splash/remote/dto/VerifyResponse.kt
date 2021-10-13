package danyil.karabinovskyi.studentproject.data.splash.remote.dto

import com.google.gson.annotations.SerializedName

data class VerifyResponse(
        @SerializedName("verified") var token: Boolean,
)

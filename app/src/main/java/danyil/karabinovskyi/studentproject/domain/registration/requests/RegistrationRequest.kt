package danyil.karabinovskyi.studentproject.domain.registration.requests

import com.google.gson.annotations.SerializedName

data class RegistrationRequest(
    @SerializedName("ticket") val ticket: String = "",
    @SerializedName("password") val password: String = "",
    @SerializedName("first_name") val firstName: String = "",
    @SerializedName("last_name") val lastName: String = "",
    @SerializedName("university") val university: String = "",
    @SerializedName("group") val group: String = "",
    @SerializedName("email") val email: String = "",
)
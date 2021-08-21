package danyil.karabinovskyi.studentproject.base

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    val messageTextData = SingleLiveEvent<String?>()
    val messageResData = SingleLiveEvent<Int?>()


    /**
     * Shows message by string
     * @param message
     */
    fun showMessage(message: String?) {
        messageTextData.value = message
    }

    /**
     * Shows message by string resource
     * @param messageId
     */
    fun showMessage(@StringRes messageId: Int) {
        messageResData.value = messageId
    }


//    fun Throwable.parseResponseError(): ParsedError {
//        return when {
//            this is HttpException -> {
//                if (this.message?.trim() == "HTTP 429" || this.message?.trim() == "HTTP 500") {
//                    ParsedError(errorResId = R.string.http429_msg)
//                } else {
//                    Timber.e(this)
//                    ParsedError(error = this.message)
//                }
//
//            }
//            this is FirebaseAuthInvalidCredentialsException -> {
//                ParsedError(errorResId = R.string.firebase_auth_invalid_credentials_exception)
//            }
//            this is FirebaseAuthInvalidUserException -> {
//                ParsedError(errorResId = R.string.firebase_auth_invalid_user_exception)
//
//            }
//            this is FirebaseTooManyRequestsException -> {
//                ParsedError(errorResId = R.string.http429_msg)
//            }
//            this is ServerException -> {
//                this.errors?.parseServerError() ?: ParsedError(error = "")
//            }
//            this is UndeliverableException -> {
//                if (this.message?.trim()?.contains(
//                        "FirebaseTooManyRequestsException",
//                        true
//                    ) == true
//                ) {
//                    ParsedError(errorResId = R.string.http429_msg)
//                } else {
//                    Timber.e(this)
//                    ParsedError(error = this.message)
//                }
//
//            }
//            this is FirebaseAuthUserCollisionException -> {
//                ParsedError(errorResId = R.string.user_exists_error_msg)
//            }
//            this is RuntimeException -> {
//                when (this.message) {
//                    "com.google.firebase.FirebaseException: An internal error has occurred. [ 7: ]" -> {
//                        ParsedError(errorResId = R.string.no_internet_connection)
//                    }
//                    "com.google.firebase.FirebaseNetworkException: A network error (such as timeout, interrupted connection or unreachable host) has occurred." -> {
//                        ParsedError(errorResId = R.string.no_internet_connection)
//                    }
//                    else -> {
//                        if (this.message?.contains("TimeoutException") == true)
//                            ParsedError(errorResId = R.string.no_internet_or_slow)
//                        else
//                            ParsedError(error = this.message)
//                    }
//                }
//            }
//
//            this is SocketTimeoutException -> {
//                ParsedError(errorResId = R.string.slow_internet)
//            }
//            this is UnknownHostException -> {
//                ParsedError(errorResId = R.string.no_internet_connection)
//
//            }
//            this is TimeoutException -> {
//                ParsedError(errorResId = R.string.no_internet_or_slow)
//            }
//            this.message?.contains("FirebaseAuthInvalidUserException") == true -> {
//                ParsedError(errorResId = R.string.firebase_auth_invalid_user_exception)
//
//            }
//            this.message?.contains("FirebaseNetworkException") == true -> {
//                if (this@BaseViewModel !is SplashViewModel)
//                    ParsedError(errorResId = R.string.no_internet_connection)
//                else {
//                    ParsedError(errorResId = R.string.no_internet_connection)
//                }
//            }
//            this is FirebaseNetworkException -> {
//                if (this@BaseViewModel !is SplashViewModel)
//                    ParsedError(errorResId = R.string.no_internet_connection)
//                else {
//                    ParsedError(errorResId = R.string.no_internet_connection)
//                }
//            }
//            this is FirebaseException -> {
//                if (this.message == "An internal error has occurred. [ 7: ]") {
//                    ParsedError(errorResId = R.string.no_internet_connection)
//                } else {
//                    ParsedError(error = this.message)
//                }
//            }
//            this is ConnectException -> {
//                ParsedError(errorResId = R.string.no_internet_connection)
//            }
//            this is FirebaseNetworkException -> {
//                ParsedError(errorResId = R.string.no_internet_connection)
//            }
//            else -> ParsedError(
//                error =
//                this.message?.capitalize()
//            )
//        }
//    }
//
//    fun ServerError.parseServerError(): ParsedError {
//
//        return when (this.id) {
//            "INVALID_PIN" -> ParsedError(errorResId = R.string.invalid_pin_error)
//            "CASH_REGISTER_EXISTS" -> ParsedError(errorResId = R.string.cash_exists_error_msg)
//            "WORKER_EXISTS" -> ParsedError(errorResId = R.string.worker_exist)
//            "HAVE_GOOD" -> ParsedError(errorResId = R.string.category_cannot_be_deleted_if_it_has_a_product)
//            "HAVE_SHIFT" -> ParsedError(errorResId = R.string.have_shift)
//            "PASSWORD" -> ParsedError(errorResId = R.string.key_password_error)
//            "CAID" -> ParsedError(errorResId = R.string.key_ca_id_error)
//            "ERROR_VEREFY" -> ParsedError(errorResId = R.string.verify_error)
//            "ERROR_SAVE" -> ParsedError(errorResId = R.string.error_save)
//            "ERROR_UNKNOWN" -> ParsedError(errorResId = R.string.error_unknown)
//            "ERROR_TYPE" -> ParsedError(errorResId = R.string.error_type)
//            "ERROR_NOT_PREV_ZREPORT" -> ParsedError(errorResId = R.string.error_not_preview_z_report)
//            "ERROR_XML" -> ParsedError(errorResId = R.string.xml_error)
//            "ERROR_XML_DATE" -> ParsedError(errorResId = R.string.xml_date_error)
//            "ERROR_XML_CHK" -> ParsedError(errorResId = R.string.check_xml_error)
//            "ERROR_XML_ZREPORT" -> ParsedError(errorResId = R.string.z_report_xml_error)
//            "ERROR_OFFLINE_168" -> ParsedError(errorResId = R.string.error_offline_168)
//            "ERROR_BAD_HASH_PREV" -> ParsedError(errorResId = R.string.error_bad_hash_preview)
//            "ERROR_NOT_REGISTERED_RRO" -> ParsedError(errorResId = R.string.prro_not_registered)
//            "ERROR_NOT_REGISTERED_SIGNER" -> ParsedError(errorResId = R.string.signer_not_registered)
//            "ERROR_NOT_OPEN_SHIFT" -> ParsedError(errorResId = R.string.shift_not_open)
//            "UNAVAILABLE" -> ParsedError(errorResId = R.string.sts_server_error)
//            "ERROR_OFFLINE_ID" -> ParsedError(errorResId = R.string.error_offline_id)
//            "SMS_ENDED" -> ParsedError(errorResId = R.string.error_sms_ended)
//            "ERROR_CHECK" -> if (this.message.contains("shift is already open")) ParsedError(
//                errorResId = R.string.have_shift
//            ) else if (this.message.contains("shift on another device")) ParsedError(errorResId = R.string.shift_is_opened)
//            else ParsedError(error = this.message)
//            "ERROR_INN" -> ParsedError(errorResId = R.string.invalid_inn_msg)
//            "YOU_SCORE" -> ParsedError(errorResId = R.string.you_score_down_msg)
//            "CASH" -> ParsedError(errorResId = R.string.not_enough_cash)
//            "EMPTY_FILE" -> ParsedError(errorResId = R.string.empty_file)
//            "TOO_MUCH_ERROR" -> ParsedError(errorResId = R.string.too_much_errors)
//            "IMPOSSIBLE_DELETE_CASH_REGISTER_BY_OPEN_SHIFT" -> ParsedError(errorResId = R.string.impossible_delete_cash_error)
//            else -> ParsedError(error = this.message)
//        }
//    }

}
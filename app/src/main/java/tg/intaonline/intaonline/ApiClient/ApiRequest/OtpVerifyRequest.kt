package tg.intaonline.intaonline.ApiClient.ApiRequest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OtpVerifyRequest {
    @SerializedName("otp")
    @Expose
    var otp : String? = null

    @SerializedName("compte_user_mail")
    @Expose
    var email : String? = null

}
package tg.intaonline.intaonline.ApiClient.ApiRequest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginRequest {
    @SerializedName("compte_user_mail")
    @Expose
    var username : String? = null

    @SerializedName("compte_password")
    @Expose
    var password : String? = null

}
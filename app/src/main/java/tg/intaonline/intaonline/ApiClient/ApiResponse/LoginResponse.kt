package tg.intaonline.intaonline.ApiClient.ApiResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponse {

    @SerializedName("compte_user_mail")
    @Expose
    val username : String? = null

    @SerializedName("compte_password")
    @Expose
    val password : String? = null

    @SerializedName("success")
    @Expose
    val success : String? = null

    @SerializedName("message")
    @Expose
    val message : String? = null


}
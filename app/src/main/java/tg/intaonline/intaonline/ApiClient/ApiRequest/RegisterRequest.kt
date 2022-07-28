package tg.intaonline.intaonline.ApiClient.ApiRequest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterRequest {
    @SerializedName("compte_user_mail")
    @Expose
    var usermail : String? = null

    @SerializedName("compte_password")
    @Expose
    var password : String? = null

    @SerializedName("compte_nom")
    @Expose
    var nomuser : String? = null

    @SerializedName("compte_prenom")
    @Expose
    var prenomuser : String? = null
}
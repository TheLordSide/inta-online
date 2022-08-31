package tg.intaonline.intaonline.ApiClient.ApiResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Liste(
    @SerializedName("cours_auteur")
    @Expose
    val cours_auteur: String ? = null,

    @SerializedName("cours_description")
    @Expose
    val cours_description: String ? = null,

    @SerializedName("cours_id")
    @Expose
    val cours_id: Int ? = null,

    @SerializedName("cours_image")
    @Expose
    val cours_image: String ? = null,

    @SerializedName("cours_module")
    @Expose
    val cours_module: String ? = null,

    @SerializedName("cours_nom")
    @Expose
    val cours_nom: String ? = null,

    @SerializedName("cours_prix")
    @Expose
    val cours_prix: String ? = null,

    @SerializedName("cours_prix2")
    @Expose
    val cours_prix2: String ? = null,

    @SerializedName("cours_serial")
    @Expose
    val cours_serial: String ? = null,

    @SerializedName("cours_volumeh")
    @Expose
    val cours_volumeh: String ? = null,

)
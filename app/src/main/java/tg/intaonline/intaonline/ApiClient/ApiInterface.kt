package tg.intaonline.intaonline.ApiClient

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import tg.intaonline.intaonline.ApiClient.ApiResponse.LoginResponse


interface ApiInterface {
    @FormUrlEncoded
        @POST("compte/signup.php")
         fun login(
        @Field("compte_user_mail") username: String?,
        @Field("compte_password") password: String?
        ): Call<LoginResponse>



}
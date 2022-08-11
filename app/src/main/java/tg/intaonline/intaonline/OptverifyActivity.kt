package tg.intaonline.intaonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tg.intaonline.intaonline.ApiClient.ApiRequest.OtpVerifyRequest
import tg.intaonline.intaonline.ApiClient.ApiResponse.OtpVerifyresponse
import tg.intaonline.intaonline.ApiClient.service.ApiClient
import tg.intaonline.intaonline.ApiClient.service.ApiInterface
import tg.intaonline.intaonline.Model.Globalvariables

class OptverifyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_optverify)

        val otpbutn = findViewById<Button>(R.id.verify)
        otpbutn.setOnClickListener {
            confirmation()
        }
    }

   private fun confirmation () {
        var otp = findViewById<EditText>(R.id.otpverifytext)
        var errorotp = findViewById<TextInputLayout>(R.id.OTPtext)
        val bundle: Bundle?=intent.extras
        val mail= bundle!!.getString("messagetopasse")
        val request= OtpVerifyRequest()
        request.otp = otp.text.toString().trim()
        request.email=mail
        val api = ApiClient().getretrofit().create(ApiInterface::class.java)
        api.otpverify(request.email,request.otp).enqueue(object : Callback<OtpVerifyresponse> {
            override fun onResponse(
                call: Call<OtpVerifyresponse>,
                response: Response<OtpVerifyresponse>
            ) {
                val message = response.body()?.message
                val success = response.body()?.success

                if(response.isSuccessful){

                    if(success=="true"){

                        val intent = Intent(applicationContext,MainActivity::class.java)
                        startActivity(intent)
                        finish()
                        Toast.makeText(applicationContext,message.toString(),Toast.LENGTH_LONG).show()

                    }
                    else{
                        Toast.makeText(applicationContext,message.toString(),Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<OtpVerifyresponse>, t: Throwable) {
                val message= t.localizedMessage
                Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}


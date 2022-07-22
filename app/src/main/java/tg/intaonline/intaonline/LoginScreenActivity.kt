package tg.intaonline.intaonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tg.intaonline.intaonline.ApiClient.ApiInterface
import tg.intaonline.intaonline.ApiClient.ApiRequest.LoginRequest
import tg.intaonline.intaonline.ApiClient.ApiRequest.LoginResponse
import tg.intaonline.intaonline.ApiClient.service.ApiClient

class LoginScreenActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        val connectbtn = findViewById<Button>(R.id.Connexion)


      connectbtn.setOnClickListener{
      //  val itent = Intent(this,MainActivity::class.java)
      //    startActivity(itent)
          verificationChamps()
      }


    }

    private fun verificationChamps(){
        var email = findViewById<EditText>(R.id.usermail)
        var pass = findViewById<EditText>(R.id.userPass)
        var errortext = findViewById<TextInputLayout>(R.id.UserName)
        var errortext2 = findViewById<TextInputLayout>(R.id.PassWord)
        if (TextUtils.isEmpty(email.text)){

            errortext.error = "Email vide"
        }
        else{

            errortext.isErrorEnabled =false
        }

        if (TextUtils.isEmpty(pass.text)){

            errortext2.error = "Mot de passe vide"
        }
        else{
            errortext2.isErrorEnabled =false
        }
        val request=LoginRequest()
        //recuperer les edit dans la classe loginrequest
        request.username = email.text.toString().trim()
        request.password = pass.text.toString().trim()

        val api = ApiClient().getretrofit().create(ApiInterface::class.java)
        //passez en Param
        api.login(request.username,request.password)?.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                val message = response.body()?.message
                if(response.isSuccessful){
                   // val itent = Intent(applicationContext,MainActivity::class.java)
                     //   startActivity(itent)
                    Toast.makeText(applicationContext,message.toString(),Toast.LENGTH_SHORT).show()
                }
                else{
                }

            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                   val message= t.localizedMessage
                Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()

            }

        })

    }
}


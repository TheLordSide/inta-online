package tg.intaonline.intaonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserManager
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.asLiveData
import androidx.lifecycle.observe
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tg.intaonline.intaonline.ApiClient.service.ApiInterface
import tg.intaonline.intaonline.ApiClient.ApiRequest.LoginRequest
import tg.intaonline.intaonline.ApiClient.ApiResponse.LoginResponse
import tg.intaonline.intaonline.ApiClient.service.ApiClient
import tg.intaonline.intaonline.CustomClass.UserPreferences

class LoginScreenActivity : AppCompatActivity() {
    lateinit var userPreferences : UserPreferences
    var mail = ""
    var passw = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        val connectbtn = findViewById<Button>(R.id.Connexion)
        val registerbtn = findViewById<Button>(R.id.Inscription)
        userPreferences = UserPreferences(this)

      registerbtn.setOnClickListener{
        val itent = Intent(this,RegisterScreenActivity::class.java)
          startActivity(itent)

      }

      connectbtn.setOnClickListener{
      //  val itent = Intent(this,MainActivity::class.java)
      //    startActivity(itent)
          login()

      }


    }

    private fun login(){
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
                val success = response.body()?.success
                if(response.isSuccessful){
                    if(success=="true"){
                        GlobalScope.launch {
                            userPreferences.storeUser(mail,passw)
                        }
                        val intent = Intent(applicationContext,MainActivity::class.java)
                        startActivity(intent)
                        finish()
                        mail = email.text.toString()
                        passw = pass.text.toString()


                        Toast.makeText(applicationContext,message.toString(),Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(applicationContext,message.toString(),Toast.LENGTH_SHORT).show()
                    }

                }

            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                   val message= t.localizedMessage
                Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()

            }

        })

    }
}


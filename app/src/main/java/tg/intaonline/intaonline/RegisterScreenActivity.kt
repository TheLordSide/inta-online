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
import tg.intaonline.intaonline.ApiClient.ApiRequest.RegisterRequest
import tg.intaonline.intaonline.ApiClient.ApiResponse.RegisterResponse
import tg.intaonline.intaonline.ApiClient.service.ApiClient
import tg.intaonline.intaonline.ApiClient.service.ApiInterface
import tg.intaonline.intaonline.Model.Globalvariables

class RegisterScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)
        val registerbtn = findViewById<Button>(R.id.Inscription)
        registerbtn.setOnClickListener{

            register()
        }
    }

    private fun register(){
        var nom = findViewById<EditText>(R.id.username)
        var prenom = findViewById<EditText>(R.id.userfirst)
        var mail = findViewById<EditText>(R.id.usermail)
        val message2 = mail.text.toString()
        var mdp = findViewById<EditText>(R.id.userPass)
        var mdpconfirmed = findViewById<EditText>(R.id.userPassconfirmed)
        var errornom = findViewById<TextInputLayout>(R.id.UserName)
        var errorprenom = findViewById<TextInputLayout>(R.id.UserFirstname)
        var errormail = findViewById<TextInputLayout>(R.id.Usermail)
        var errormdp = findViewById<TextInputLayout>(R.id.PassWord)
        var errormdpconfirmed = findViewById<TextInputLayout>(R.id.ConfirmedPassword)
        /*if (TextUtils.isEmpty(nom.text)){

            errornom.error = "Le nom est vide"
        }
        else{

            errornom.isErrorEnabled =false
        }

        if (TextUtils.isEmpty(prenom.text)){

            errorprenom.error = "Le prénom est vide"
        }
        else{
            errorprenom.isErrorEnabled =false
        }

        if (TextUtils.isEmpty(mail.text)){

            errormail.error = "Le mail est vide"
        }
        else{
            errormail.isErrorEnabled =false
        }

        if (TextUtils.isEmpty(mdp.text)){

            errormdp.error = "Le mot de passe est vide"
        }
        else{
            errormail.isErrorEnabled =false
        }

        if (TextUtils.isEmpty(mdpconfirmed.text) ){
            errormdpconfirmed.error = "La confirmation de mot de passe est vide"
        }
        else{
            errormdpconfirmed.isErrorEnabled =false
        }
        */
        val request=RegisterRequest()
        request.nomuser = nom.text.toString().trim()
        request.prenomuser = prenom.text.toString().trim()
        request.password =mdp.text.toString().trim()
        request.usermail =mail.text.toString().trim()
        Globalvariables().emailglobal=mail.text.toString()
        val api = ApiClient().getretrofit().create(ApiInterface::class.java)
        api.register(request.usermail,request.password,request.nomuser,request.prenomuser)?.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                val message = response.body()?.message
                val success = response.body()?.success

                if(response.isSuccessful){

                    if(success=="true"){
                        // A NE PAS TOUCHER
                        Toast.makeText(applicationContext,message.toString(),Toast.LENGTH_LONG).show()
                        val intent = Intent(applicationContext,OptverifyActivity::class.java)
                        intent.putExtra("messagetopasse",message2)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(applicationContext,message.toString(),Toast.LENGTH_LONG).show()
                    }
                }

            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                val message= t.localizedMessage
                Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
            }
        })


    }
}
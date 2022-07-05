package tg.intaonline.intaonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
class LoginScreenActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        val connectbtn = findViewById<Button>(R.id.Connexion)


      connectbtn.setOnClickListener{
        VerificationChamps()
      }


    }

    private fun VerificationChamps(){
        val email = findViewById<EditText>(R.id.usermail)
        val pass = findViewById<EditText>(R.id.userPass)
        val errortext = findViewById<TextInputLayout>(R.id.UserName)
        val errortext2 = findViewById<TextInputLayout>(R.id.PassWord)
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


    }
}


package tg.intaonline.intaonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils

import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginScreenActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        val connectbtn = findViewById<Button>(R.id.Connexion)
        val userNameedit= findViewById<TextInputLayout>(R.id.UserName)

        if(TextUtils.isEmpty(userNameedit.toString())){
            print("fuck")
        }


    }
}
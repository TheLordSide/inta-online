package tg.intaonline.intaonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val ivgo=findViewById<View>(R.id.iv_go)
        ivgo.alpha= 0f
        ivgo.animate().setDuration(2000).alpha(1f).withEndAction{
            val oi =  Intent(this, LoginScreenActivity::class.java)
            startActivity(oi)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}
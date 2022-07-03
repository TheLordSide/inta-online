package tg.intaonline.intaonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //set splashscreen to fullscreen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //animate the logo and launch loginscreen
        val ivgo=findViewById<View>(R.id.iv_go)
        ivgo.alpha= 0f
        ivgo.animate().setDuration(2000).alpha(1f).withEndAction{
            val oi =  Intent(this, MainActivity::class.java)
            startActivity(oi)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}
package tg.intaonline.intaonline.CustomClass

import android.content.Context
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.map
import java.util.concurrent.Flow

class UserPreferences(context: Context) {
    private  val datastore= context.createDataStore(name = "user_log")

    companion object{
        val USER_MAIL_KEY= preferencesKey<String>("USER_MAIL")
        val PASSWORD_KEY= preferencesKey<String>("USER_PASS")
    }

    suspend fun storeUser(email:String,password:String){
       datastore.edit {
           it[USER_MAIL_KEY]=email
           it[PASSWORD_KEY]=password
       }
    }

    val userMailFlow = datastore.data.map {
        it[USER_MAIL_KEY]?:""
    }

    val userPassword = datastore.data.map {
        it[PASSWORD_KEY]?:""
    }
}
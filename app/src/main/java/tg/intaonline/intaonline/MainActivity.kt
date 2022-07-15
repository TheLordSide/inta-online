package tg.intaonline.intaonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridView
import androidx.recyclerview.widget.RecyclerView
import tg.intaonline.intaonline.Adaptater.AdaptateurGrid
import tg.intaonline.intaonline.Model.LanguageItem

class MainActivity : AppCompatActivity() {

    private var arrayList: ArrayList<LanguageItem> ? = null
    private var gridView: GridView? = null
    private var adaptateurgrid: AdaptateurGrid ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.ViewMenu)
        arrayList = ArrayList()
        arrayList = setDataList()
        adaptateurgrid = AdaptateurGrid(applicationContext, arrayList!!)
        gridView?.adapter= adaptateurgrid
   }


    private fun setDataList() : ArrayList<LanguageItem>{
        var arrayList:ArrayList<LanguageItem> = ArrayList()

        arrayList.add(LanguageItem(R.drawable.logo, name = "Acceuei"))
        arrayList.add(LanguageItem(R.drawable.logo, name = "Acceuil"))


        return arrayList
    }


}
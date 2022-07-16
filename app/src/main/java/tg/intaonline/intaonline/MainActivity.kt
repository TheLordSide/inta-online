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

        arrayList.add(LanguageItem(R.drawable.ic_baseline_video_library_24, name = "Cours"))
        arrayList.add(LanguageItem(R.drawable.ic_baseline_category_24, name = "Categories"))
        arrayList.add(LanguageItem(R.drawable.ic_baseline_admin_panel_settings_24, name = "Profil"))
        arrayList.add(LanguageItem(R.drawable.ic_baseline_auto_stories_24, name = "Parcours"))
        return arrayList
    }


}
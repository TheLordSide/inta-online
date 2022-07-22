package tg.intaonline.intaonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import tg.intaonline.intaonline.Adaptater.AdaptateurGrid
import tg.intaonline.intaonline.CustomClass.CustomDIalog
import tg.intaonline.intaonline.Model.LanguageItem

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener{

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
        gridView?.onItemClickListener= this


   }

    private fun setDataList() : ArrayList<LanguageItem>{
        var arrayList:ArrayList<LanguageItem> = ArrayList()
        arrayList.add(LanguageItem(R.drawable.ic_baseline_video_library_24, name = "Cours"))
        arrayList.add(LanguageItem(R.drawable.ic_baseline_category_24, name = "Catégories"))
        arrayList.add(LanguageItem(R.drawable.ic_baseline_admin_panel_settings_24, name = "Profil"))
        arrayList.add(LanguageItem(R.drawable.ic_baseline_auto_stories_24, name = "Parcours"))
        arrayList.add(LanguageItem(R.drawable.ic_baseline_account_circle_24, name = "Compte"))
        return arrayList
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
       var pos: LanguageItem =arrayList!![p2]
        var names =pos.name
        var dial = CustomDIalog()
        if (names=="Catégories") {
            dial.show(supportFragmentManager ,"CUstomg")
        }




    }


}
package tg.intaonline.intaonline.Adaptater

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import tg.intaonline.intaonline.Model.LanguageItem
import tg.intaonline.intaonline.R
import java.util.prefs.Preferences

class AdaptateurGrid(var context: Context, var arrayList: ArrayList<LanguageItem>): BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
       return arrayList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
       var view:View = View.inflate(context, R.layout.grid_layout, null)
       val icons: ImageView = view.findViewById(R.id.TitleImage)
       val names: TextView = view.findViewById(R.id.GridTitle)
       var listItems: LanguageItem= arrayList[p0]

       icons.setImageResource(listItems.icons!!)
       names.text = listItems.name

       return view
    }
}
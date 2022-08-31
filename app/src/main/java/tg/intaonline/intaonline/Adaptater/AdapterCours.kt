package tg.intaonline.intaonline.Adaptater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tg.intaonline.intaonline.ApiClient.ApiResponse.CoursResponse
import tg.intaonline.intaonline.ApiClient.ApiResponse.Liste
import tg.intaonline.intaonline.R

class AdapterCours(private var dataList : ArrayList<Liste>, private val context: Context): RecyclerView.Adapter<AdapterCours.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cours_list,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     val cours = dataList[position]
        holder.courstitle.text = cours.cours_nom
        holder.coursdesc.text = cours.cours_description
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemLayoutView: View):RecyclerView.ViewHolder(itemLayoutView) {
         var courstitle: TextView
         var coursdesc : TextView

        init {
            courstitle=itemLayoutView.findViewById(R.id.titleHolder)
            coursdesc=itemLayoutView.findViewById(R.id.descHolder)
        }
    }
}
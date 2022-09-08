package tg.intaonline.intaonline

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tg.intaonline.intaonline.Adaptater.AdapterCours
import tg.intaonline.intaonline.ApiClient.ApiResponse.CoursRes
import tg.intaonline.intaonline.ApiClient.ApiResponse.CoursResponse
import tg.intaonline.intaonline.ApiClient.ApiResponse.Liste
import tg.intaonline.intaonline.ApiClient.ApiResponse.LoginResponse
import tg.intaonline.intaonline.ApiClient.service.ApiClient
import tg.intaonline.intaonline.ApiClient.service.ApiInterface

class CoursList : AppCompatActivity() {

    var dataList = ArrayList<Liste>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: AdapterCours

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cours_list)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Cours"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)


        recyclerView = findViewById(R.id.recycler_cours)

        //setting up the adapter
        adapter= AdapterCours(dataList,this)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter=adapter
        getData()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getData() {
        val api = ApiClient().getretrofit().create(ApiInterface::class.java)

        api.getcours()?.enqueue(object : Callback<CoursRes> {
            override fun onResponse(call: Call<CoursRes>, response: Response<CoursRes>) {
                val retour = response.body()?.liste
                val message = response.body()?.message
                val success = response.body()?.success
                if(response.isSuccessful){
                    if(success=="true"){
                        dataList.addAll(response.body()!!.liste)
                        recyclerView.adapter?.notifyDataSetChanged()
                        Toast.makeText(applicationContext,message.toString(),Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(applicationContext,message.toString(),Toast.LENGTH_SHORT).show()
                    }

                }
            }

            override fun onFailure(call: Call<CoursRes>, t: Throwable) {
                val message= t.localizedMessage
                Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()

            }

        })

    }
}
package tg.intaonline.intaonline.CustomClass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import tg.intaonline.intaonline.R

class CustomDIalog : DialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var rootview: View = inflater.inflate(R.layout.activity_main_dialog_categories, container,false)
        return rootview
    }
}
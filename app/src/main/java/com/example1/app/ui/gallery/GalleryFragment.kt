package com.example1.app.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example1.app.CustomAdapter
import com.example1.app.R
import com.example1.app.data
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.recycler_inflater.*
import java.util.ArrayList

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
//        val textView: TextView = root.findViewById(R.id.text_gallery)
//        galleryViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        var users = ArrayList<data>()
        users.add(data("Team Head" ,"Mohamed Atef" , R.drawable.atef))
        users.add(data( "Head Vice" ,"Mostafa Aiad" ,R.drawable.aiad))
        users.add(data( "Java Comittee head" ,"Asem" ,R.drawable.asem))
        users.add(data( "Web Comittee Head" ,"Abdullah Ahmed" ,R.drawable.abdulla))
        users.add(data("Electronics Comittee Head" ,"Mohamed Al-Wahsh"  ,R.drawable.abo_ela))
        users.add(data(  "Java Comittee Vice", "Hamza",R.drawable.hamza))
        rec2.layoutManager = LinearLayoutManager(this.context , LinearLayout.HORIZONTAL , false)
        val adapter = CustomAdapter(users)
        rec2.adapter = adapter
        super.onActivityCreated(savedInstanceState)
    }
}
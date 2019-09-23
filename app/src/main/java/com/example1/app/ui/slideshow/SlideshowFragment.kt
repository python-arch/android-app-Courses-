package com.example1.app.ui.slideshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example1.app.Content
import com.example1.app.Map_l
import com.example1.app.R
import com.google.android.gms.maps.SupportMapFragment
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_home_page.view.*
import kotlinx.android.synthetic.main.fragment_slideshow.*

class SlideshowFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel
lateinit var mapFragment: SupportMapFragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProviders.of(this).get(SlideshowViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
//        val textView: TextView = root.findViewById(R.id.text_slideshow)
//        slideshowViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Realm.init(this.context)
        var config = RealmConfiguration.Builder().name("content.realm").build()
        var realm = Realm.getInstance(config)
        realm.beginTransaction()
        var id = realm.where(Content::class.java).findAll().size
        var content1 = realm.createObject(Content::class.java , id+1)
        content1.content = "most of our activities are made in Menofia stem school including sessions and our last event \"face and race\" so you will find a detailed location of the school in the following page"
        realm.commitTransaction()
content_t.text = content1.content.toString()
        map_g.setOnClickListener{
startActivity(Intent(this.context , Map_l::class.java))
        }
        super.onActivityCreated(savedInstanceState)
    }
}
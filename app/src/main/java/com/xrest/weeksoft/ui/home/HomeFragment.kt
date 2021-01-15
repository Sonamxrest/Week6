package com.xrest.weeksoft.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xrest.week6.Class.person
import com.xrest.weeksoft.ui.home.Adapterz
import com.xrest.weeksoft.R

class HomeFragment : Fragment() {

   var adapter : Adapterz? = null
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
       val root = inflater.inflate(R.layout.fragment_home, container, false)
        var rv: RecyclerView = root.findViewById(R.id.rv)
        var adapters = Adapterz(person,container!!.context)
        rv.layoutManager = LinearLayoutManager(container?.context, LinearLayoutManager.VERTICAL,false)
        rv.adapter =adapters
        this.adapter = adapters!!

        return root
    }

}
package com.xrest.week6.Class

import androidx.fragment.app.Fragment

import com.xrest.weeksoft.R
import com.xrest.weeksoft.ui.home.Adapterz
import com.xrest.weeksoft.ui.home.HomeFragment


var person:ArrayList<Person> = ArrayList()

var a = arrayOf("25a","25b","25c")
fun add(){


    person.add(Person("sonam","Shrestha","25a","M","Balaju, Naya Bazar","https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"))
    person.add(Person("Seoran","Shrestha","25a","F","Balaju, Naya Bazar","https://img.pngio.com/female-png-clipart-images-gallery-for-free-download-myreal-clip-female-png-612_710.png"))
    person.add(Person("Bahadur","Shrestha","25a","M","Balaju, Naya Bazar","https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"))


}


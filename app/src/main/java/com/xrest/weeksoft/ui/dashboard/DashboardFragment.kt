package com.xrest.weeksoft.ui.dashboard

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

import com.xrest.week6.Class.Person
import com.xrest.week6.Class.a


import com.xrest.week6.Class.person
import com.xrest.weeksoft.R
import com.xrest.weeksoft.ui.home.HomeFragment

class DashboardFragment : Fragment() {

    lateinit var fname: EditText
    lateinit var lname: EditText
    lateinit var address: EditText
    lateinit var batch: Spinner
    lateinit var male: RadioButton
    lateinit var female: RadioButton
    lateinit var others: RadioButton
    lateinit var add: ImageButton



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        initialize(view)
        add.setOnClickListener() {
            if(validate())
            {
            insert(view)
        }
        }
        return view

    }

    fun initialize(view:View)
    {
        fname = view.findViewById(R.id.fname)
        lname = view.findViewById(R.id.lname)
        address = view.findViewById(R.id.address)
        batch = view.findViewById(R.id.sp)
        male = view.findViewById(R.id.male)
        female = view.findViewById(R.id.female)
        others = view.findViewById(R.id.other)
        add= view.findViewById(R.id.add)
        val adapters = ArrayAdapter(this.requireContext(),android.R.layout.simple_list_item_1, a)
        batch.adapter =adapters


    }



    fun validate():Boolean{
        when {
            TextUtils.isEmpty(fname.text)->
            {
                fname.error = "Username must not be empty"
                fname.requestFocus()
                return false
            }
            TextUtils.isEmpty(lname.text)->
            {
                lname.error = "last Name must not be empty"
                lname.requestFocus()
                return false
            }
            TextUtils.isEmpty(address.text)->
            {
                address.error = "address must not be empty"
                address.requestFocus()
                return false
            }
        }
return true
    }
    fun insert(view:View){
        var gender = "M"
        var img =""
        if(male.isChecked)
        {
            gender ="M"
            img="https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"
            female.isChecked=false
            others.isChecked=false

        }
        if(female.isChecked)
        {
            gender="F"
            img="https://img.pngio.com/female-png-clipart-images-gallery-for-free-download-myreal-clip-female-png-612_710.png"
            male.isChecked=false
            others.isChecked=false
        }
        if(others.isChecked)
        {
            gender="0"
            female.isChecked=false
            male.isChecked=false
        }

        person.add(person.size, Person(fname.text.toString(),lname.text.toString(),batch.selectedItem.toString(),gender,address.text.toString(),img))
        HomeFragment().adapter?.notifyDataSetChanged()
        Toast.makeText(view.context, "Inserted", Toast.LENGTH_SHORT).show()

        clear()

    }

    fun clear(){
        fname.setText(null)
        lname.setText(null)
        male.isChecked =false
        female.isChecked =false
        others.isChecked =false
        address.setText(null)

    }
}
package com.xrest.weeksoft.ui.home

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xrest.week6.Class.Person
import com.xrest.week6.Class.a
import com.xrest.week6.Class.person
import com.xrest.weeksoft.R


class Adapterz(var lst:ArrayList<Person>, var dsf: Context):RecyclerView.Adapter<Adapterz.AdapterViewHolder>(){

    class AdapterViewHolder(view: View):RecyclerView.ViewHolder(view){

         var name:TextView
         var batch:TextView
         var gender:TextView
         var address:TextView
         var del:ImageButton
         var del2:ImageButton
         var img: ImageView
        init{

            name = view.findViewById(R.id.name)
            batch = view.findViewById(R.id.batch)
            gender = view.findViewById(R.id.gender)
            address = view.findViewById(R.id.address)
            del = view.findViewById(R.id.del)
            del2 = view.findViewById(R.id.del2)
            img = view.findViewById(R.id.imageView)

        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(dsf).inflate(R.layout.mero_view,parent,false)
        return AdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
      return lst.size
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val student = lst[position]
        var data = lst[position]
        val dialog = Dialog(dsf)
        dialog.setContentView(R.layout.alert_update)
        dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)

        holder.name.text =student.fname +" "+student.lname
        holder.batch.text = student.batch
        holder.address.text = student.address
        holder.gender.text = student.gender
        Glide.with(dsf).load(student.image).into(holder.img)


        holder.del.setOnClickListener(){
delete(person,position)
        }


        holder.del2.setOnClickListener(){

            var etFn : EditText = dialog.findViewById(R.id.etFn)
            var etFn2: EditText = dialog.findViewById(R.id.etFn2)

            var etAddress : EditText = dialog.findViewById(R.id.etAddress)

            var rgGroup : RadioGroup = dialog.findViewById(R.id.rgGroup)
            var gender = "Male"
            var male:RadioButton = dialog.findViewById(R.id.rbMale)
            var female:RadioButton = dialog.findViewById(R.id.rbFemale)
            var others:RadioButton = dialog.findViewById(R.id.rbOthers)
var sp:Spinner = dialog.findViewById(R.id.sp)
            val adapters = ArrayAdapter(holder.itemView.context,android.R.layout.simple_list_item_1, a)
            sp.adapter =adapters

            var btnUpdate : Button = dialog.findViewById(R.id.btnUpdate)
            var btnCancel : Button = dialog.findViewById(R.id.btnCancel)



                etFn.setText(data.fname)
                etFn2.setText(data.lname)

                etAddress.setText(data.address)

                when(data.gender)
                {
                    "M" -> male.isChecked=true
                    "F" -> female.isChecked =true
                    "O" -> others.isChecked =true
                }
                dialog.show()


            btnUpdate.setOnClickListener {
if(male.isChecked)
{
    gender ="M"
}
                if(female.isChecked)
{
    gender ="F"
}
                if(others.isChecked)
{
    gender ="O"
}
                    person[position].fname = etFn.text.toString()
                    person[position].lname = etFn2.text.toString()
                    person[position].address = etAddress.text.toString()
                    person[position].gender = gender
                when(gender){
                    "M" -> person[position].image="https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"
                    "F" -> person[position].image="https://img.pngio.com/female-png-clipart-images-gallery-for-free-download-myreal-clip-female-png-612_710.png"
                    "O" -> person[position].image =""

                }
                Glide.with(dsf).load(person[position].image).into(holder.img)
                    notifyDataSetChanged()
                    dialog.cancel()

            }
            btnCancel.setOnClickListener {
                dialog.cancel()
            }



            }



    }

    fun delete(person:ArrayList<Person>,position: Int)
    {
        person.removeAt(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, person.size);

    }

}
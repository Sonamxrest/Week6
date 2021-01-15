package com.xrest.weeksoft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
private lateinit var username:EditText
private lateinit var password:EditText
private lateinit var btns: Button
class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initialize()
        btns.setOnClickListener(){

            if(validate())
            {
                var intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }



        }
    }

    private fun validate() : Boolean {
        when {
            TextUtils.isEmpty(username.text) -> {
                username.error = "Username must not be empty"
                username.requestFocus()
                return false
            }
            TextUtils.isEmpty(password.text) -> {
                password.error = "Password must not be empty"
                password.requestFocus()
                return false
            }
            username.text.toString() != "softwarica" -> {
                username.error = "Usernaem is incorrect."
                username.requestFocus()
                return false
            }
            password.text.toString() != "coventry" -> {
                password.error = "Password is incorrect."
                password.requestFocus()
                return false
            }
            else -> return true
        }
    }






    fun initialize(){

        username = findViewById(R.id.etu)
        password = findViewById(R.id.etp)
        btns = findViewById(R.id.btns)

    }
}

package com.example.bbct_app_admin.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.bbct_app_admin.MainActivity
import com.example.bbct_app_admin.R
import com.example.bbct_app_admin.model.response.ResponseLoginAMItem
import com.example.bbct_app_admin.rest.Preferrences
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var mPreferrencesPr= Preferrences(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initview()
        Login()
    }

    private fun initview() {
        if (checkIslogin(mPreferrencesPr.getUsername())==true){
            finish()
            startActivity(
                Intent(this, MainActivity::class.java)
            )
        }
    }

    private fun Login() {
        signin_button.setOnClickListener {
            var un = login_Email.text.toString()
            var pw = login_Password.text.toString()
            if (un =="admin" && pw == "zack000"){
                mPreferrencesPr.saveUsername(un)
                startActivity(
                    Intent(applicationContext,MainActivity::class.java)
                )
                finish()
            } else{
                Toast.makeText(applicationContext,"รหัสผ่านไม่ถูกต้อง" ,Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun  checkIslogin(username: String): Boolean{
        return username.isNotEmpty()
    }

}
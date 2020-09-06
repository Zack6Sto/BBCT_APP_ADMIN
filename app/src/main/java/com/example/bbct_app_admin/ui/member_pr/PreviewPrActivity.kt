package com.example.bbct_app_admin.ui.member_pr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bbct_app_admin.R
import com.example.bbct_app_admin.rest.BasUrl_IMG_NSR
import com.example.bbct_app_admin.rest.BasUrl_IMG_PR
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewPrActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview_pr)

        val u_id:String? = intent.getStringExtra("u_id")
        val u_code:String? = intent.getStringExtra("u_code")
        val u_username:String? = intent.getStringExtra("u_username")
        val u_password:String? = intent.getStringExtra("u_password")
        val u_fname:String? = intent.getStringExtra("u_fname")
        val u_lname:String? = intent.getStringExtra("u_lname")
//        val u_sex:String? = intent.getStringExtra("u_sex")
        val u_age:String? = intent.getStringExtra("u_age")
        val u_phone:String? = intent.getStringExtra("u_phone")
//        val u_address:String? = intent.getStringExtra("u_address")
        val u_email:String? = intent.getStringExtra("u_email")
        val u_status = intent.getStringExtra("u_status")
        val u_add = intent.getStringExtra("u_add")
        val img:String? = intent.getStringExtra("img")


        pv_code.text = u_code
        pv_username.text = u_username
        pv_password.text = u_password
        pv_fname.setText(u_fname)
        pv_lname.setText(u_lname)
//        pv_sex.text = u_sex
        pv_age.text = u_age
        pv_phone.text = u_phone
//        pv_adress.text = u_address
        pv_email.text = u_email
        pv_status.text = u_status
        pv_add.text = u_add
        Picasso.get().load(BasUrl_IMG_PR +img).into(pv_IMG)


    }
}
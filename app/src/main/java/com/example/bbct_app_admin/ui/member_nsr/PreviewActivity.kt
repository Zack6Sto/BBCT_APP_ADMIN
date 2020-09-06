package com.example.bbct_app_admin.ui.member_nsr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bbct_app_admin.R
import com.example.bbct_app_admin.rest.BasUrl_IMG_NSR
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

//        val n_id:String? = intent.getStringExtra("n_id")
        val n_code:String? = intent.getStringExtra("n_code")
        val n_username:String? = intent.getStringExtra("n_username")
        val n_password:String? = intent.getStringExtra("n_password")
        val n_fname:String? = intent.getStringExtra("n_fname")
        val n_lname:String? = intent.getStringExtra("n_lname")
        val n_sex:String? = intent.getStringExtra("n_sex")
        val n_age:String? = intent.getStringExtra("n_age")
        val n_phone:String? = intent.getStringExtra("n_phone")
        val n_address:String? = intent.getStringExtra("n_address")
        val n_email:String? = intent.getStringExtra("n_email")
        val n_status = intent.getStringExtra("n_status")
        val n_add = intent.getStringExtra("n_add")
        val img:String? = intent.getStringExtra("img")


        pv_code.text = n_code
        pv_username.text = n_username
        pv_password.text = n_password
        pv_fname.setText(n_fname)
        pv_lname.setText(n_lname)
        pv_sex.text = n_sex
        pv_age.text = n_age
        pv_phone.text = n_phone
        pv_adress.text = n_address
        pv_email.text = n_email
        pv_status.text = n_status
        pv_add.text = n_add
        Picasso.get().load(BasUrl_IMG_NSR+img).into(pv_IMG)

    }
}
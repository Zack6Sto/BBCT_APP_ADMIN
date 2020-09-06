package com.example.bbct_app_admin.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bbct_app_admin.MainActivity
import com.example.bbct_app_admin.MainPresenter
import com.example.bbct_app_admin.R
import com.example.bbct_app_admin.model.response.ResponseDataNsr
import com.example.bbct_app_admin.model.response.ResponseDataShowNsr
import kotlinx.android.synthetic.main.activity_main_edit.*
import kotlinx.android.synthetic.main.layout_itemdata.et_address
import kotlinx.android.synthetic.main.layout_itemdata.et_age
import kotlinx.android.synthetic.main.layout_itemdata.et_code
import kotlinx.android.synthetic.main.layout_itemdata.et_email
import kotlinx.android.synthetic.main.layout_itemdata.et_file
import kotlinx.android.synthetic.main.layout_itemdata.et_fname
import kotlinx.android.synthetic.main.layout_itemdata.et_lname
import kotlinx.android.synthetic.main.layout_itemdata.et_password
import kotlinx.android.synthetic.main.layout_itemdata.et_phon
import kotlinx.android.synthetic.main.layout_itemdata.et_sex
import kotlinx.android.synthetic.main.layout_itemdata.et_status
import kotlinx.android.synthetic.main.layout_itemdata.et_username

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainEditActivity : AppCompatActivity() {
    val mMainPresenter = MainPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_edit)
        setAPIEdit()
    }

    private fun setAPIEdit(){
        val id = intent.getIntExtra("id",0)
        val n_code = intent.getStringExtra("n_code")
        val n_username = intent.getStringExtra("n_username")
        val n_password = intent.getStringExtra("n_password")
        val n_fname = intent.getStringExtra("n_fname")
        val n_lname = intent.getStringExtra("n_lname")
        val n_sex = intent.getStringExtra("n_sex")
        val n_age = intent.getStringExtra("n_age")
        val n_phone = intent.getStringExtra("n_phone")
        val n_address = intent.getStringExtra("n_address")
        val n_email = intent.getStringExtra("n_email")
        val n_status = intent.getStringExtra("n_status")
        val n_add = intent.getStringExtra("n_add")

        et_code.setText(n_code)
        et_username.setText(n_username)
        et_password.setText(n_password)
        et_fname.setText(n_fname)
        et_lname.setText(n_lname)
        et_sex.setText(n_sex)
        et_age.setText(n_age)
        et_phon.setText(n_phone)
        et_address.setText(n_address)
        et_email.setText(n_email)
        et_status.setText(n_status)
        et_add.setText(n_add)


        btn_edit.setOnClickListener {
            mMainPresenter.UpdateNSRMainPersenterRx(id,et_code.text.toString(),et_username.text.toString(),et_password.text.toString(),
                et_fname.text.toString(),et_lname.text.toString(),et_sex.text.toString(),et_age.text.toString(),et_phon.text.toString(),
                et_address.text.toString(),et_email.text.toString(),et_status.text.toString(),et_add.text.toString(),
                this::onSuccessSubscrib,
                this::onErrorSubscrib)
        }

    }

    private fun onSuccessSubscrib(responseDataNsr: ResponseDataShowNsr) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

    private fun onErrorSubscrib(message: String) {
//        Log.d("messageUpdate",message)
    }

}
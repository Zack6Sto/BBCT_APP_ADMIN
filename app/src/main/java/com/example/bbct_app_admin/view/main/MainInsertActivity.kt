package com.example.bbct_app_admin.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bbct_app_admin.MainActivity
import com.example.bbct_app_admin.MainPresenter
import com.example.bbct_app_admin.R
import com.example.bbct_app_admin.model.response.ResponseDataNsr
import kotlinx.android.synthetic.main.activity_main_insert.*

class MainInsertActivity : AppCompatActivity() {
    val  mMainPersenter = MainPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_insert)
        setapi()
    }

    private fun setapi() {
        btn_Insert.setOnClickListener {
            mMainPersenter.InsertNurseryPersenterRx(
                eti_code.text.toString(),
                eti_username.text.toString(),
                eti_password.text.toString(),
                eti_fname.text.toString(),
                eti_lname.text.toString(),
                eti_sex.text.toString(),
                eti_age.text.toString(),
                eti_phon.text.toString(),
                eti_address.text.toString(),
                eti_email.text.toString(),
                eti_file.text.toString(),
                eti_status.text.toString(),
                this::onSuccessSubscribe,
                this::onErrorSubscribe)
        }
    }


    private fun onSuccessSubscribe(responseData: ResponseDataNsr) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

    private fun onErrorSubscribe(message:String) {
        Log.d("messsageInsert",message)
    }
}
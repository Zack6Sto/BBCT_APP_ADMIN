package com.example.bbct_app_admin.ui.post

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.bbct_app_admin.MainActivity
import com.example.bbct_app_admin.R
import com.example.bbct_app_admin.model.response.ResponseDataPost
import com.example.bbct_app_admin.rest.BasUrl_IMG_PR
import com.example.bbct_app_admin.rest.Preferrences
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_post.*
import java.util.*

class PostActivity : AppCompatActivity() {
    var mPostPresenter= PostPresenter()
    lateinit var mPreferrences: Preferrences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        mPreferrences = Preferrences(this)
        mPreferrences.getUsername()
        mPreferrences.getID()
        Picasso.get()
            .load(BasUrl_IMG_PR +mPreferrences.getImagefile())
            .into(imvProPic_Post)
        var name = mPreferrences.getUsername()
        TV_NamePost.setText(name)

        btnPost_Ok.setOnClickListener {
            satapi()
        }
    }

    private fun satapi(){
        val calendar  = Calendar.getInstance()
        val y  = calendar.get(Calendar.YEAR)
        val m  = calendar.get(Calendar.MONDAY)
        val d  = calendar.get(Calendar.DATE)
        val h  = calendar.get(Calendar.HOUR)
        val mm  = calendar.get(Calendar.MINUTE)
        val time =  "${d}/${m}/${y} - ${h}:${mm}"
        mPreferrences = Preferrences(this)
        mPostPresenter.InsertPostPersenter(mPreferrences.getID(),EDT_Post_Text.text.toString(),time,mPreferrences.getUsername(),
            this::onSuccessSubscrib,
            this::onErrorSubscrib)

    }

    private fun onSuccessSubscrib(responseDataPost: ResponseDataPost) {
        val mIntent = Intent(this, MainActivity::class.java)
        startActivity(mIntent)
        Toast.makeText(applicationContext, "โพสต์เสร็จสิ้น", Toast.LENGTH_LONG).show()
    }

    private fun onErrorSubscrib(message: String) {
        Log.d("messageInsert",message)

    }

}
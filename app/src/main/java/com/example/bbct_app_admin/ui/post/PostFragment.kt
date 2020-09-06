package com.example.bbct_app_admin.ui.post

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bbct_app_admin.R
import com.example.bbct_app_admin.model.response.ResponseDataPost
import com.example.bbct_app_admin.rest.Preferrences
import com.example.bbct_app_admin.view.adapter.AdapterPost
import kotlinx.android.synthetic.main.fragment_post.*
import kotlinx.android.synthetic.main.fragment_post.view.*


class PostFragment : Fragment() {

    val mImage:Int =(R.drawable.logo_png)
    var mPostPresenter= PostPresenter()
    var mResponseDataPost = ArrayList<ResponseDataPost>()
    lateinit var mPreferrences: Preferrences
    lateinit var mAdapterPost: AdapterPost

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_post, container, false)

        satapi()
        root.button_fab.setOnClickListener {

            startActivity(
                Intent(context,PostActivity::class.java)
            )
        }
        return root.rootView

    }

    private fun satapi(){

        mPostPresenter.MainPersenterPostRx(
            this::onSuccessSubscrib,
            this::onErrorSubscrib
        )
    }


    fun onSuccessSubscrib(response: List<ResponseDataPost>) {
        for (i in response.indices){
            mResponseDataPost.add(response[i])
        }
        mAdapterPost = AdapterPost(
            this.requireContext(),
            mResponseDataPost,
            mImage
        ) { p_id,p_text,p_time,username,img ->
            val i = Intent(context, PostCommentActivity::class.java)
            i.putExtra("p_id", p_id)
            i.putExtra("p_text", p_text)
            i.putExtra("p_time", p_time)
            i.putExtra("username", username)
            i.putExtra("img", img)
            startActivity(i)

        }


        recyclerViewPost.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapterPost
            mAdapterPost.notifyDataSetChanged()
        }
    }

    fun onErrorSubscrib(Message: String) {
    }


}
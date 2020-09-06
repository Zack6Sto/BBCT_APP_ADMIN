package com.example.bbct_app_admin.ui.member_nsr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bbct_app_admin.MainPresenter
import com.example.bbct_app_admin.R
import com.example.bbct_app_admin.model.response.ResponseDataNsr
import com.example.bbct_app_admin.model.response.ResponseDataShowNsr
import com.example.bbct_app_admin.rest.Preferrences
import com.example.bbct_app_admin.view.adapter.AdapterMemberNSR
import kotlinx.android.synthetic.main.fragment_member_nsr.*

class MemberNsrFragment : Fragment() {

    val mImage:Int =(R.drawable.logo_png)
    var mMainPresenter= MainPresenter()
    var mResponseData = ArrayList<ResponseDataShowNsr>()
    lateinit var mAdapterMemberNSR: AdapterMemberNSR



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_member_nsr, container, false)

        setapi()
        return root.rootView

    }




    private fun setapi() {
        mMainPresenter.MainPersenterRx(
            this::onSuccessSub,
            this::onErrorSub)
    }


    private fun onSuccessSub(response: List<ResponseDataShowNsr>) {
        for (i in response.indices){
            mResponseData.add(response[i])
        }


        mAdapterMemberNSR = AdapterMemberNSR(this.requireContext(),mResponseData,mImage)
        recyclerViewNsr.apply {
            layoutManager = LinearLayoutManager(context)
            adapter =  mAdapterMemberNSR
            mAdapterMemberNSR.notifyDataSetChanged()
        }

    }

    private fun onErrorSub(message:String) {

    }


}
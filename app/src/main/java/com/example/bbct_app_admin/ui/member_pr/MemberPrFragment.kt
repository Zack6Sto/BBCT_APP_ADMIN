package com.example.bbct_app_admin.ui.member_pr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bbct_app_admin.MainPresenter
import com.example.bbct_app_admin.R
import com.example.bbct_app_admin.model.response.ResponseDataPr
import com.example.bbct_app_admin.view.adapter.AdapterMemberPR
import kotlinx.android.synthetic.main.fragment_member_pr.*

class MemberPrFragment : Fragment() {

    val mImage:Int =(R.drawable.logo_png)
    var mMainPresenter= MainPresenter()
    var mResponseData = ArrayList<ResponseDataPr>()
    lateinit var mAdapterMemberPr: AdapterMemberPR



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_member_pr, container, false)

        setapi()
        return root.rootView

    }




    private fun setapi() {
        mMainPresenter.MainPRPersenterRx(
            this::onSuccessSub,
            this::onErrorSub)
    }


    private fun onSuccessSub(response: List<ResponseDataPr>) {
        for (i in response.indices){
            mResponseData.add(response[i])
        }


        mAdapterMemberPr= AdapterMemberPR(this.requireContext(),mResponseData,mImage)
        recyclerViewPr.apply {
            layoutManager = LinearLayoutManager(context)
            adapter =  mAdapterMemberPr
            mAdapterMemberPr.notifyDataSetChanged()
        }

    }

    private fun onErrorSub(message:String) {

    }


}
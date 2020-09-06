package com.example.bbct_app_admin.ui.post

import android.util.Log
import com.example.bbct_app_admin.model.body.BodyInsertComment
import com.example.bbct_app_admin.model.body.BodyInsertPost
import com.example.bbct_app_admin.model.response.ResponseDataComment
import com.example.bbct_app_admin.model.response.ResponseDataPost
import com.example.bbct_app_admin.rest.DataModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class PostPresenter {
    var mDisposable: Disposable? = null

    //GET POST
    fun MainPersenterPostRx(
        dataResponse : (List<ResponseDataPost>) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doGetPost()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<List<ResponseDataPost>>(){
                override fun onComplete() {

                }

                override fun onNext(response: List<ResponseDataPost>) {
                    Log.d("messagePost", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messagePost",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }

    //GET COMMENT
    fun MainPersenterCommentRx(
        id:Int,
        dataResponse : (List<ResponseDataComment>) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doGetComment(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<List<ResponseDataComment>>(){
                override fun onComplete() {

                }

                override fun onNext(response: List<ResponseDataComment>) {
                    Log.d("messageComment", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageComment",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }

    //RX InsertPost
    fun InsertPostPersenter(
        u_id: String,
        p_text:String,
        p_time:String,
        username:String,

        dataResponse : (ResponseDataPost) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doInsertPost(BodyInsertPost(u_id,p_text,p_time,username) )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseDataPost>(){
                override fun onComplete() {

                }

                override fun onNext(response: ResponseDataPost) {
                    Log.d("messageInsert", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageInsert",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }

    //RX InsertComment
    fun InsertCommentPersenter(
        p_id:String,
        u_id:String,
        name_cm:String,
        img_cm:String,
        cm_text:String,
        cm_time:String,

        dataResponse : (ResponseDataComment) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doInsertComment(BodyInsertComment(p_id,u_id,name_cm,img_cm,cm_text,cm_time) )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseDataComment>(){
                override fun onComplete() {

                }

                override fun onNext(response: ResponseDataComment) {
                    Log.d("messageInsert", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageInsert",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }

}
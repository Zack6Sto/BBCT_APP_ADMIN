package com.example.bbct_app_admin.ui.login

import android.util.Log
import com.example.bbct_app_admin.model.body.BodyLoginAM
import com.example.bbct_app_admin.model.response.ResponseLoginAM
import com.example.bbct_app_admin.rest.DataModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class LoginPresenter {

    var mDisposable: Disposable? = null

    fun LoginAMPersenter(
        user:String,
        pass:String,
        Status:String,
        dataResponse : (ResponseLoginAM) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doLoginAM(BodyLoginAM(user,pass,Status))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseLoginAM>(){
                override fun onComplete() {

                }

                override fun onNext(responseLogin: ResponseLoginAM) {
                    Log.d("messageLogin", responseLogin.toString())
                    dataResponse.invoke(responseLogin)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageLogin",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }


}
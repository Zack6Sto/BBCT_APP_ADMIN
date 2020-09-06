package com.example.bbct_app_admin

import android.util.Log
import com.example.bbct_app_admin.model.body.BodyInsertNSR
import com.example.bbct_app_admin.model.body.BodyUpdates
import com.example.bbct_app_admin.model.response.*
import com.example.bbct_app_admin.rest.DataModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainPresenter {
    var mDisposable: Disposable? = null

    //Get NSR
    fun MainPersenterRx(
        dataResponse : (List<ResponseDataShowNsr>) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doGetNSR()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<List<ResponseDataShowNsr>>(){
                override fun onComplete() {

                }

                override fun onNext(response: List<ResponseDataShowNsr>) {
                    Log.d("message", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("message",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }

    //Get PR
    fun MainPRPersenterRx(
        dataResponse : (List<ResponseDataPr>) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doGetPR()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<List<ResponseDataPr>>(){
                override fun onComplete() {

                }

                override fun onNext(response: List<ResponseDataPr>) {
                    Log.d("message", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("message",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }

//    //RX InsertPR
//    fun InsertPRMainPersenter(
//        u_code: String,
//        u_username: String,
//        u_password: String,
//        u_fname: String,
//        u_lname: String,
//        u_age: String,
//        u_phone: String,
//        u_email: String,
//        dataResponse : (ResponseDataPr) -> Unit,
//        MessageError: (String)-> Unit
//    ){
//
//        mDisposable = DataModule.myAppService.doInsertPR(
//            BodyInsert(u_code, u_username, u_password,
//            u_fname, u_lname, u_age, u_phone, u_email) )
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeWith(object : DisposableObserver<ResponseDataPr>(){
//                override fun onComplete() {
//
//                }
//
//                override fun onNext(response: ResponseDataPr) {
//                    Log.d("messageInsert", response.toString())
//                    dataResponse.invoke(response)
//                }
//
//                override fun onError(e: Throwable) {
//                    Log.d("messageInsert",e.toString())
//                    MessageError.invoke(e.message!!)
//                }
//
//            })
//
//    }
//

    //เพิ่ม ข้อมูล
    fun InsertNurseryPersenterRx(
        n_code: String,
        n_username: String,
        n_password: String,
        n_fname: String,
        n_lname: String,
        n_sex: String,
        n_age: String,
        n_phone: String,
        n_address: String,
        n_email: String,
        n_file_img: String,
        n_status: String,
        dataResponse : (ResponseDataNsr) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doInsertNSR(
            BodyInsertNSR(n_code, n_username, n_password,
            n_fname, n_lname,n_sex, n_age, n_phone,n_address,n_email,n_file_img,n_status) )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseDataNsr>(){
                override fun onComplete() {

                }

                override fun onNext(response: ResponseDataNsr) {
                    Log.d("messageInsert", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageInsert",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }

    fun DeletePostMainPersenterRx(
        id:Int,
        dataResponse : (ResponseDataPost) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doDeletePost(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseDataPost>(){
                override fun onComplete() {

                }

                override fun onNext(response: ResponseDataPost) {
                    Log.d("messageDelete", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageDelete",e.message!!.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }


//
    //RX Delete
    fun DeleteNSRMainPersenterRx(
        id:Int,
        dataResponse : (ResponseDataShowNsr) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doDeleteNSR(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseDataShowNsr>(){
                override fun onComplete() {

                }

                override fun onNext(response: ResponseDataShowNsr) {
                    Log.d("messageDelete", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageDelete",e.message!!.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }

//
    //RX Update
    fun UpdateNSRMainPersenterRx(
        id:Int,
        n_code:String,
        n_username:String,
        n_password:String,
        n_fname:String,
        n_lname:String,
        n_sex:String,
        n_age:String,
        n_phone:String,
        n_address:String,
        n_email:String,
        n_status: String,
        n_add:String,
        dataResponse : (ResponseDataShowNsr) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doUpdateNSR(id, BodyUpdates(n_code,n_username,
            n_password,
            n_fname,
            n_lname,
            n_sex,
            n_age,
            n_phone,
            n_address,
            n_email,
            n_status,
            n_add) )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseDataShowNsr>(){
                override fun onComplete() {

                }

                override fun onNext(response: ResponseDataShowNsr) {
                    Log.d("messageUpdate", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageUpdate",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }



}

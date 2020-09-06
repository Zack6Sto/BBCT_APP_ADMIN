package com.example.bbct_app_admin.rest


import com.example.bbct_app_admin.model.body.*
import com.example.bbct_app_admin.model.response.*
import io.reactivex.Observable
import retrofit2.http.*


interface ServiceAPI {

//    @POST("/uploadImg")
//    fun doUploadImg(@Body body: BodyImage): Observable<ResponseUploadImage>
    //**************************************************************************

    //*LOGIN*\\
    //**************************************************************************
    @POST("/loginAdmin")
    fun doLoginAM(@Body body: BodyLoginAM?):Observable<ResponseLoginAM>
    //*************************************************************************
    //*GET*\\
    //**************************************************************************
    @GET("/nursery")
    fun doGetNSR(): Observable<List<ResponseDataShowNsr>>

    @GET("/parent")
    fun doGetPR(): Observable<List<ResponseDataPr>>

    @GET("/listpost")
    fun doGetPost(): Observable<List<ResponseDataPost>>

    @GET("/listComment/{id}")
    fun doGetComment(@Path("id") id:Int?): Observable<List<ResponseDataComment>>


    //**************************************************************************
    //*INSERT*\\
    //**************************************************************************
//    @POST("/RegisterParent")
//    fun doInsertPR(@Body body: BodyInsert?):Observable<ResponseDataPr>

    @POST("/RegisterNursery")
    fun doInsertNSR(@Body body: BodyInsertNSR?):Observable<ResponseDataNsr>

    @POST("/Post")
    fun doInsertPost(@Body body: BodyInsertPost?):Observable<ResponseDataPost>

    @POST("/Comment")
    fun doInsertComment(@Body body: BodyInsertComment?):Observable<ResponseDataComment>
    //**************************************************************************


    @PUT("/updateNsr/{id}")
    fun doUpdateNSR(@Path("id")id:Int,
                 @Body body: BodyUpdates?):Observable<ResponseDataShowNsr>
//
    @DELETE("/deleteNsr/{id}")
    fun doDeleteNSR(@Path("id")id:Int):Observable<ResponseDataShowNsr>

    @DELETE("/deletePost/{id}")
    fun doDeletePost(@Path("id")id:Int):Observable<ResponseDataPost>




}
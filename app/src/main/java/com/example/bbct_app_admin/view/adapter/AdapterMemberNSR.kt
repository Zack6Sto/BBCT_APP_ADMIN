package com.example.bbct_app_admin.view.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bbct_app_admin.R
import com.example.bbct_app_admin.model.response.ResponseDataNsr
import com.example.bbct_app_admin.model.response.ResponseDataShowNsr
import com.example.bbct_app_admin.rest.BasUrl_IMG_NSR
import com.example.bbct_app_admin.ui.member_nsr.PreviewActivity
import com.example.bbct_app_admin.view.main.MainDeleteActivity
import com.example.bbct_app_admin.view.main.MainEditActivity
import com.example.bbct_app_admin.view.main.MainInsertActivity
import com.squareup.picasso.Picasso

class   AdapterMemberNSR (
    private var context: Context,
    private var mData: ArrayList<ResponseDataShowNsr>,
    private var mImage:Int)

    : RecyclerView.Adapter<AdapterMemberNSR.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_member,
                parent,
                false
            )
        )
    }
    override fun getItemCount() = mData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.n_username.text = mData[position].n_username
        holder.n_fname.text = mData[position].n_fname
        holder.n_lname.text = mData[position].n_lname
        holder.n_phone.text = mData[position].n_phone
        holder.n_email.text = mData[position].n_email
//        Glide.with(context).load(mImage).into(holder.image)
        Picasso.get().load(BasUrl_IMG_NSR+mData.get(position).img).into(holder.image)

        holder.button_Preview.setOnClickListener {
                        val i = Intent(context, PreviewActivity::class.java)
            //            i.putExtra("id",mData[position].n_id)
                        i.putExtra("n_code",mData[position].n_code)
                        i.putExtra("n_username",mData[position].n_username)
                        i.putExtra("n_password",mData[position].n_password)
                        i.putExtra("n_fname",mData[position].n_fname)
                        i.putExtra("n_lname",mData[position].n_lname)
                        i.putExtra("n_sex",mData[position].n_sex)
                        i.putExtra("n_age",mData[position].n_age)
                        i.putExtra("n_phone",mData[position].n_phone)
                        i.putExtra("n_address",mData[position].n_address)
                        i.putExtra("n_email",mData[position].n_email)
                        i.putExtra("n_status",mData[position].n_status)
                        i.putExtra("n_add",mData[position].n_add)
                        i.putExtra("img",mData[position].img)
                        context.startActivity(i)
        }

        holder.button_edit.setOnClickListener {
                        val i = Intent(context, MainEditActivity::class.java)
                        i.putExtra("id",mData[position].n_id)
                        i.putExtra("n_code",mData[position].n_code)
                        i.putExtra("n_username",mData[position].n_username)
                        i.putExtra("n_password",mData[position].n_password)
                        i.putExtra("n_fname",mData[position].n_fname)
                        i.putExtra("n_lname",mData[position].n_lname)
                        i.putExtra("n_sex",mData[position].n_sex)
                        i.putExtra("n_age",mData[position].n_age)
                        i.putExtra("n_phone",mData[position].n_phone)
                        i.putExtra("n_address",mData[position].n_address)
                        i.putExtra("n_email",mData[position].n_email)
                        i.putExtra("n_status",mData[position].n_status)
                        i.putExtra("n_add",mData[position].n_add)
                        context.startActivity(i)
        }

        holder.button_delete.setOnClickListener {
            val i = Intent(context, MainDeleteActivity::class.java)
                        i.putExtra("id",mData[position].n_id)
                        context.startActivity(i)
        }




    }

    class ViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView) {
        val button_Preview:Button = itemsView.findViewById(R.id.button_Preview)
        val button_edit:Button = itemsView.findViewById(R.id.button_edit)
        val button_delete:Button = itemsView.findViewById(R.id.button_delete)

        val image: ImageView = itemsView.findViewById<ImageView>(R.id.ImView)
        val n_username: TextView = itemsView.findViewById<TextView>(R.id.et_username)
        val n_fname: TextView = itemsView.findViewById<TextView>(R.id.et_fname)
        val n_lname: TextView = itemsView.findViewById<TextView>(R.id.et_lname)
        val n_phone: TextView = itemsView.findViewById<TextView>(R.id.et_phon)
        val n_email: TextView = itemsView.findViewById<TextView>(R.id.et_email)
    }
}

//        holder.image.setImageResource(mImage)


//        holder.itemView.setOnClickListener{
//            val builderSingle = AlertDialog.Builder(context)
//            val animals = arrayOf("แก้ไข","ลบ","เพิ่ม")
//            builderSingle.setItems(animals){_,which ->
//                when(which){
//                    0   //แก้ไขขอ้มูล
//                    ->{
//                        val i = Intent(context, MainEditActivity::class.java)
//                        i.putExtra("id",mData[position].n_id)
//                        i.putExtra("n_code",mData[position].n_code)
//                        i.putExtra("n_username",mData[position].n_username)
//                        i.putExtra("n_password",mData[position].n_password)
//                        i.putExtra("n_fname",mData[position].n_fname)
//                        i.putExtra("n_lname",mData[position].n_lname)
//                        i.putExtra("n_sex",mData[position].n_sex)
//                        i.putExtra("n_age",mData[position].n_age)
//                        i.putExtra("n_phone",mData[position].n_phone)
//                        i.putExtra("n_address",mData[position].n_address)
//                        i.putExtra("n_email",mData[position].n_email)
//                        i.putExtra("n_file_img",mData[position].n_file_img)
//                        i.putExtra("n_status",mData[position].n_status)
//                        context.startActivity(i)
//                    }
//                    1   //ลบ
//                    ->{
//                        val i = Intent(context, MainDeleteActivity::class.java)
//                        i.putExtra("id",mData[position].n_id)
//                        context.startActivity(i)
//                    }
//                    2   //เพิ่ม
//                    ->{
//                        val i = Intent(context, MainInsertActivity::class.java)
//                        i.putExtra("id",mData[position].n_id)
//                        i.putExtra("n_code",mData[position].n_code)
//                        i.putExtra("n_username",mData[position].n_username)
//                        i.putExtra("n_password",mData[position].n_password)
//                        i.putExtra("n_fname",mData[position].n_fname)
//                        i.putExtra("n_lname",mData[position].n_lname)
//                        i.putExtra("n_sex",mData[position].n_sex)
//                        i.putExtra("n_age",mData[position].n_age)
//                        i.putExtra("n_phone",mData[position].n_phone)
//                        i.putExtra("n_address",mData[position].n_address)
//                        i.putExtra("n_email",mData[position].n_email)
//                        i.putExtra("n_file_img",mData[position].n_file_img)
//                        i.putExtra("n_status",mData[position].n_status)
//                        context.startActivity(i)
//                    }
//                }
//
//            }
//            builderSingle.show()
//            true
//        }
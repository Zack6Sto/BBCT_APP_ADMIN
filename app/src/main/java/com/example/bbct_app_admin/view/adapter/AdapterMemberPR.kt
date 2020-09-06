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
import com.example.bbct_app_admin.R
import com.example.bbct_app_admin.model.response.ResponseDataPr
import com.example.bbct_app_admin.rest.BasUrl_IMG_NSR
import com.example.bbct_app_admin.rest.BasUrl_IMG_PR
import com.example.bbct_app_admin.ui.member_pr.PreviewPrActivity
import com.example.bbct_app_admin.view.main.MainDeleteActivity
import com.example.bbct_app_admin.view.main.MainEditActivity
import com.example.bbct_app_admin.view.main.MainInsertActivity
import com.squareup.picasso.Picasso

class   AdapterMemberPR (
    private var context: Context,
    private var mData: ArrayList<ResponseDataPr>,
    private var mImage:Int)

    : RecyclerView.Adapter<AdapterMemberPR.ViewHolder>() {
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

        holder.u_username.text = mData[position].u_username
        holder.u_fname.text = mData[position].u_fname
        holder.u_lname.text = mData[position].u_lname
        holder.u_phone.text = mData[position].u_phone
        holder.u_email.text = mData[position].u_email
        Picasso.get().load(BasUrl_IMG_PR +mData.get(position).img).into(holder.image)
//        holder.image.setImageResource(mImage)

        holder.itemView.setOnClickListener{
            val builderSingle = AlertDialog.Builder(context)
            val animals = arrayOf("แก้ไข","ลบ","เพิ่ม")
            builderSingle.setItems(animals){_,which ->
                when(which){
                    0   //แก้ไขขอ้มูล
                    ->{
                        val i = Intent(context, MainEditActivity::class.java)
                        i.putExtra("id",mData[position].u_id)
                        i.putExtra("u_code",mData[position].u_code)
                        i.putExtra("u_username",mData[position].u_username)
                        i.putExtra("u_password",mData[position].u_password)
                        i.putExtra("u_fname",mData[position].u_fname)
                        i.putExtra("u_lname",mData[position].u_lname)
                        i.putExtra("u_age",mData[position].u_age)
                        i.putExtra("u_phone",mData[position].u_phone)
                        i.putExtra("u_email",mData[position].u_email)
                        i.putExtra("u_status",mData[position].u_status)
                        context.startActivity(i)
                    }
                    1   //ลบ
                    ->{
                        val i = Intent(context, MainDeleteActivity::class.java)
                        i.putExtra("id",mData[position].u_id)
                        context.startActivity(i)
                    }
                    2   //เพิ่ม
                    ->{
                        val i = Intent(context, MainInsertActivity::class.java)
                        i.putExtra("id",mData[position].u_id)
                        i.putExtra("u_code",mData[position].u_code)
                        i.putExtra("u_username",mData[position].u_username)
                        i.putExtra("u_password",mData[position].u_password)
                        i.putExtra("u_fname",mData[position].u_fname)
                        i.putExtra("u_lname",mData[position].u_lname)
                        i.putExtra("u_age",mData[position].u_age)
                        i.putExtra("u_phone",mData[position].u_phone)
                        i.putExtra("u_email",mData[position].u_email)
                        i.putExtra("u_status",mData[position].u_status)
                        context.startActivity(i)
                    }
                }

            }
            builderSingle.show()
            true
        }

        holder.button_Preview.setOnClickListener {
            val i = Intent(context, PreviewPrActivity::class.java)
            i.putExtra("id",mData[position].u_id)
            i.putExtra("u_code",mData[position].u_code)
            i.putExtra("u_username",mData[position].u_username)
            i.putExtra("u_password",mData[position].u_password)
            i.putExtra("u_fname",mData[position].u_fname)
            i.putExtra("u_lname",mData[position].u_lname)
//            i.putExtra("u_sex",mData[position].u_sex)
            i.putExtra("u_age",mData[position].u_age)
            i.putExtra("u_phone",mData[position].u_phone)
//            i.putExtra("u_address",mData[position].u_address)
            i.putExtra("u_email",mData[position].u_email)
            i.putExtra("u_status",mData[position].u_status)
            i.putExtra("u_add",mData[position].u_add)
            i.putExtra("img",mData[position].img)
            context.startActivity(i)
        }
    }

    class ViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView) {
        val button_Preview: Button = itemsView.findViewById(R.id.button_Preview)
        val button_edit: Button = itemsView.findViewById(R.id.button_edit)
        val button_delete: Button = itemsView.findViewById(R.id.button_delete)

        val image: ImageView = itemsView.findViewById<ImageView>(R.id.ImView)
        val u_username: TextView = itemsView.findViewById<TextView>(R.id.et_username)
        val u_fname: TextView = itemsView.findViewById<TextView>(R.id.et_fname)
        val u_lname: TextView = itemsView.findViewById<TextView>(R.id.et_lname)
        val u_phone: TextView = itemsView.findViewById<TextView>(R.id.et_phon)
        val u_email: TextView = itemsView.findViewById<TextView>(R.id.et_email)
    }
}


package com.muhammadazri.belajarhidroponik

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListTanamanAdapter(val listTanaman: ArrayList<Tanaman>) : RecyclerView.Adapter<ListTanamanAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup,viewType: Int):ListTanamanAdapter.ListViewHolder{
        val view : View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card_tanaman, viewGroup,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listTanaman.size
    }

    override fun onBindViewHolder(holder: ListTanamanAdapter.ListViewHolder, position: Int) {
        val (name, photo, gizi, masaPanen) =listTanaman[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener{
            val moveDetailTanaman = Intent(mContext, detail_tanaman::class.java)
            moveDetailTanaman.putExtra(detail_tanaman.EXTRA_NAME, name)
            moveDetailTanaman.putExtra(detail_tanaman.EXTRA_PHOTO, photo)
            moveDetailTanaman.putExtra(detail_tanaman.EXTRA_GIZI, gizi)
            moveDetailTanaman.putExtra(detail_tanaman.EXTRA_PANEN, masaPanen)
            mContext.startActivity(moveDetailTanaman)
        }

    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_tanaman_name)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo_tanaman)
    }
}
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

class ListTeknikAdapter(val listTeknik: ArrayList<Teknik>) : RecyclerView.Adapter<ListTeknikAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card_teknik, viewGroup,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listTeknik.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, pengertian, photo, bahan,cara, kelebihan, kekurangan) =listTeknik[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener{
            val moveDetailTeknik = Intent(mContext, detail_teknik::class.java)
            moveDetailTeknik.putExtra(detail_teknik.EXTRA_NAME, name)
            moveDetailTeknik.putExtra(detail_teknik.EXTRA_PHOTO, photo)
            moveDetailTeknik.putExtra(detail_teknik.EXTRA_PENGERTIAN, pengertian)
            moveDetailTeknik.putExtra(detail_teknik.EXTRA_BAHAN, bahan)
            moveDetailTeknik.putExtra(detail_teknik.EXTRA_CARA, cara)
            moveDetailTeknik.putExtra(detail_teknik.EXTRA_KELEBIHAN, kelebihan)
            moveDetailTeknik.putExtra(detail_teknik.EXTRA_KEKURANGAN, kekurangan)
            mContext.startActivity(moveDetailTeknik)
        }
    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_teknik_name)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo_teknik)
    }

}
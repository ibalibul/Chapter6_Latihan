package com.iqbal.chapter6_latihan.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iqbal.chapter6_latihan.databinding.ItemMakeupBinding
import com.iqbal.chapter6_latihan.model.GetResspownMakeUpItem

class MakeUpAdapter (var listMakeUp : List<GetResspownMakeUpItem>) : RecyclerView.Adapter<MakeUpAdapter.ViewHolder>() {
    class ViewHolder(var binding : ItemMakeupBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeUpAdapter. ViewHolder {
        var view = ItemMakeupBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MakeUpAdapter. ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.nameMakeup.text = listMakeUp[position].name
        holder.binding.priceMakeup.text = listMakeUp[position].price
        holder.binding.categoryMakeup.text = listMakeUp[position].category
        Glide.with(holder.itemView.context).load(listMakeUp[position].imageLink).into(holder.binding.imgMakeUp)
    }

    override fun getItemCount(): Int {
       return listMakeUp.size
    }
}
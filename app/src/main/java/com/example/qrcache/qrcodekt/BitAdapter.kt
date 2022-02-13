package com.example.qrcache.qrcodekt

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.qrcache.R

class BitAdapter() : RecyclerView.Adapter<BitAdapter.PhotoHolder>()  {

    lateinit var list: MutableList<BitModel>
    fun submitList(l:MutableList<BitModel>, c: Context){
        list=l
    }

    class PhotoHolder(v: View) : RecyclerView.ViewHolder(v) {
        var imageView:ImageView = v.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.bity_item, parent, false)
        return PhotoHolder(v)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.imageView.setImageBitmap(BitmapFactory.decodeByteArray(list[position].bitByte, 0, list[position].bitByte.size))
        val tdLong = System.currentTimeMillis() / 1000
        val td = tdLong.toString()
        Log.d("TIME_NOW",td)
    }

    override fun getItemCount(): Int =list.size
}
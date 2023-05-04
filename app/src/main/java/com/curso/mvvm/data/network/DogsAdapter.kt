package com.curso.mvvm.data.network

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.curso.mvvm.R
import com.curso.mvvm.databinding.ItemDogBinding

class DogsAdapter (val images: List<String>) : RecyclerView.Adapter<DogsAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = images[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_dog, parent, false))
    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemDogBinding.bind(view)

        fun bind(image: String) {
            binding.ivDog.fromUrl(image)
        }
    }
}


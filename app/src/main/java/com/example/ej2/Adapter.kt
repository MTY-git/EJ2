package com.example.ej2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ej2.databinding.LocationBinding

class Adapter(
    private val locations : List<Location>,
    private val locationClickedListener : (Location) -> Unit


    ):RecyclerView.Adapter<Adapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LocationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val location = locations[position]
        holder.bind(location)
        holder.itemView.setOnClickListener{locationClickedListener(location)}
    }

    override fun getItemCount(): Int = locations.size

    class ViewHolder(private val binding : LocationBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(location:Location){
            binding.nombre.text = location.nombre
            Glide.with(binding.root.context)
                .load(location.pic)
                .into(binding.pic)
        }
    }

}
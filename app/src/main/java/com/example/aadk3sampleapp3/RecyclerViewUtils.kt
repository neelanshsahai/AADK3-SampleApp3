package com.example.aadk3sampleapp3

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aadk3sampleapp3.databinding.ListItemBinding
import com.example.aadk3sampleapp3.networkUtils.BreedDetail

class BreedViewHolder(
    private val binding: ListItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(context: Context, data: BreedDetail) {
        binding.itemBreed.text = data.name
        binding.itemCategory.text = data.category
        binding.itemOrigin.text = data.origin

        // Add the Image
        Glide.with(context).load(data.imageReference.imageUrl).into(binding.itemImage)
    }
}

class DogBreedAdapter(
    private val context: Context,
    private var breeds: List<BreedDetail>
): RecyclerView.Adapter<BreedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        return BreedViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = breeds.size

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        holder.bind(context, breeds[position])
    }

    fun refreshList(newDataList: List<BreedDetail>) {
        breeds = newDataList
        notifyDataSetChanged()
    }
}

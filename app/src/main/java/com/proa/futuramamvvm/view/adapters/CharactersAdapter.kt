package com.proa.futuramamvvm.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proa.futuramamvvm.R
import com.proa.futuramamvvm.databinding.ItemCharacterBinding
import com.proa.futuramamvvm.view.extensions.fromUrl

class CharactersAdapter(val images: List<String>) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharactersAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_character, parent, false))
    }

    override fun onBindViewHolder(holder: CharactersAdapter.ViewHolder, position: Int) {
        val item = images[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemCharacterBinding.bind(view)

        fun bind(image: String) {
            binding.imageViewCharacter.fromUrl(image)
        }
    }
}
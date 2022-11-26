package com.example.films.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.films.base.BaseDiffUtilItemCallback
import com.example.films.databinding.ItemFilmsBinding
import com.example.films.models.films.FilmsModel
import com.example.films.ui.OnItemClickListener

class FilmsAdapter(private val onItemClickListener: OnItemClickListener) : ListAdapter<FilmsModel, FilmsAdapter.FilmsViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FilmsViewHolder(
        ItemFilmsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    inner class FilmsViewHolder(private val binding: ItemFilmsBinding) : ViewHolder(binding.root) {
        fun onBind(model: FilmsModel) {
            binding.tvFilmsName.text = model.title
            binding.ivFilm.load(model.image)

            itemView.setOnClickListener {
                onItemClickListener.onItemClick(model)
            }
        }
    }
}
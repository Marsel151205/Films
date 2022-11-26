package com.example.films.ui.fragments.detailfilm

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.films.R
import com.example.films.base.BaseFragment
import com.example.films.common.Resource
import com.example.films.databinding.FragmentDetailFilmBinding
import com.example.films.models.films.FilmsModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFilmFragment : BaseFragment<FragmentDetailFilmBinding, DetailFilmViewModel>(R.layout.fragment_detail_film) {
    override val binding by viewBinding(FragmentDetailFilmBinding::bind)
    override val viewModel: DetailFilmViewModel by viewModels()
    private val saveArgs: DetailFilmFragmentArgs by navArgs<DetailFilmFragmentArgs>()

    override fun initialize() {
    }

    override fun setupSubscribe() {
        viewModel.fetchDetailFilm(saveArgs.id).subscribe(
            onSuccess = {
                addDateInView(it)
            },
            onError = {
                Log.e("film", it )
            }
        )
    }

    private fun addDateInView(model: FilmsModel) {
        binding.ivFilmDetail.load(model.image)
        binding.tvTitleDetail.text = model.title
        binding.tvReleaseDate.text = model.releaseDate
        binding.tvDirection.text = model.description
        binding.tvProducer.text = model.producer
        binding.tvRunningTime.text = model.runningTime
        binding.tvDirector.text = model.director
        binding.tvReleaseDate.text =model.releaseDate
    }
}
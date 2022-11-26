package com.example.films.ui.fragments.films

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.films.R
import com.example.films.base.BaseFragment
import com.example.films.common.Resource
import com.example.films.databinding.FragmentFilmsBinding
import com.example.films.models.films.FilmsModel
import com.example.films.ui.OnItemClickListener
import com.example.films.ui.adapters.FilmsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmsFragment : BaseFragment<FragmentFilmsBinding, FilmsViewModel>(R.layout.fragment_films),
    OnItemClickListener {

    override val binding by viewBinding(FragmentFilmsBinding::bind)
    override val viewModel: FilmsViewModel by viewModels()
    private val filmsAdapter = FilmsAdapter(this)

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        viewModel.fetchFilms().subscribe(
            onSuccess = {
                filmsAdapter.submitList(it)
            },
            onError = {
                Log.e("film", it )
            }
        )
    }

    private fun setupRecyclerView() {
        binding.rvFilms.adapter = filmsAdapter
    }

    override fun onItemClick(model: FilmsModel) {
        findNavController().navigate(
            FilmsFragmentDirections.actionFilmsFragmentToDetailFilmFragment().setId(model.id)
        )
    }
}

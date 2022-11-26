package com.example.films.ui.fragments.detailfilm

import com.example.films.base.BaseViewModel
import com.example.films.data.repositories.DetailFilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailFilmViewModel @Inject constructor(private val repository: DetailFilmRepository) :
    BaseViewModel() {

    fun fetchDetailFilm(id: String) = repository.fetchDetailFilm(id)
}
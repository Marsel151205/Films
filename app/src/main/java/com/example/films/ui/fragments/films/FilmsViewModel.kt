package com.example.films.ui.fragments.films

import com.example.films.base.BaseViewModel
import com.example.films.data.repositories.FilmsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(private val repository: FilmsRepository) :
    BaseViewModel() {

    fun fetchFilms() = repository.fetchFilms()

}
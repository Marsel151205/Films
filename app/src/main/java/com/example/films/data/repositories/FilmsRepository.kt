package com.example.films.data.repositories

import com.example.films.base.BaseRepository
import com.example.films.data.remote.apiservices.FilmsApiService
import javax.inject.Inject

class FilmsRepository @Inject constructor(private val service: FilmsApiService) : BaseRepository() {

    fun fetchFilms() = doRequest {
        service.fetchFilms()
    }
}
package com.example.films.data.repositories

import com.example.films.base.BaseRepository
import com.example.films.data.remote.apiservices.FilmsApiService
import javax.inject.Inject

class DetailFilmRepository @Inject constructor(private val service: FilmsApiService): BaseRepository() {

    fun fetchDetailFilm(id: String) = doRequest {
        service.fetchDetailFilm(id  )
    }
}
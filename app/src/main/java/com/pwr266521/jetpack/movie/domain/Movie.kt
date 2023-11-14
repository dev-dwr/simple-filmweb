package com.pwr266521.jetpack.movie.domain

data class Movie(
    val icon: Int,
    val title: String,
    val duration: String,
    val description: String,
    val actors: List<Actor>,
    val scenes: List<Int>
)
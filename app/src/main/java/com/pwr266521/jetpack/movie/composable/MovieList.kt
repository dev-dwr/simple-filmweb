package com.pwr266521.jetpack.movie.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.pwr266521.jetpack.movie.domain.Movie

@Composable
fun MovieList(movies: List<Movie>, onRowClick: (Movie) -> Unit) {
    LazyColumn {
        items(movies.size) { index ->
            MovieRow(movies[index], onRowClick = { onRowClick(movies[index]) })
        }
    }
}
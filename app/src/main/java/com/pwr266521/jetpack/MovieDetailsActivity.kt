package com.pwr266521.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pwr266521.jetpack.MainActivity.Companion.MOVIE_ID
import com.pwr266521.jetpack.data.MOVIES_DATA.MOVIES
import com.pwr266521.jetpack.movie.composable.BackButton
import com.pwr266521.jetpack.movie.composable.MovieDetails
import com.pwr266521.jetpack.movie.bars.MyTopBar
import com.pwr266521.jetpack.movie.composable.ActorsList
import com.pwr266521.jetpack.movie.composable.ButtonsRow
import com.pwr266521.jetpack.movie.composable.SceneGrid
import com.pwr266521.jetpack.ui.theme.JetpackTheme

class MovieDetailsActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movieTitle = intent.extras?.getString(MOVIE_ID)
        val movie = MOVIES.first { it.title == movieTitle }
        setContent {
            var showCast by remember { mutableStateOf(true) }
            JetpackTheme {
                Scaffold(
                    topBar = { MyTopBar(MainActivity.APP_NAME) }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Column {
                                MovieDetails(movie)
                                ButtonsRow(
                                    showCast,
                                    onClickCast = { showCast = true },
                                    onClickGallery = { showCast = false }
                                )
                                if (showCast) ActorsList(actors = movie.actors) else SceneGrid(movie.scenes)
                            }
                            BackButton { finish() }
                        }
                    }
                }
            }
        }
    }
}

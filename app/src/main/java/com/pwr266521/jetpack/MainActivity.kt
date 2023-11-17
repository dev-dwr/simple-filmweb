package com.pwr266521.jetpack

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.pwr266521.jetpack.data.MOVIES_DATA.MOVIES
import com.pwr266521.jetpack.movie.composable.MovieList
import com.pwr266521.jetpack.movie.bars.MyTopBar
import com.pwr266521.jetpack.ui.theme.JetpackTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTheme {
                Scaffold(
                    topBar = { MyTopBar(stringResource(R.string.app_name)) }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        MovieList(movies = MOVIES) { movie ->
                            val intent = Intent(this, MovieDetailsActivity::class.java)
                            intent.putExtra("MOVIE_ID", movie.title)
                            startActivity(intent)
                        }
                    }
                }
            }
        }
    }
}
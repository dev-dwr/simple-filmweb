package com.pwr266521.jetpack

import android.content.Context
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
import com.pwr266521.jetpack.movie.domain.Movie
import com.pwr266521.jetpack.movie.ui.MovieList
import com.pwr266521.jetpack.movie.ui.bars.MyTopBar
import com.pwr266521.jetpack.ui.theme.JetpackTheme

val MOVIES = listOf(
    Movie(
        R.drawable.spiderman,
        "Spiderman 2",
        "1:30h",
        "This movie follows the story of Peter Parker, a high school student who gains spider-like abilities after being bitten by a genetically-modified spider. He adopts the superhero identity of Spider-Man to fight crime and face various villains in New York City, while also dealing with the struggles of his personal life and the responsibility that comes with his new powers."
    ),
    Movie(
        R.drawable.batman,
        "The Batman",
        "2h",
        "Set in the dark and gritty Gotham City, this film focuses on Bruce Wayne, a billionaire who, traumatized by the murder of his parents as a child, becomes the vigilante known as Batman. Equipped with high-tech gadgets and driven by a quest for justice, Batman battles against the city's criminal underworld, often facing complex and twisted adversaries."
    ),
    Movie(
        R.drawable.flash,
        "The Flash",
        "1h",
        "This movie centers around Barry Allen, a forensic scientist who gains super-speed abilities after an accident involving lightning and chemicals. As the Flash, he uses his extraordinary speed to fight crime and combat threats, while exploring the limits of his powers and dealing with time-travel complexities and alternate dimensions."
    ),
    Movie(
        R.drawable.superman,
        "The Superman 2",
        "3h",
        "The story of Superman revolves around Kal-El, the last survivor of the planet Krypton, sent to Earth as a baby. Raised as Clark Kent in a rural town, he discovers his superhuman abilities, including super strength, flight, and invulnerability. As Superman, he becomes a symbol of hope while protecting Earth from various alien and terrestrial threats, often while grappling "
    )
)

class MainActivity : ComponentActivity() {
    companion object {
        const val MOVIE_KEY = "MOVIE_TITLE"
        const val APP_NAME = "Studencki Filmweb"
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTheme {
                Scaffold(
                    topBar = { MyTopBar(APP_NAME) }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        MovieList(movies = MOVIES) { movie ->
                            startMovieDetailsActivity(
                                movie,
                                this
                            )
                        }
                    }
                }
            }
        }
    }

    private fun startMovieDetailsActivity(movie: Movie, context: Context) {
        val intent = Intent(context, MovieDetailsActivity::class.java)
        intent.putExtra(MOVIE_KEY, movie.title)
        startActivity(intent)
    }
}
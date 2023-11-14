package com.pwr266521.jetpack.movie.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pwr266521.jetpack.movie.domain.Movie

@Composable
fun MovieDetails(movie: Movie) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = movie.icon),
            contentDescription = movie.description,
            modifier = Modifier
                .size(150.dp)
        )

        Spacer(modifier = Modifier.width(20.dp))

        Column {
            Text(movie.title, style = MaterialTheme.typography.titleLarge)
            Text(movie.duration, style = MaterialTheme.typography.titleSmall)
            Text(movie.description, style = MaterialTheme.typography.bodyLarge)
        }
    }
}
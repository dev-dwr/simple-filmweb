package com.pwr266521.jetpack.movie.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.pwr266521.jetpack.movie.domain.Movie

@Composable
fun MovieRow(movie: Movie, onRowClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onRowClick() }
    ) {
        Image(
            painter = painterResource(id = movie.icon),
            contentDescription = "photo",
            modifier = Modifier.size(100.dp)
        )
        Spacer(Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                movie.title,
                style = MaterialTheme.typography.headlineSmall,
                maxLines = 1,
                overflow = TextOverflow.Clip
            )
        }
        Column(
            modifier = Modifier
                .wrapContentWidth(align = Alignment.End)
                .padding(top = 16.dp)
        ) {
            Text(
                movie.duration,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}
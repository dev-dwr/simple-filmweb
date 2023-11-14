package com.pwr266521.jetpack.movie.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pwr266521.jetpack.movie.domain.Actor

@Composable
fun ActorsList(actors: List<Actor>) {
    LazyColumn {
        items(actors.size) { index ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = actors[index].photo),
                    contentDescription = "Actor Icon",
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = actors[index].fullName,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 8.dp)
                )
            }
        }
    }
}
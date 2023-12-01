package com.pwr266521.jetpack.movie.composable

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.Util
import androidx.media3.datasource.DefaultDataSourceFactory
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.MediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView


@Composable
fun VideoPlayer(
    movies: List<Int>,
    initialTrailerIndex: Int,
) {
    val context = LocalContext.current
    var currentTrailerIndex by remember { mutableStateOf(initialTrailerIndex) }
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build()
    }.apply {
        preparePlayerWithVideo(context, movies[currentTrailerIndex])
    }

    fun playVideoAtIndex(index: Int) {
        if (index in movies.indices) {
            currentTrailerIndex = index
            exoPlayer.preparePlayerWithVideo(context, movies[index])
        }
    }

    if(movies.size > 1){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { playVideoAtIndex(currentTrailerIndex - 1) }) {
                Text("Previous")
            }
            Button(onClick = { playVideoAtIndex(currentTrailerIndex + 1) }) {
                Text("Next")
            }
        }
    }


    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        AndroidView(
            factory = { context ->
                PlayerView(context).apply {
                    player = exoPlayer
                    useController = true
                    layoutParams = FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
        )
    }

    DisposableEffect(key1 = exoPlayer) {
        onDispose {
            exoPlayer.release()
        }
    }
}
@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
private fun ExoPlayer.preparePlayerWithVideo(context: Context, videoResId: Int) {
    val videoSource: MediaSource = ProgressiveMediaSource.Factory(
        DefaultDataSourceFactory(
            context,
            Util.getUserAgent(context, "Simple Filmweb")
        )
    )
        .createMediaSource(MediaItem.fromUri("android.resource://${context.packageName}/$videoResId"))
    setMediaSource(videoSource)
    prepare()
}
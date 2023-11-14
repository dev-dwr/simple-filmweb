package com.pwr266521.jetpack.movie.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonsRow(
    showCast: Boolean,
    onClickCast: () -> Unit,
    onClickGallery: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        if (showCast) {
            Button(
                onClick = { onClickCast() },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text("Cast")
            }
            Button(
                onClick = { onClickGallery() },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text("Gallery")
            }
        } else {
            Button(
                onClick = { onClickCast() },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text("Cast")
            }
            Button(
                onClick = { onClickGallery() },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text("Gallery")
            }
        }
    }
}
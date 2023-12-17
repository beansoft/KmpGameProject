package com.jetbrains.game.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jetbrains.game.extensions.xOffset
import com.jetbrains.game.extensions.yOffset
import com.jetbrains.game.models.AsteroidData

@Composable
fun Asteroid(asteroidData: AsteroidData) {
    val asteroidSize = asteroidData.size.dp
    Box(
        Modifier
            .offset(asteroidData.xOffset, asteroidData.yOffset)
            .size(asteroidSize)
            .rotate(asteroidData.angle.toFloat())
            .clip(CircleShape)
            .background(Color(102, 102, 153))
    )
}

@Preview
@Composable
fun AsteroidPreview() {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color(0, 0, 30)),
        contentAlignment = Alignment.Center,
    ) {
        Asteroid(
            asteroidData = AsteroidData()
        )
    }
}
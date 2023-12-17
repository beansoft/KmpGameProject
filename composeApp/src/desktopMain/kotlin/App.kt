import androidx.compose.animation.AnimatedVisibility
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.jetbrains.game.Game
import com.jetbrains.game.components.Asteroid
import com.jetbrains.game.components.Bullet
import com.jetbrains.game.components.Ship
import com.jetbrains.game.components.ShipPreview
import com.jetbrains.game.models.AsteroidData
import com.jetbrains.game.models.BulletData
import com.jetbrains.game.models.ShipData
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun App() {
    val game = remember { Game() }
    val density = LocalDensity.current

    Column(modifier = Modifier.background(Color(51, 153, 255)).fillMaxHeight().fillMaxWidth()) {
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Button(onClick = {
            }) {
                Text("开始")
            }
            Text(
                game.gameStatus,
                modifier = Modifier.align(Alignment.CenterVertically).padding(horizontal = 16.dp),
                color = Color.White
            )
        }

        Box(
            modifier = Modifier
                .background(Color(80, 0, 80))
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Image(
                painter = BitmapPainter(useResource("Earth.jpg", ::loadImageBitmap)), "Test", modifier =
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clipToBounds(),
                contentScale = ContentScale.FillBounds
            )

            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clipToBounds()
                .pointerMoveFilter(onMove = {

                    false
                })
                .clickable() {

                }
                .onSizeChanged {
                    with(density) {
                        game.width = it.width.toDp()
                        game.height = it.height.toDp()
                    }
                }) {
                game.gameObjects.forEach {
                    when (it) {
                        is ShipData -> Ship(it)
                        else -> {}
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    App()
}
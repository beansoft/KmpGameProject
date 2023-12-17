import androidx.compose.animation.AnimatedVisibility
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import com.jetbrains.game.Game
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
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    App()
}
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import javax.swing.JPanel

@Composable
@Preview
fun App() {
    MaterialTheme {
        Row(Modifier.fillMaxSize()) {
            val colorMid = Color(36, 40, 41, 255)
            Box(Modifier.fillMaxHeight().weight(1f).background(colorMid))
            Box(Modifier.fillMaxHeight().weight(1f)) {
                SwingPanel(
                    background = colorMid,
                    factory = {
                        JPanel().apply {
                            background = java.awt.Color(colorMid.toArgb())
                        }
                    },
                    modifier = Modifier.fillMaxSize().background(colorMid)
                )
            }
            Box(Modifier.fillMaxHeight().weight(1f).background(colorMid))
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

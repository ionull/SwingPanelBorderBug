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
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import javax.swing.JPanel

@Composable
@Preview
fun App() {
    MaterialTheme {
        Row(Modifier.fillMaxSize()) {
            Box(Modifier.fillMaxHeight().weight(1f).background(Color.Red))
            Box(Modifier.fillMaxHeight().weight(1f)) {
                SwingPanel(
                    background = Color.Cyan,
                    factory = {
                        JPanel().apply {
                            background = java.awt.Color.CYAN
                        }
                    },
                    modifier = Modifier.fillMaxSize().background(Color.Cyan)
                )
            }
            Box(Modifier.fillMaxHeight().weight(1f).background(Color.Green))
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

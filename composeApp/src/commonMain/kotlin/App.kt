import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.pradip.cmp.scene.HomeScaffold

@Composable
@Preview
fun App() {
    MaterialTheme {
        HomeScaffold(modifier = Modifier)
    }
}
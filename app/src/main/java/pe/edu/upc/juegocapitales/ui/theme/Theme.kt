package pe.edu.upc.juegocapitales.ui.theme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable


private val DarkColorScheme = darkColorScheme(
    primary = Beige,
    onPrimary = DarkBrown,

    secondary = Cream,
    tertiary = DarkBrown,

    background = DarkBrown,
    onBackground = Cream,

    surface = Brown,
    onSurface = Cream,

    surfaceVariant = Brown,
    onSurfaceVariant = Beige

)
@Composable
fun JuegoCapitalesTheme(content: @Composable ()->Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}
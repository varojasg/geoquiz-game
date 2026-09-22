package pe.edu.upc.juegocapitales.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import pe.edu.upc.juegocapitales.R

val PlaypenSans = FontFamily(
    Font(
        resId = R.font.playpen_sans_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.playpen_sans_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resId = R.font.playpen_sans_semibold,
        weight = FontWeight.SemiBold
    )
)

val Typography = Typography(
    displayMedium = TextStyle(
        fontFamily = PlaypenSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 45.sp
    ),

    headlineLarge = TextStyle(
        fontFamily = PlaypenSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp
    ),

    headlineMedium = TextStyle(
        fontFamily = PlaypenSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp
    ),

    headlineSmall = TextStyle(
        fontFamily = PlaypenSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),

    titleLarge = TextStyle(
        fontFamily = PlaypenSans,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp
    ),

    titleMedium = TextStyle(
        fontFamily = PlaypenSans,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = PlaypenSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = PlaypenSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    labelLarge = TextStyle(
        fontFamily = PlaypenSans,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
)
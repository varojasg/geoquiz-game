package pe.edu.upc.juegocapitales.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(onContinentsClick: () ->Unit, onFavoritesClick: ()->Unit){
    Column(){
        Text(text = "GeoQuiz", fontSize = 16.sp)
        Text(text = "Bienvenid@", fontSize = 16.sp)
        Button(onClick= onContinentsClick){Text(text="Explora continentes", fontSize = 12.sp)}
        Button(onClick = onFavoritesClick) {Text(text="Ver favoritos", fontSize = 12.sp) }


    }

}
package pe.edu.upc.juegocapitales.presentation.continentdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import pe.edu.upc.juegocapitales.model.Continent


@Composable
fun ContinentDetailScreen(selectedContinent: Continent, onStartQuiz:()-> Unit, isFavorite: Boolean, onFavoriteClick: ()-> Unit){
    Column{
        Text(text=selectedContinent.name)
        Text(text=selectedContinent.description)
        Text(text="Cantidad de paises: ${selectedContinent.countryCount}")
        Button(onClick = onFavoriteClick) {
            Text(text = if(isFavorite)"Quitar de favoritos" else "Agregar a favoritos")
        }
        Button(onClick = onStartQuiz) {
            Text(text = "Iniciar Quiz")
        }
    }
}
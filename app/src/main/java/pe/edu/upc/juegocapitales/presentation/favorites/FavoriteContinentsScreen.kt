package pe.edu.upc.juegocapitales.presentation.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pe.edu.upc.juegocapitales.data.local.FavoriteContinent

@Composable
fun FavoriteContinentsScreen(favoriteContinents: List<FavoriteContinent>,onDeleteFavorite: (FavoriteContinent)-> Unit){
    Column{
        Text(text="CONTINENTES FAVORITOS")

        if(favoriteContinents.isEmpty()){
            Text(text="Todavia no has guardado continentes como favoritos")
        }else{
            LazyColumn {
                items(favoriteContinents){favoriteContinent->
                    Card{
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(favoriteContinent.name)
                            Text(favoriteContinent.description)
                            Text("Cantidad de paises: ${favoriteContinent.countryCount}")
                            Button(onClick = { onDeleteFavorite(favoriteContinent) }) {
                                Text(text = "Eliminar")
                            }
                        }
                    }
                }
            }
        }

    }
}
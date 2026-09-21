package pe.edu.upc.juegocapitales.presentation.continents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import pe.edu.upc.juegocapitales.model.Continent

@Composable
fun ContinentsScreen(onContinentClick:(Continent)-> Unit){
    /*LOGIC*/
    //Variables
    val continents = listOf(
        Continent("Africa","Es la cuna de la humanidad, famosa por su gran biodiversidad, el desierto del Sáhara y su inmensa riqueza cultural.", 54),
        Continent("Asia","Es el continente más grande y poblado del planeta, albergando las economías más dinámicas y las montañas más altas del mundo",49),
        Continent("Europa","Es el centro histórico de la cultura occidental, caracterizado por su alta densidad demográfica, su rica arquitectura y una fuerte integración política",50),
        Continent("America","Es un bloque continental que se extiende de polo a polo, caracterizado por su enorme variedad de climas, la cordillera de los Andes y potencias económicas globales",35),
        Continent("Oceania","Es el continente más pequeño y está formado por Australia junto con miles de islas tropicales dispersas por el océano Pacífico",14),
    )

    Column{
        Text(text="CONTINENTES DISPONIBLES")
        Text(text="Selecciona un continente para comenzar")
        LazyColumn{
            items(continents){
                continent->
                Card(onClick = {onContinentClick(continent)}) {
                    Text(text = continent.name)
                    Text(text = continent.description)
                    Text(text = "Cantidad de paises:${continent.countryCount}")
                }
            }
        }
    }
}
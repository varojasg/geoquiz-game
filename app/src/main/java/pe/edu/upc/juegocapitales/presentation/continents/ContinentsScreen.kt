package pe.edu.upc.juegocapitales.presentation.continents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    Scaffold(containerColor = MaterialTheme.colorScheme.background) {
        innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding).padding(16.dp))
        {
            Text(
                text="CONTINENTES DISPONIBLES",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text="Selecciona un continente para comenzar",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
            )

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)){
                items(continents){
                        continent->
                    ElevatedCard(
                        onClick = {onContinentClick(continent)},
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)

                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = continent.name,
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Text(
                                text = continent.description,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                            Text(
                                text = "Cantidad de paises:${continent.countryCount}",
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.padding(top = 12.dp)
                            )
                        }

                    }
                }
            }
        }
    }

}
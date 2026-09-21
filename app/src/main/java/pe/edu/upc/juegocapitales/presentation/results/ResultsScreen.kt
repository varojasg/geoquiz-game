package pe.edu.upc.juegocapitales.presentation.results

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import pe.edu.upc.juegocapitales.model.Continent
import pe.edu.upc.juegocapitales.model.Question

@Composable
fun ResultsScreen(selectedContinent: Continent, correctAnswers: Int, incorrectQuestions: List<Question>, onRestartQuiz: ()->Unit, onRetryErrors:()->Unit, onBackToContinents: ()-> Unit){

    /*LOGIC*/
    val totalQuestions = correctAnswers + incorrectQuestions.size
    val accuracy = correctAnswers*100/totalQuestions


    /*UI*/
    Column() {
        Text("Resultados del quiz ${selectedContinent.name}")
        Text("Respuestas correctas: $correctAnswers")
        Text("RespuestaS incorrectas: ${incorrectQuestions.size}")

        Text("Precisión: $accuracy")
        Button(onClick =  onRestartQuiz ) { Text("Reiniciar") }
        if(incorrectQuestions.isNotEmpty()){
            Button(onClick =  onRetryErrors ) { Text("Repasar errores") }
        }

        Button(onClick = onBackToContinents) { Text("Volver") }
    }
}
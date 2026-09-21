package pe.edu.upc.juegocapitales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.juegocapitales.data.QuestionsData
import pe.edu.upc.juegocapitales.model.Continent
import pe.edu.upc.juegocapitales.model.Question
import pe.edu.upc.juegocapitales.navigation.GeoQuizNavigation
import pe.edu.upc.juegocapitales.ui.theme.JuegoCapitalesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JuegoCapitalesTheme() {
                GeoQuizNavigation()}

        }
    }
}

@Composable
fun GeoQuizGameApp(questions: List<Question>, onQuizFinished: (Int, List<Question>) -> Unit){
    /*LOGIC*/

    //State definition
    var currentIndex by remember{
        mutableStateOf(0)
    }

    var selectedAnswer by remember{
        mutableStateOf<Boolean?>(null)
    }

    var correctAnswers by remember{
        mutableStateOf<Int>(0)
    }

    val incorrectQuestions = remember{
        mutableStateListOf<Question>()
    }


    /*UI*/
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){


        //Mostrar pregunta
        Text(text = questions[currentIndex].question, fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        //Mostrar feedback
        selectedAnswer?.let {
            answer -> val feedback = if(answer == questions[currentIndex].answer) "Correcto" else "Incorrecto"
            Text(text= feedback)
        }

        //Botones de respuesta
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()){
            Button(onClick = {selectedAnswer = true}){
                Text(text= "Si" )
            }
            Button(onClick = {selectedAnswer = false}){
                Text(text= "No" )
            }

        }

        Button(onClick = {
            //Cambiar estadisticas
            if (selectedAnswer == questions[currentIndex].answer) correctAnswers++ else incorrectQuestions.add(questions[currentIndex])

            if (currentIndex < questions.size - 1) {
                currentIndex++
                selectedAnswer = null
            } else {
                onQuizFinished(correctAnswers,incorrectQuestions.toList())
            } },
            enabled = selectedAnswer!=null)
        {
            Text("Siguiente")
        }




    }


}
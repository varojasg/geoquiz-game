package pe.edu.upc.juegocapitales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import pe.edu.upc.juegocapitales.model.Question
import pe.edu.upc.juegocapitales.navigation.GeoQuizNavigation
import pe.edu.upc.juegocapitales.ui.theme.JuegoCapitalesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            JuegoCapitalesTheme {
                GeoQuizNavigation()
            }
        }
    }
}

@Composable
fun GeoQuizGameApp(
    questions: List<Question>,
    onQuizFinished: (Int, List<Question>) -> Unit
) {
    /*LOGIC*/

    var currentIndex by remember {
        mutableStateOf(0)
    }

    var selectedAnswer by remember {
        mutableStateOf<Boolean?>(null)
    }

    var correctAnswers by remember {
        mutableStateOf(0)
    }

    val incorrectQuestions = remember {
        mutableStateListOf<Question>()
    }

    /*UI*/

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = "Quiz",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = "Pregunta ${currentIndex + 1} de ${questions.size}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
            )

            Text(
                text = questions[currentIndex].question,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(vertical = 24.dp)
            )

            selectedAnswer?.let { answer ->
                val isCorrect = answer == questions[currentIndex].answer

                Text(
                    text = if (isCorrect) "Correcto" else "Incorrecto",
                    style = MaterialTheme.typography.titleMedium,
                    color = if (isCorrect)
                        MaterialTheme.colorScheme.primary
                    else
                        MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                FilledTonalButton(
                    onClick = {
                        selectedAnswer = true
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.width(120.dp)
                ) {
                    Text(text = "Sí")
                }

                FilledTonalButton(
                    onClick = {
                        selectedAnswer = false
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.width(120.dp)
                ) {
                    Text(text = "No")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    val isCorrect = selectedAnswer == questions[currentIndex].answer
                    val updatedCorrectAnswers = correctAnswers + if (isCorrect) 1 else 0

                    if (!isCorrect) {
                        incorrectQuestions.add(questions[currentIndex])
                    }

                    if (currentIndex < questions.size - 1) {
                        correctAnswers = updatedCorrectAnswers
                        currentIndex++
                        selectedAnswer = null
                    } else {
                        onQuizFinished(
                            updatedCorrectAnswers,
                            incorrectQuestions.toList()
                        )
                    }
                },
                enabled = selectedAnswer != null,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = if (currentIndex < questions.size - 1)
                        "Siguiente"
                    else
                        "Ver resultados"
                )
            }
        }
    }
}
package pe.edu.upc.juegocapitales.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import kotlinx.coroutines.launch
import pe.edu.upc.juegocapitales.GeoQuizGameApp
import pe.edu.upc.juegocapitales.data.QuestionsData
import pe.edu.upc.juegocapitales.data.local.FavoriteContinent
import pe.edu.upc.juegocapitales.data.local.FavoriteContinentDao
import pe.edu.upc.juegocapitales.data.local.GeoQuizDatabase
import pe.edu.upc.juegocapitales.model.Continent
import pe.edu.upc.juegocapitales.model.Question
import pe.edu.upc.juegocapitales.presentation.continentdetail.ContinentDetailScreen
import pe.edu.upc.juegocapitales.presentation.continents.ContinentsScreen
import pe.edu.upc.juegocapitales.presentation.favorites.FavoriteContinentsScreen
import pe.edu.upc.juegocapitales.presentation.home.HomeScreen
import pe.edu.upc.juegocapitales.presentation.results.ResultsScreen
import kotlin.collections.emptyList

@Composable
fun GeoQuizNavigation(){
    /*LOGIC*/

    //State creation
    val appNavController = rememberNavController()

    var selectedContinent by remember{
        mutableStateOf<Continent?>(null)
    }

    var finalCorrectAnswers by remember{
        mutableStateOf(0)
    }

    var finalIncorrectQuestions by remember{
        mutableStateOf<List<Question>>(emptyList())
    }
    var quizQuestions by remember{
        mutableStateOf<List<Question>>(emptyList())
    }

    //Room
    val context = LocalContext.current

    val geoQuizDatabase = remember{
        Room.databaseBuilder(
            context,
            GeoQuizDatabase::class.java,
            "geoquiz_database"
        ).build()
    }

    val favoriteContinentDao = geoQuizDatabase.favoriteContinentDao()

    val coroutineScope = rememberCoroutineScope()

    val favoriteContinents by favoriteContinentDao.getAllFavorites().collectAsState(initial=emptyList())

    /*UI*/
    NavHost(navController = appNavController, startDestination = "home"){
        composable("home"){
            HomeScreen(
                onContinentsClick = {appNavController.navigate("continents")},
                onFavoritesClick = {appNavController.navigate("favorites")})
        }
        composable("continents"){
            ContinentsScreen(onContinentClick = {
                continent ->
                selectedContinent = continent
                appNavController.navigate("continent_detail")
            })
        }
        composable("favorites"){
            FavoriteContinentsScreen(favoriteContinents = favoriteContinents, onDeleteFavorite = {
                favoriteContinent -> coroutineScope.launch {
                    favoriteContinentDao.deleteFavorite(favoriteContinent)
            }
            })
        }
        composable("continent_detail"){
            selectedContinent?.let{continent->
                val isFavorite = favoriteContinents.any{favorite-> favorite.name == continent.name}

                ContinentDetailScreen(
                    selectedContinent = continent,
                    onStartQuiz = {
                        quizQuestions = QuestionsData.allQuestions.filter { question->question.continent ==continent.name}
                        appNavController.navigate("quiz")
                    },
                    isFavorite = isFavorite,
                    onFavoriteClick = {
                        val favoriteContinent = FavoriteContinent(name = continent.name, description = continent.description, countryCount = continent.countryCount)
                        coroutineScope.launch {
                            if(isFavorite){
                                favoriteContinentDao.deleteFavorite(favoriteContinent)
                            }else{
                                favoriteContinentDao.insertFavorite(favoriteContinent)
                            }
                        }
                    }
                )
            }
        }

        composable("quiz"){
                GeoQuizGameApp(
                    questions = quizQuestions, onQuizFinished = {correctAnswers, incorrectQuestions->
                        finalCorrectAnswers = correctAnswers
                        finalIncorrectQuestions = incorrectQuestions
                        appNavController.navigate("results")

                    }
                )
        }



        composable("results"){
            selectedContinent?.let {
                currentContinent->
                ResultsScreen(
                    selectedContinent = currentContinent,
                    correctAnswers = finalCorrectAnswers,
                    incorrectQuestions = finalIncorrectQuestions,
                    onRestartQuiz = {
                      quizQuestions = QuestionsData.allQuestions.filter { question-> question.continent == currentContinent.name }
                        appNavController.navigate("quiz")
                    },
                    onRetryErrors = {
                        quizQuestions = finalIncorrectQuestions
                        appNavController.navigate("quiz")
                    },
                    onBackToContinents = {
                        appNavController.navigate("continents")
                    }
                )

            }

        }

    }
}
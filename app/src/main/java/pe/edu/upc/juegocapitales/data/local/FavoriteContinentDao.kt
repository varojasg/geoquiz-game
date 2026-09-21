package pe.edu.upc.juegocapitales.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface FavoriteContinentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favoriteContinent: FavoriteContinent)

    @Delete
    suspend fun deleteFavorite(favoriteContinent: FavoriteContinent)

    @Query("SELECT * FROM favorite_continents")
    fun getAllFavorites(): Flow<List<FavoriteContinent>>

}
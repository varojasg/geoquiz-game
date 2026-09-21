package pe.edu.upc.juegocapitales.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities=[FavoriteContinent::class], version=1)
abstract class GeoQuizDatabase: RoomDatabase() {
    abstract fun favoriteContinentDao(): FavoriteContinentDao
}
package pe.edu.upc.juegocapitales.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "favorite_continents")
data class FavoriteContinent(
    @PrimaryKey
    val name: String,
    val description: String,
    val countryCount: Int
)
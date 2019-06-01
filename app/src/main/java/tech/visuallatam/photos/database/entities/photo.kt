package tech.visuallatam.photos.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity(tableName="photo")
data class photo(
    @PrimaryKey
    @field:Json(name="id")
    val id: Int ,
    @field:Json(name="author")
    val author: String,
    @field:Json(name="width")
    val width : Int,
    @field:Json(name="height")
    val height : Int,
    @field:Json(name="download_url")
    val download_ulr: String



)
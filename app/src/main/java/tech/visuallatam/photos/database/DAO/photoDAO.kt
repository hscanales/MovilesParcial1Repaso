package tech.visuallatam.photos.database.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tech.visuallatam.photos.database.entities.photo

@Dao
interface photoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photo: photo)

    @Query("SELECT * FROM photo")
    fun getAll():LiveData<List<photo>>

    @Query ("DELETE FROM photo")
    suspend fun nuke()

}
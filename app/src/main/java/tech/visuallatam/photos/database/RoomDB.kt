package tech.visuallatam.photos.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tech.visuallatam.photos.database.DAO.photoDAO
import tech.visuallatam.photos.database.entities.photo


@Database(entities = [photo::class],version = 1,exportSchema = false)
public abstract class RoomDB: RoomDatabase(){
    abstract  fun photoDao():photoDAO

    companion object {
        @Volatile
        private var INSTANCE : RoomDB? = null

        fun getInstance(context: Context):RoomDB{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, RoomDB::class.java, "photo_Database")
                    .build()
                INSTANCE=instance
                return instance
            }
        }
    }
}
package tech.visuallatam.photos.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import tech.visuallatam.photos.database.DAO.photoDAO
import tech.visuallatam.photos.database.entities.photo

class photoRepo(private val photoDAO: photoDAO) {


    @WorkerThread
    suspend  fun insert(photo:photo){
        photoDAO.insert(photo)
    }

    fun todos():LiveData<List<photo>>{
        return photoDAO.getAll()
    }

    @WorkerThread
    suspend fun nuke() = photoDAO.nuke()


}
package tech.visuallatam.photos.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Deferred
import retrofit2.Response

import tech.visuallatam.photos.database.DAO.photoDAO
import tech.visuallatam.photos.database.entities.photo
import tech.visuallatam.photos.service.retrofit.retrofit

class photoRepo(private val photoDAO: photoDAO,private val retrofit:retrofit) {


    @WorkerThread
    suspend  fun insert(photo:photo){
        photoDAO.insert(photo)
    }

    fun todos():LiveData<List<photo>>{
        return photoDAO.getAll()
    }

    @WorkerThread
    suspend fun nuke() = photoDAO.nuke()

    fun getShit(): Deferred<Response<List<photo>>> {return retrofit.getfotos()}
}
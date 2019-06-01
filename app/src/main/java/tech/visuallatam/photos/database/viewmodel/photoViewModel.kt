package tech.visuallatam.photos.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import tech.visuallatam.photos.database.RoomDB
import tech.visuallatam.photos.database.entities.photo
import tech.visuallatam.photos.database.repositories.photoRepo

class photoViewModel(private  val app : Application): AndroidViewModel(app) {

private val repository: photoRepo

    init{
        val photoDAO = RoomDB.getInstance(app).photoDao()
        repository = photoRepo(photoDAO)
    }

    private suspend fun insert(photo: photo) = repository.insert(photo)

    fun todos(): LiveData<List<photo>> = repository.todos()

    private suspend  fun nuke() = repository.nuke()

}
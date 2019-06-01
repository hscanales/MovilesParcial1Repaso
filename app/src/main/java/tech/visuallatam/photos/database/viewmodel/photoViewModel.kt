package tech.visuallatam.photos.database.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tech.visuallatam.photos.database.RoomDB
import tech.visuallatam.photos.database.entities.photo
import tech.visuallatam.photos.database.repositories.photoRepo
import tech.visuallatam.photos.service.retrofit.retrofit

class photoViewModel(private  val app : Application): AndroidViewModel(app) {

private val repository: photoRepo

    init{
        val photoDAO = RoomDB.getInstance(app).photoDao()
        repository = photoRepo(photoDAO,retrofit.getRetrofitInstance())
    }

    private suspend fun insert(photo: photo) = repository.insert(photo)

    fun todos(): LiveData<List<photo>> = repository.todos()

    private suspend  fun nuke() = repository.nuke()


    fun getstuff() = viewModelScope.launch {
        this@photoViewModel.nuke()
        val response = repository.getShit().await()

        if(response.isSuccessful) with(response){
            this.body()?.forEach{
                this@photoViewModel.insert(it)
            }
        }else with(response){
            when(response.code()){
                404 -> {
                    Toast.makeText(app,"Oh shxt", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
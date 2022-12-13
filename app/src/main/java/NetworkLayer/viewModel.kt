package NetworkLayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class viewModel: ViewModel()

{
    //store the data in a mutan\ble format
    private val photofromMars=MutableLiveData<String>()
val thephotos:LiveData<String> =photofromMars

    private fun getphoto()
    {
        viewModelScope.launch {
            val theMarsPhotos=MarsApi.retrofitservice.getPhotos()
            photofromMars.value= theMarsPhotos.size.toString()
        }
    }

}

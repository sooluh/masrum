package id.my.suluh.jamurize.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DatasetViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Dataset fragment"
    }

    val text: LiveData<String> = _text

}

package id.my.suluh.jamurize.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FeatureViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fitur fragment"
    }

    val text: LiveData<String> = _text

}

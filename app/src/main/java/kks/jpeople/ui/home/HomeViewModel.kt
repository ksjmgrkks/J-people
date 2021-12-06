package kks.jpeople.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _ttext = MutableLiveData<String>().apply {
        value = "홈 프래그먼트입니다."
    }
    val text: LiveData<String> = _ttext
}
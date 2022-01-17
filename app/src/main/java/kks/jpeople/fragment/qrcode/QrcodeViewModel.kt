package kks.jpeople.fragment.qrcode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QrcodeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "QR 코드 프래그먼트입니다."
    }
    val text: LiveData<String> = _text
}
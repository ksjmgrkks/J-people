package kks.jpeople.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _userList = MutableLiveData<ArrayList<User>>()
    val userList : LiveData<ArrayList<User>>
        get() = _userList

    private var items = ArrayList<User>()

    init{
        items = arrayListOf(
            User("Kyu Seong",28),
            User("Won Seok",26)
        )
        _userList.value = items
    }

    fun buttonClick(){
        val user = User("yeong min Master",38)
        items.add(user)
        _userList.value = items
    }
}
package com.techcafe.todone.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val list = mutableListOf<MutableLiveData<String>>()
}

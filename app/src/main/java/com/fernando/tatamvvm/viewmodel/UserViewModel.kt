package com.fernando.tatamvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fernando.tatamvvm.model.UserModel
import com.fernando.tatamvvm.repository.UserRepository

class UserViewModel : ViewModel(){
    private val userRepository: UserRepository = UserRepository()

    private var userMsg: MutableLiveData<String> = MutableLiveData()

    var userLiveData: LiveData<String> = userMsg

    fun returnMessageToUser(userModel: UserModel) : LiveData<String> {
        if (userModel.companyName.isNotEmpty() && userModel.companyName.isNotEmpty()) {
            if (userRepository.doLogin(userModel)) {
                userMsg.value = "${userModel.name}, Login MVVM success"
            } else {
                userMsg.value = "${userModel.name}, Login MVVM failure"
            }
        }
        return userMsg
    }
}
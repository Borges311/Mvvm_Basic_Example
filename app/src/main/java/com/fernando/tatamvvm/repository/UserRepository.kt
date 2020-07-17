package com.fernando.tatamvvm.repository

import com.fernando.tatamvvm.model.UserModel

class UserRepository {
    /*
       Put here your DAOs metods or Retrofit to Get Local or Remote Data
   */
    fun doLogin(userModel: UserModel) : Boolean{
        return userModel.name == "Tata" && userModel.companyName == "TCS"
    }

}
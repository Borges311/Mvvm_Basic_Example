package com.fernando.tatamvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fernando.tatamvvm.R
import com.fernando.tatamvvm.model.UserModel
import com.fernando.tatamvvm.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {
    private var userViewModel = UserViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        doLogin()

        // Initiate ViewModel and Observe any changes in userLiveData
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.userLiveData.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }
    fun doLogin(){
        // The View is responsible for user interactions
        // Call login method if user is empty or not
        // because viewModel is responsible for check and validate data

        button.setOnClickListener {
            val user = UserModel(edit_name.text.toString(),
                                 edit_company_name.text.toString())
            userViewModel.returnMessageToUser(user)
        }
    }
}
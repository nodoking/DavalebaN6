package com.example.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.main_activity.*

class ActivityMain : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        init()
    }

    private fun init() {
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)

        val email = sharedPreferences.getString("email", "")
        val firstName = sharedPreferences.getString("firstName", "")
        val lastName = sharedPreferences.getString("lastName", "")
        val age = sharedPreferences.getInt("age", 0)
        val address = sharedPreferences.getString("address", "")

        emailEditText.setText(email)
        firstNameEditText.setText(firstName)
        lastNameEditText.setText(lastName)
        ageEditText.setText(age.toString())
        addressEditText.setText(address)

    }

    fun save(view: View){
        val email = emailEditText.text.toString()
        val firstName = firstNameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()
        val age = ageEditText.text.toString()
        val address = addressEditText.text.toString()

        if (email.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty() && age.isNotEmpty() && address.isNotEmpty()) {
            val editor = sharedPreferences.edit()
            editor.putString("email", email)
            editor.putString("firstName", firstName)
            editor.putString("lastName", lastName)
            editor.putInt("age", age.toInt())
            editor.putString("address", address)
            editor.apply()

            Toast.makeText(applicationContext,"Success!", Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(applicationContext, "Please Check The Fields!", Toast.LENGTH_SHORT).show()
        }
    }
}
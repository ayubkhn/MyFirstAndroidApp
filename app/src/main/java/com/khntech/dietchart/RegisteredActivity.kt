package com.khntech.dietchart

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.khntech.dietchart.databinding.ActivityRegisteredBinding

class RegisteredActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisteredBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisteredBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.detail1.visibility = View.VISIBLE
        binding.detail2.visibility = View.GONE
        binding.detail3.visibility = View.GONE
        binding.detail4.visibility = View.GONE
        binding.detail5.visibility = View.GONE
        binding.detail6.visibility = View.GONE


        binding.nameNextBtn.setOnClickListener {
            enterYourName()
        }
        binding.ageNextBtn.setOnClickListener {
            enterYourAge()
        }
        binding.genderNextBtn.setOnClickListener {
            selectYourGender()
        }
        binding.heightNextBtn.setOnClickListener {
            enterYourHeight()
        }
        binding.weightNextBtn.setOnClickListener {
            enterYourWeight()
        }
        binding.CreateBtn.setOnClickListener {
            createYourAccount()
        }
    }

    private fun enterYourName() {
        if (binding.registeredNameTxt.text.toString().isEmpty()) {
            binding.registeredNameTxt.error = "Please Enter Your Name"

        } else {
            Toast.makeText(this, "Name Saved", Toast.LENGTH_SHORT).show()
        }

        if (binding.registeredNameTxt.text.toString().isEmpty()) {
            Toast.makeText(this, "Enter Your Name", Toast.LENGTH_SHORT).show()
        } else {
            binding.detail1.visibility = View.GONE
            binding.detail2.visibility = View.VISIBLE
            binding.detail3.visibility = View.GONE
            binding.detail4.visibility = View.GONE
            binding.detail5.visibility = View.GONE


        }

    }

    private fun enterYourAge() {

        if (binding.registeredAgeTxt.text.toString().isEmpty()) {
            binding.registeredAgeTxt.error = "Please Select Your Age"
        } else {
            Toast.makeText(this, "Age Saved", Toast.LENGTH_SHORT).show()
        }
        if (binding.registeredAgeTxt.text.toString().isEmpty()) {
            binding.registeredAgeTxt.error = "Please Select Your Age"
        } else {
            binding.detail1.visibility = View.GONE
            binding.detail2.visibility = View.GONE
            binding.detail3.visibility = View.VISIBLE
            binding.detail4.visibility = View.GONE
            binding.detail5.visibility = View.GONE
        }
    }

    private fun selectYourGender() {
        if (binding.registeredGenderTxt.text.toString().isEmpty()) {
            Toast.makeText(this, "Gender Skipped", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Gender Saved", Toast.LENGTH_SHORT).show()
        }
        if (binding.registeredGenderTxt.text.toString().isEmpty()) {
            Toast.makeText(this, "Gender Skipped", Toast.LENGTH_SHORT).show()
        }

        binding.detail1.visibility = View.GONE
        binding.detail2.visibility = View.GONE
        binding.detail3.visibility = View.GONE
        binding.detail4.visibility = View.VISIBLE
        binding.detail5.visibility = View.GONE

    }

    private fun enterYourHeight() {
        if (binding.registeredHeightTxt.text.toString().isEmpty()) {
            binding.registeredHeightTxt.error = "Please Select Your Height"
        } else {
            Toast.makeText(this, "Height Saved", Toast.LENGTH_SHORT).show()
        }
        if (binding.registeredHeightTxt.text.toString().isEmpty()) {
            binding.registeredHeightTxt.error = "Please Select Your Age"
        } else {
            binding.detail1.visibility = View.GONE
            binding.detail2.visibility = View.GONE
            binding.detail3.visibility = View.GONE
            binding.detail4.visibility = View.GONE
            binding.detail5.visibility = View.VISIBLE
            binding.detail6.visibility = View.GONE
        }
    }

    private fun enterYourWeight() {
        if (binding.registeredWeightTxt.text.toString().isEmpty()) {
            binding.registeredWeightTxt.error = "Please Select Your weight"
        } else {
            Toast.makeText(this, "Weight Saved", Toast.LENGTH_SHORT).show()
        }
        if (binding.registeredWeightTxt.text.toString().isEmpty()) {
            binding.registeredWeightTxt.error = "Please Select Your Age"
        } else {
            binding.detail1.visibility = View.GONE
            binding.detail2.visibility = View.GONE
            binding.detail3.visibility = View.GONE
            binding.detail4.visibility = View.GONE
            binding.detail5.visibility = View.GONE
            binding.detail6.visibility = View.VISIBLE
        }
    }

    private fun createYourAccount() {
        val emailId = binding.createEmailTxt.text.toString()
        val pass = binding.createPasswordTxt.text.toString()

        if (emailId.isBlank() || pass.isBlank()) {
            Toast.makeText(this, "Email Id and Password can't be empty", Toast.LENGTH_SHORT).show()
            return
        } else {

            auth.createUserWithEmailAndPassword(emailId, pass).addOnCompleteListener(this) {

                if (it.isSuccessful) {
                    Toast.makeText(this, "successfully Signed!! Please Login.." , Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, Page1Activity::class.java))

                    val myPrefer = getSharedPreferences("KEY", Context.MODE_PRIVATE)
                    val editor = myPrefer.edit()

                    editor.putString("gen", binding.registeredGenderTxt.text.toString())
                    editor.putString("name", binding.registeredNameTxt.text.toString())
                    editor.putInt("age", binding.registeredAgeTxt.text.toString().toInt())
                    editor.putFloat("height", binding.registeredHeightTxt.text.toString().toFloat())
                    editor.putFloat("weight", binding.registeredWeightTxt.text.toString().toFloat())
                    editor.putString("email", binding.createEmailTxt.text.toString())
                    editor.apply()

                } else {
                    Toast.makeText(this, "Signed Failed", Toast.LENGTH_SHORT).show()


                }
            }


        }
    }
}

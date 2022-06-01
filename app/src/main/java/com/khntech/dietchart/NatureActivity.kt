package com.khntech.dietchart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class NatureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nature)
    }

    fun angerIssue(view: View) {
        startActivity(Intent(this, AngryTypeActivity::class.java))
    }

    fun lazy(view: View) {
        startActivity(Intent(this, LazyTypeActivity::class.java))
    }

    fun inActive(view: View) {
        startActivity(Intent(this, LazyTypeActivity::class.java))
    }

    fun decent(view: View) {
        startActivity(Intent(this, normalType2::class.java))
    }

    fun calm(view: View) {
        startActivity(Intent(this, normalType2::class.java))
    }

    fun aggressive(view: View) {
        startActivity(Intent(this, AngryTypeActivity::class.java))
    }


}
package com.example.slidefragmentsumple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{

            supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.slid_in_botm,R.anim.slide_out_botm)
                .replace(R.id.frame,BlankFragment(),"h")
                .addToBackStack("h")
                .commit()

        }
    }
}

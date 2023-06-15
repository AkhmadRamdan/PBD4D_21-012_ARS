package com.example.fragment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA = fragmentA()

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragmentA).commit()
    }

    override fun passData(editTextData: String) {
        val bundle = Bundle()
        bundle.putString("massage",editTextData)

        val transactionn= this.supportFragmentManager.beginTransaction()
        val  fragmentB = fragmentB()

        fragmentB.arguments = bundle

        transactionn.replace(R.id.fragment_container,fragmentB).commit()
    }
}
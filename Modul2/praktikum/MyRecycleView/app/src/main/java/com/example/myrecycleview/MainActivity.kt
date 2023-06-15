package com.example.myrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var rvKomik: RecyclerView
    private val list = ArrayList<komik>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKomik = findViewById(R.id.rv_komik)
        rvKomik.setHasFixedSize(true)

        list.addAll(getListKomik())
        showRecyclerList()
    }
    private fun getListKomik(): ArrayList<komik> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listKomik = ArrayList<komik>()
        for (i in dataName.indices) {
            val komik = komik(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listKomik.add(komik)
        }
        return listKomik
    }
    private fun showRecyclerList() {
        rvKomik.layoutManager = LinearLayoutManager(this)
        val listKomikAdapter = ListKomikAdapter(list)
        rvKomik.adapter = listKomikAdapter
    }
}
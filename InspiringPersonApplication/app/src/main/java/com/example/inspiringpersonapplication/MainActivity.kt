package com.example.inspiringpersonapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inspiringpersonapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUI()
    }

    private fun initializeUI(){
        setUpFloatingActionButton()
        setUpRecyclerView()
    }

    private fun setUpFloatingActionButton(){
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.fabAddInspiringPerson.setOnClickListener{createNewInspiringPerson()}
        setContentView(mainBinding.root)
    }

    private fun createNewInspiringPerson(){
        val newInspiringPersonIntent = Intent(this, AddNewInspiringPersonActivity::class.java)
        startActivity(newInspiringPersonIntent)
    }

    private fun setUpRecyclerView(){
        mainBinding.rvInspiringPersons.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        mainBinding.rvInspiringPersons.adapter = InspiringPersonAdapter(PeopleRepository.getInspiringPersons())
    }

    override fun onResume() {
        super.onResume()
        (mainBinding.rvInspiringPersons.adapter as InspiringPersonAdapter).refreshData(PeopleRepository.getInspiringPersons())
    }
}
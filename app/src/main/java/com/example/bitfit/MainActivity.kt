package com.example.bitfit

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var mItem: List<ClipData.Item>
    lateinit var foodCal: ArrayList<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodList = findViewById<RecyclerView>(R.id.food)
        val adapter = FoodAdapter(foodCal)
        val foodAdapter = FoodAdapter(foodCal)

        lifecycleScope.launch{

            (application as MyApplication).db.calorieDao().getAll().collect { databaseList ->
                databaseList.map { entity->
                    Food(
                        entity.foodName,
                        entity.calories,

                    ).also { mappedList ->
                        //foodCal.clear()
                        foodCal.addAll(listOf(mappedList))
                        foodAdapter.notifyDataSetChanged()
                    }
                }
            }
        }

        foodList.adapter = adapter
        foodList.layoutManager = LinearLayoutManager(this)

        val newEntry = findViewById<Button>(R.id.recordButton)

        fun launchComposeView() {
           val i = Intent(this@MainActivity, DetailActivity::class.java)
          startActivity(i)


        }

    }
}
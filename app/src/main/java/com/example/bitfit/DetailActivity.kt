package com.example.bitfit

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class DetailActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?){

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val recordBtn = findViewById<Button>(R.id.recordButton)


        recordBtn.setOnClickListener{
            val foodName = findViewById<EditText>(R.id.foodName).text.toString()
            val calories =  findViewById<EditText>(R.id.calorieNum).text.toString()


            lifecycleScope.launch(IO){
                //(application as MyApplication).db.calorieDao().deleteAll()
                (application as MyApplication).db.calorieDao().insert(Food(foodName, calories))
                }

                finish()


            }



        }


    }



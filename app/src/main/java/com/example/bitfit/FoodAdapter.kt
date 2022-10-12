package com.example.bitfit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class FoodAdapter (private val mItems: List<Food>) : RecyclerView.Adapter<FoodAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val foodTextView: TextView
        val calorieTextView: TextView

        init{
            foodTextView = itemView.findViewById(R.id.foodName)
            calorieTextView = itemView.findViewById(R.id.calorieNum)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val context = parent .context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.item_food, parent, false)


        //val view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(contactView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val foodCalorie = mItems.get(position)

        holder.foodTextView.text = foodCalorie.foodName
        holder.calorieTextView.text = foodCalorie.calories
    }

    override fun getItemCount(): Int {

        return mItems.size
    }
}
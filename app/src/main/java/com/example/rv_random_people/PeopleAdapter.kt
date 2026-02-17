package com.example.rv_random_people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PeopleAdapter(private val people_list: List<Person>) : RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val peopleImage: ImageView = view.findViewById(R.id.image)
        val peopleName: TextView = view.findViewById(R.id.name)
        val peopleEmail: TextView = view.findViewById(R.id.email)
        val peopleCountry: TextView = view.findViewById(R.id.country)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.people_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = people_list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = people_list[position]

        holder.peopleName.text = person.name
        holder.peopleEmail.text = person.email
        holder.peopleCountry.text = person.country
        Glide.with(holder.itemView)
            .load(person.imageUrl)
            .centerCrop()
            .into(holder.peopleImage)
    }
}

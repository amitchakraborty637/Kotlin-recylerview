package com.example.retrofitdemo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(val userlist:ArrayList<model>):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>()
{
   /* private  var title= arrayOf("Chapter One","Chapter two","Chapter three","Chapter four","Chapter five","Chapter six","Chapter seven","Chapter eight")
    private  var details= arrayOf("Chapter One details","Chapter two details","Chapter three details","Chapter four details","Chapter four details","Chapter four details","Chapter four details","Chapter four details")
    private  var images= intArrayOf(R.drawable.ic_baseline_accessibility_24,R.drawable.ic_baseline_accessibility_24,R.drawable.ic_baseline_accessibility_24,R.drawable.ic_baseline_accessibility_24,R.drawable.ic_baseline_accessibility_24,R.drawable.ic_baseline_accessibility_24,R.drawable.ic_baseline_accessibility_24,R.drawable.ic_baseline_accessibility_24)
*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder
    {
            val v=LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
            return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        holder.view(userlist[position])
    }

    override fun getItemCount(): Int {
        return userlist.size
    }
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        fun view(user:model)
        {
            val name=itemView.findViewById(R.id.item_title) as TextView
            val marks=itemView.findViewById(R.id.item_detail) as TextView
            val img=itemView.findViewById(R.id.item_image) as ImageView
            name.text=user.name
            marks.text=user.address
           // Picasso.get().load("http://192.168.0.195/view/${user.img}").into(img)

        }

    }


}
package com.example.ejemploadapterconlista

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random
import kotlin.random.nextInt

class StringAdapter(var listaString : MutableList<String>) : RecyclerView.Adapter<StringAdapter.StringViewHolder>()  {
    class StringViewHolder(var root: View, var textView: TextView, var check: CheckBox) : RecyclerView.ViewHolder(root)
    var listaBool = mutableListOf<Boolean>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val twTextView = view.findViewById<TextView>(R.id.textView)
        val check1 = view.findViewById<CheckBox>(R.id.checkBox1)
        return StringViewHolder(view, twTextView, check1)
    }

    override fun getItemCount(): Int {
        return listaString.size+1
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.teal_700))
        when (position){
        0 ->{
            holder.textView.text = "Borrar"
            holder.root.setOnClickListener {
                val toast = Toast.makeText(it.context, "Borrando...", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
                var random = Random
                var dropitem = random.nextInt(1..listaString.size-2)
                listaString.removeAt(dropitem)
                listaBool.removeAt(dropitem)
            }
            return
        }
        itemCount -1 ->{
            holder.textView.text = "Insertar"
            holder.root.setOnClickListener {
                val toast = Toast.makeText(it.context, "Añadiendo PC-${position}", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
                listaString.add("PC-${position+1}")
                notifyDataSetChanged()
            }
            return
        }
        itemCount -2 ->{
            holder.textView.text = "Contar Encendidos"
            holder.root.setOnClickListener {
                var count=0
                listaBool.forEach {
                    if(it==true){
                        count++
                    }
                }
                val toast = Toast.makeText(it.context, "Hay $count seleccionados", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
            }
            return
        }
        else -> {
        }
    }
    var random = Random
    var checked = random.nextInt(1..2)
    if (checked==1) {
        holder.check.isChecked = true
        listaBool.add(true)
        holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.verde))
    }else {
        holder.check.isChecked = false
        listaBool.add(false)
        holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.rojo))
    }
    holder.check.setOnCheckedChangeListener { buttonView, isChecked ->
        if (isChecked){
            holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.verde))
            listaBool.set(position,true)
        }else{
            holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.rojo))
            listaBool.set(position,false)
        }
    }
    holder.textView.setText(listaString[position])
    }

}


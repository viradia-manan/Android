package com.example.taskman

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.taskman.Priority.LOW
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter(private val taskList: MutableList<Task>) : BaseAdapter() {

    override fun getCount(): Int {
        return taskList.size
    }

    override fun getItem(position: Int): Task {
        return taskList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ResourceType", "SuspiciousIndentation")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(parent?.context)
            .inflate(R.layout.design, parent, false)

        val task = getItem(position)

        val taskNameTextView = view.findViewById<TextView>(R.id.taskNameTextView)
        val taskDescriptionTextView = view.findViewById<TextView>(R.id.taskDescriptionTextView)
        val taskPriorityView = view.findViewById<View>(R.id.ll)

        taskNameTextView.text = task.name
        taskDescriptionTextView.text = task.description

           when(task.priority)
           {
               Priority.LOW->
               {
                   taskPriorityView.setBackgroundColor(Color.GREEN)
               }
               Priority.AVERAGE->
               {
                   taskPriorityView.setBackgroundColor(Color.BLUE)
               }
               Priority.HIGH->
               {
                   taskPriorityView.setBackgroundColor(Color.RED)
               }
           }
        return view
    }
}
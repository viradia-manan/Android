package com.example.taskman

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.taskman.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        databaseHelper = DatabaseHelper(this)

        val taskList = databaseHelper.getAllTasks()

        taskAdapter = TaskAdapter(taskList)
        binding.list.adapter = taskAdapter

        binding.list.setOnItemClickListener { adapterView: AdapterView<*>, view2: View, i: Int, l: Long ->
            val task = taskAdapter.getItem(i)
            val intent = Intent(this, UpdateTaskActivity::class.java)
            intent.putExtra("id",task.id)
            intent.putExtra("name",task.name)
            intent.putExtra("description",task.description)
            intent.putExtra("date",task.date)
            intent.putExtra("time",task.time)
            intent.putExtra("priority",task.priority)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.add,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.add->
            {
                startActivity(Intent(applicationContext,Add::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
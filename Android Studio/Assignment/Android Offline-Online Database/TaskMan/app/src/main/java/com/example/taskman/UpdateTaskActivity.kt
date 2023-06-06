package com.example.taskman

import android.R
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.taskman.databinding.ActivityUpdateBinding
import java.text.SimpleDateFormat
import java.util.*

class UpdateTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        databaseHelper = DatabaseHelper(this)

        var i = intent
        var id = i.getIntExtra("id", 101)
        var name = i.getStringExtra("name")
        var description = i.getStringExtra("description")
        var dateset = i.getStringExtra("date")
        var timeset = i.getStringExtra("time")
        var priority = i.getIntExtra("priority", 101)

        binding.taskNameEditText.setText(name)
        binding.taskDescriptionEditText.setText(description)
        binding.date.setText(dateset)
        binding.time.setText(timeset)

        //date
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        binding.date.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView
                binding.date.setText("" + dayOfMonth + " " + month + ", " + year)
            }, year, month, day)
            dpd.show()
        }

        binding.time.setOnClickListener{
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                binding.time.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false)
                .show()
        }


        binding.updateButton.setOnClickListener {
            val name = binding.taskNameEditText.text.toString()
            val description = binding.taskDescriptionEditText.text.toString()
            var cd = binding.date.text.toString()
            var ct = binding.time.text.toString()

            val task = Task()
            task.id = id
            task.name = name
            task.description = description
            task.date = cd
            task.time = ct

            databaseHelper.updateTask(task)

            Toast.makeText(this, "Task Update successfully", Toast.LENGTH_SHORT).show()

            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

        binding.deleteButton.setOnClickListener {
            var m = Task()
            databaseHelper.deleteTask(id = id)

            Toast.makeText(this, "Task deleted successfully", Toast.LENGTH_SHORT).show()

            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }

    class MyDatePicker : DialogFragment(), DatePickerDialog.OnDateSetListener {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            var c = Calendar.getInstance()
            var date = c.get(Calendar.DAY_OF_MONTH)
            var month = c.get(Calendar.MONTH)
            var year = c.get(Calendar.YEAR)
            return DatePickerDialog(requireActivity(), this, year, month, date)
        }

        override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
            // var d = "" + p3 + p2 + p1
        }
    }

    class MyTimePicker : DialogFragment(), TimePickerDialog.OnTimeSetListener {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            var c = Calendar.getInstance()
            var hour = c.get(Calendar.HOUR_OF_DAY)
            var minute = c.get(Calendar.MINUTE)


            return TimePickerDialog(requireActivity(), this, hour, minute, false)
        }


        override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
            // var t = ""+hourOfDay+minute
        }
    }
}

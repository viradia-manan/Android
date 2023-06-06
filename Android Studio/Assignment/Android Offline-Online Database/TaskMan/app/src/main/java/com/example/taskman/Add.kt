package com.example.taskman

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TimePicker
import android.widget.Toast
import com.example.taskman.databinding.ActivityAddBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import kotlin.math.min

class Add : AppCompatActivity()
{
    private lateinit var binding: ActivityAddBinding
    lateinit var DbHelper:DatabaseHelper

    var data = arrayOf("Low","Average","High")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        DbHelper = DatabaseHelper(applicationContext)

        var adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,data)
        binding.taskPrioritySpinner.adapter=adapter

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

        binding.saveButton.setOnClickListener {
            var name = binding.taskNameEditText.text.toString()
            var des = binding.taskDescriptionEditText.text.toString()
            var cd = binding.date.text.toString()
            var ct = binding.time.text.toString()
            var p = when(binding.taskPrioritySpinner.selectedItemPosition)
            {
                0->
                {
                    Priority.LOW
                }
                1->
                {
                    Priority.AVERAGE
                }
                2->
                {
                    Priority.HIGH
                }
                else ->
                {
                    print("Null")
                }
            }

            val task = Task()
            task.name=name
            task.description=des
            task.date=cd
            task.time=ct
            task.priority= p as Int

            DbHelper.addTask(task)

                Toast.makeText(this, "Task added successfully", Toast.LENGTH_SHORT).show()

                startActivity(Intent(applicationContext,MainActivity::class.java))
        }
    }

    /*class MyDatePicker(add: Add, MyDatePicker: Any?) :DialogFragment(), DatePickerDialog.OnDateSetListener {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            var c = Calendar.getInstance()
            var date = c.get(Calendar.DAY_OF_MONTH)
            var month = c.get(Calendar.MONTH)
            var year = c.get(Calendar.YEAR)
            return DatePickerDialog(requireActivity(), this, year, month, date)
        }

        override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
          //  var d = "" + p3 + p2 + p1
        }
    }

        class MyTimePicker :DialogFragment(), TimePickerDialog.OnTimeSetListener {
            override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
                var c = Calendar.getInstance()
                var hour = c.get(Calendar.HOUR_OF_DAY)
                var minute = c.get(Calendar.MINUTE)


                return TimePickerDialog(requireActivity(), this, hour, minute, false)
            }

            override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {

            }

        }*/


}
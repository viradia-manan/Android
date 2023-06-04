package com.example.taskman

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Display.Mode
import android.view.View
import android.widget.AdapterView
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.taskman.databinding.ActivityAddBinding
import com.example.taskman.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class Add : AppCompatActivity()
{
    private lateinit var binding: ActivityAddBinding
    lateinit var DbHelper:DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        DbHelper = DbHelper(applicationContext)

        var date: Unit = binding.date.setOnClickListener {
            var d = MyDatePicker()
            d.show(supportFragmentManager,"DATE")
        }

       var time: Unit =  binding.time.setOnClickListener{
            var t = MyTimePicker()
            t.show(supportFragmentManager,"TIME")
        }

        binding.insert.setOnClickListener {
            var name = binding.name.text.toString()
            var des = binding.des.text.toString()
            var datechoose = date.toString()
            var timechoose = time.toString()

            var m = Model()
            m.name=name
            m.des=des
            m.d= datechoose.toString()
            m.t= timechoose.toString()

            DbHelper.insert(m)

            Snackbar.make(it,"Insert Successfully",Snackbar.LENGTH_LONG).show()

            startActivity(Intent(applicationContext,MainActivity::class.java))
        }
    }

    class MyDatePicker :DialogFragment(), DatePickerDialog.OnDateSetListener {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            var c = Calendar.getInstance()
            var date = c.get(Calendar.DAY_OF_MONTH)
            var month = c.get(Calendar.MONTH)
            var year = c.get(Calendar.YEAR)
            return DatePickerDialog(requireActivity(), this, year, month, date)
        }

        override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
            var d = "" + p3 + p2 + p1
        }
    }

        class MyTimePicker :DialogFragment(), TimePickerDialog.OnTimeSetListener {
            override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
            {
                var c = Calendar.getInstance()
                var hour = c.get(Calendar.HOUR_OF_DAY)
                var minute = c.get(Calendar.MINUTE)


                return TimePickerDialog(requireActivity(),this,hour,minute,false)
            }


            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int)
            {
               var t = ""+hourOfDay+minute
            }
    }
}
package com.example.taskman

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.taskman.databinding.ActivityAddBinding
import com.example.taskman.databinding.ActivityUpdateBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*

class UpdateActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdateBinding
    lateinit var DbHelper:DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var id = i.getIntExtra("id",101)
        var name = i.getStringExtra("name")
        var des = i.getStringExtra("des")
        var d = i.getStringExtra("date")
        var t = i.getStringExtra("time")

        binding.name.setText(name)
        binding.des.setText(des)
        binding.time.setText(t)
        binding.date.setText(d)

        DbHelper = DbHelper(applicationContext)

        var date: Unit = binding.date.setOnClickListener {
            var d = Add.MyDatePicker()
            d.show(supportFragmentManager,"DATE")
        }

        var time: Unit =  binding.time.setOnClickListener{
            var t = Add.MyTimePicker()
            t.show(supportFragmentManager,"TIME")
        }

        binding.update.setOnClickListener {
            var name = binding.name.text.toString()
            var des = binding.des.text.toString()
            var datechoose = date.toString()
            var timechoose = time.toString()

            var m = Model()
            m.name=name
            m.des=des
            m.d= datechoose.toString()
            m.t= timechoose.toString()

            DbHelper.updatedata(m)

            Snackbar.make(it,"Update Successfully", Snackbar.LENGTH_LONG).show()

            startActivity(Intent(applicationContext,MainActivity::class.java))
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
                var d = "" + p3 + p2 + p1
            }
        }

        class MyTimePicker : DialogFragment(), TimePickerDialog.OnTimeSetListener {
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
}
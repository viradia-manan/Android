package com.example.dateandtimepicker

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var btn1:Button
    lateinit var btn2: Button
    lateinit var spin: Spinner
    lateinit var f1: FloatingActionButton

    var data = arrayOf("Ahmedabad","Rajkot","Surat")

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        spin = findViewById(R.id.spin)
        f1 = findViewById(R.id.f1)

        btn1.setOnClickListener {
            var d = MyDatePicker()
            d.show(supportFragmentManager,"Date")
        }

        btn2.setOnClickListener {
            var d = MyTimePicker()
            d.show(supportFragmentManager,"Date")
        }

        spin.setOnItemSelectedListener(this)

        var adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,data)
        spin.adapter = adapter

        f1.setOnClickListener {
            Snackbar.make(it,"Floating Called",Snackbar.LENGTH_LONG).show()
        }
    }

    class MyDatePicker:DialogFragment(),DatePickerDialog.OnDateSetListener
    {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
        {
            var c = Calendar.getInstance()
            var date = c.get(Calendar.DAY_OF_MONTH)
            var month = c.get(Calendar.MONTH)
            var year = c.get(Calendar.YEAR)
            return DatePickerDialog(requireActivity(),this,year,month,date)
        }

        override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int)
        {
            Toast.makeText(requireActivity(), "" + p1 + "-" + p2 + "-" + p3, Toast.LENGTH_LONG).show()
        }
    }

    class MyTimePicker :DialogFragment(), TimePickerDialog.OnTimeSetListener {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
        {
            var c = Calendar.getInstance()
            var hour = c.get(Calendar.HOUR_OF_DAY)
            var minute = c.get(Calendar.MINUTE)


            return TimePickerDialog(requireActivity(),this,hour,minute,true)
        }


        override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int)
        {
            Toast.makeText(requireActivity(),""+hourOfDay+":"+minute,Toast.LENGTH_LONG).show()
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long)
    {
        Toast.makeText(applicationContext,""+data[p2],Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?)
    {

    }

}
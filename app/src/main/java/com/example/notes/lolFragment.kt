package com.example.notes

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notes.databinding.FragmentLolBinding


class lolFragment : Fragment() {
    lateinit var binding: FragmentLolBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
       binding =FragmentLolBinding.inflate(layoutInflater,container,false)

        binding.dateBtn.setOnClickListener {

            pickAData()
        }
        binding.timeBtn.setOnClickListener {

            pickATime()
        }

        return binding.root
    }

    private fun pickATime() {
       val calendar =Calendar.getInstance()

        val minute =calendar.get(Calendar.MINUTE)
        val hower = calendar.get(Calendar.HOUR)

       val timePickerDialog= TimePickerDialog (requireActivity(),
           TimePickerDialog.OnTimeSetListener{_,hower,minute->

            val showTime="$hower,${minute+1}"

            binding.timeBtn.text=showTime


        },hower,minute,false

        )
        timePickerDialog.show()

    }

    private fun pickAData() {
        val calender= Calendar.getInstance()


        val day= calender.get(Calendar.DAY_OF_MONTH)
        val month= calender.get(Calendar.MONTH)
        val year =calender.get(Calendar.YEAR)

       val showDataPicker=   DatePickerDialog(
                  requireActivity(),
                 DatePickerDialog.OnDateSetListener{_,year,month,dayOfManth->

                val showData="$dayOfManth/${month+1}/$year"
                binding.dateBtn.text=showData


            },year,month,day,
        )
        showDataPicker.show()

    }


}
package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val str1 : EditText = findViewById(R.id.editTextCarPrice)
        val str2 : EditText = findViewById(R.id.editTextDownPayment)
        val str3 : EditText = findViewById(R.id.editTextLoanPeriod)
        val str4  : EditText= findViewById(R.id.editTextInterestRate)

        val bCal :Button = findViewById(R.id.buttonCalculate)
        val tv1 : TextView = findViewById(R.id.resultL)
        val tv2 : TextView = findViewById(R.id.resultI)
        val tv3 : TextView = findViewById(R.id.resultMR)

        bCal.setOnClickListener{
            val carP: Double = str1.text.toString().toDouble()
            val downP: Double = str2.text.toString().toDouble()
            val loanP: Double = str3.text.toString().toDouble()
            val interestR: Double = str4.text.toString().toDouble()

            val carLoan: Double = carP - downP
            val interest: Double = carP * (interestR/100) * loanP
            val mRepay: Double = (carLoan + interest) / loanP / 12

            tv1.text = carLoan.toString()
            tv2.text = interest.toString()
            tv3.text = mRepay.toString()

        }
        buttonReset.setOnClickListener{
            tv1.text = ""
            tv2.text = ""
            tv3.text = ""

            str1.setText("")
            str2.setText("")
            str3.setText("")
            str4.setText("")

        }

    }
}

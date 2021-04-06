package com.example.calapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var isNewOp=true
    var dot=false
    fun buNumberEvent(view: View)
    {
        if(isNewOp)
        {
            numberVisibility.setText("")
        }
        isNewOp=false
        val buSelect= view as Button
        var buClickValue:String=numberVisibility.text.toString()
        when(buSelect.id)
        {
            b0.id->
            {
                buClickValue+="0"
            }
            b1.id->
            {
                buClickValue+="1"
            }
            b2.id->
            {
                buClickValue+="2"
            }
            b3.id->
            {
                buClickValue+="3"
            }
            b4.id->
            {
                buClickValue+="4"
            }
            b5.id->
            {
                buClickValue+="5"
            }
            b6.id->
            {
                buClickValue+="6"
            }
            b7.id->
            {
                buClickValue+="7"
            }
            b8.id->
            {
                buClickValue+="8"
            }
            b9.id->
            {
                buClickValue+="9"
            }
            bDot.id->
            {
                if(dot==false)
                {
                    buClickValue += "."
                }
                dot=true
            }
            bPlusMinus.id->
            {
                buClickValue="-" + buClickValue
            }
        }
        numberVisibility.setText(buClickValue)
    }
    var op="X"
    var oldNumber=""

    fun buOpEvent(view: View)
    {
        val buSelect= view as Button
        when(buSelect.id)
        {
            bMul.id->
            {
                op="X"
            }
            bDiv.id->
            {
                op="÷"
            }
            bSub.id->
            {
                op="-"
            }
            bSum.id->
            {
                op="+"
            }
        }
        oldNumber=numberVisibility.text.toString()
        isNewOp=true
        dot=false
    }

    fun buEqualEvent(view: View)
    {
        val newNumber=numberVisibility.text.toString()
        var finalNumber:Double?=null
        when(op)
        {
            "X"->
            {
                finalNumber=oldNumber.toDouble() * newNumber.toDouble()
            }
            "÷"->
            {
                finalNumber=oldNumber.toDouble() / newNumber.toDouble()
            }
            "-"->
            {
                finalNumber=oldNumber.toDouble() - newNumber.toDouble()
            }
            "+"->
            {
                finalNumber=oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        numberVisibility.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buPercentEvent(view: View)
    {
        val number=(numberVisibility.text.toString().toDouble())/100
        numberVisibility.setText(number.toString())
        isNewOp=true
    }

    fun buCleanEvent(view: View)
    {
        numberVisibility.setText("")
        isNewOp=true
        dot=false
    }
}
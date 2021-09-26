package com.example.ccandroidtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        var buttonSimple = findViewById<Button>(R.id.dialog_Btn1)
        var buttonAlert = findViewById<Button>(R.id.dialog_Btn10)
        var buttonSingleChoice = findViewById<Button>(R.id.dialog_Btn2)
        var buttonMultiple = findViewById<Button>(R.id.dialog_Btn3)
        var buttonProgress = findViewById<Button>(R.id.dialog_Btn4)
        var buttonDatePicker = findViewById<Button>(R.id.dialog_Btn5)
        var buttonBottomDialog = findViewById<Button>(R.id.dialog_Btn7)
        var buttonCustomDialog = findViewById<Button>(R.id.dialog_Btn8)
        var buttonTimePicker = findViewById<Button>(R.id.dialog_Btn6)
        var buttonCircular = findViewById<Button>(R.id.dialog_Btn9)

        buttonAlert.setOnClickListener() {
            val builder = AlertDialog.Builder(this)
            //set title for alert dialog
            builder.setTitle(R.string.dialogTitle)
            //set message for alert dialog
            builder.setMessage(R.string.dialogMessage)
            builder.setIcon(android.R.drawable.ic_dialog_alert)

            //performing positive action
            builder.setPositiveButton("Yes") { dialogInterface, which ->
                Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_LONG).show()
            }
            //performing cancel action
            builder.setNeutralButton("Cancel") { dialogInterface, which ->
                Toast.makeText(
                    applicationContext,
                    "clicked cancel\n operation cancel",
                    Toast.LENGTH_LONG
                ).show()
            }
            //performing negative action
            builder.setNegativeButton("No") { dialogInterface, which ->
                Toast.makeText(applicationContext, "clicked No", Toast.LENGTH_LONG).show()
            }
            // Create the AlertDialog
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

        buttonSimple.setOnClickListener(){
            Toast.makeText(applicationContext, "Simple Dialog", Toast.LENGTH_LONG).show()
        }

        buttonSingleChoice.setOnClickListener(){
            Toast.makeText(applicationContext, "Single Choice Dialog", Toast.LENGTH_LONG).show()
        }

        buttonMultiple.setOnClickListener(){
            Toast.makeText(applicationContext, "Multiple Dialog", Toast.LENGTH_LONG).show()
        }

        buttonProgress.setOnClickListener(){
            Toast.makeText(applicationContext, "Progress Dialog", Toast.LENGTH_LONG).show()
        }

        buttonDatePicker.setOnClickListener(){
            Toast.makeText(applicationContext, "Date Picker Dialog", Toast.LENGTH_LONG).show()
        }

        buttonTimePicker.setOnClickListener(){
            Toast.makeText(applicationContext, "Time Picker Dialog", Toast.LENGTH_LONG).show()
        }

        buttonBottomDialog.setOnClickListener(){
            Toast.makeText(applicationContext, "Bottom Dialog", Toast.LENGTH_LONG).show()
        }

        buttonCustomDialog.setOnClickListener(){
            Toast.makeText(applicationContext, "Custom Dialog", Toast.LENGTH_LONG).show()
        }

        buttonCircular.setOnClickListener(){
            Toast.makeText(applicationContext, "Circular Dialog", Toast.LENGTH_LONG).show()
        }
    }
}
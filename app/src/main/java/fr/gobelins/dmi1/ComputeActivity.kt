package fr.gobelins.dmi1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class ComputeActivity : AppCompatActivity() {
    lateinit var edtFirstOperand: TextInputEditText
    lateinit var edtSecondOperand: TextInputEditText
    lateinit var btnCompute: Button
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)
        init()
        val operation = intent.getStringExtra("operation") ?: "ADD"

        btnCompute.setOnClickListener {
            // if the text cannot be converted to a Double, toDoubleOrNull() will return null
            // the ?: (elvis) operator will provide a default value of 0.0.
            var operand1 = edtFirstOperand.text.toString().toDoubleOrNull() ?: return@setOnClickListener run {
                edtFirstOperand.error = "type a valid number!"
            }
            var operand2 = edtSecondOperand.text.toString().toDoubleOrNull() ?: return@setOnClickListener run {
                edtSecondOperand.error = "type a valid number!"
            }
            var sum =  operand1 +  operand2

            //tvResult.text = sum.toString()
            Toast.makeText(this,"compute: $sum",Toast.LENGTH_SHORT).show()
            tvResult.text=sum.toString()
        }

    }

    private fun init(){
        edtFirstOperand = findViewById(R.id.first_operand)
        edtSecondOperand = findViewById(R.id.second_operand)
        btnCompute = findViewById(R.id.btn_compute)
        tvResult = findViewById(R.id.tv_result)
    }
}
package com.example.tugaspambutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.tugaspambutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            showDialog(isAdd = true)
            Toast.makeText(this, "You Clicked on Add Button", Toast.LENGTH_SHORT).show()
        }

        binding.btnMin.setOnClickListener {
            showDialog(isAdd = false)
            Toast.makeText(this, "You Clicked on Sub Button", Toast.LENGTH_SHORT).show()
        }
    }

    fun onClickPower(view: View) {
        val tvNumber = binding.tvNumber.text.toString().toLong()
        val resultString = (tvNumber * tvNumber).toString()
        binding.tvNumber.text = resultString
        Toast.makeText(this, "You Clicked on Power Button", Toast.LENGTH_SHORT).show()
    }


    private fun showDialog(isAdd: Boolean){
        val builder = AlertDialog.Builder(this)
        val dialogLayout = layoutInflater.inflate(R.layout.edit_text, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.etEdit)

        with(builder) {
            setTitle("Input Number")
            if (isAdd) {
                setPositiveButton("OK") {_, _ ->
                    binding.tvNumber.text =
                        (binding.tvNumber.text.toString().toLong() + editText.text.toString()
                            .toLong()).toString()
                }
                setNegativeButton("Cancel") { _, _ ->
                    Toast.makeText(this@MainActivity, "You Cancel Add Number", Toast.LENGTH_SHORT)
                        .show()
                }
            }else{
                setPositiveButton("OK") { _, _ ->
                    binding.tvNumber.text =
                        (binding.tvNumber.text.toString().toLong() - editText.text.toString()
                            .toLong()).toString()
                }
                setNegativeButton("Cancel") { _, _ ->
                    Toast.makeText(this@MainActivity, "You Cancel Subtract Number", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            setView(dialogLayout).show()
        }
    }
}
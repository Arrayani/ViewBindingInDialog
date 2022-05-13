package com.ericg.searchview.viewbindingindialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import com.ericg.searchview.viewbindingindialog.databinding.ActivityMainBinding
import com.ericg.searchview.viewbindingindialog.databinding.DialogMainBinding


class MainActivity : AppCompatActivity() {
    // Initialize variables
    private var binding: ActivityMainBinding? = null
    private var dialogMainBinding: DialogMainBinding? = null
    private var dialog: Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate activity main
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btShow.setOnClickListener { // Inflate dialog main
            dialogMainBinding = DialogMainBinding.inflate(layoutInflater)

            // Initialize dialog
            dialog = Dialog(this@MainActivity)

            // set background transparent
            dialog!!.window!!.setBackgroundDrawable(
                ColorDrawable(
                    Color.TRANSPARENT
                )
            )
            // set view
            dialog!!.setContentView(dialogMainBinding!!.root)
            // set listener on plus button
            dialogMainBinding!!.btPlus.setOnClickListener { // get count from text view
                val sCount: String = dialogMainBinding!!.tvCount.text.toString()
                // convert into int
                var count = sCount.toInt()
                // Increase count
                ++count
                // set count on textview
                dialogMainBinding!!.tvCount.text = count.toString()
            }

            // set listener on minus button
            dialogMainBinding!!.btMinus.setOnClickListener {
                // get count from text view
                val sCount: String = dialogMainBinding!!.tvCount.text.toString()
                // convert into int
                var count = sCount.toInt()
                // check condition
                if (count != 0) {
                    // When count is not equal to 0
                    // Decrease count
                    --count
                    // set count on text view
                    dialogMainBinding!!.tvCount.text = count.toString()
                }
            }
            // display dialog
            dialog!!.show()
        }
    }
}
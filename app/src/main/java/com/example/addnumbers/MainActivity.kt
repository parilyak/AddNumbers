package com.example.addnumbers

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.URLSpan
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*
//import sun.jvm.hotspot.utilities.IntArray


//import sun.jvm.hotspot.utilities.IntArray


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_black_mark, 0, 0, 0)
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_plus_mark, 0)
        button.setOnClickListener {
            if (editNum1.length() > 0 && editNum2.length() > 0) {

                textResult.text =
                    "Result: " + (editNum1.text.toString().toInt() + editNum2.text.toString().toInt()).toString()
                Toast.makeText(this, textResult.text, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, R.string.fill_nums, Toast.LENGTH_LONG).show()
            }
        }

//        fun showBasicDialog(view: View?) {
//            val builder = AlertDialog.Builder(this)
//            builder.setTitle(R.string.alert_title)
//            builder.setMessage(R.string.alert_message)
//            builder.setCancelable(false)
//            builder.setPositiveButton(R.string.reset, DialogInterface.OnClickListener {
//                    dialog, id ->
//                editNum1.setText(null)
//                editNum2.setText(null)
//                textResult.text = "Result: "
//                Toast.makeText(this, R.string.clear_input, Toast.LENGTH_LONG).show()
//            })
//            builder.setNegativeButton(R.string.cancel, DialogInterface.OnClickListener {
//                    dialog, id -> dialog.cancel()
//            })
//            builder.show()
//        }

        @SuppressLint("ResourceAsColor")
        @RequiresApi(Build.VERSION_CODES.M)
        fun showBasicDialog(view: View?) {
            val alertDialog = AlertDialog.Builder(this).create()
            alertDialog.setTitle(getString((R.string.alert_title)))
            alertDialog.setMessage(getString(R.string.alert_message))
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.reset)
            ) { dialog, which ->
                editNum1.setText(null)
                editNum2.setText(null)
                textResult.text = "Result: "
                Toast.makeText(this, R.string.clear_input, Toast.LENGTH_LONG).show()}

            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.cancel)
            ) { dialog, which -> dialog.cancel() }

            alertDialog.show()
            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(this, R.color.colorSalad))
            alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(this, R.color.colorSalad))
        }
        
        resetButton.setOnClickListener {
            showBasicDialog(null)
        }

        val spannableString = SpannableString("I want THIS and THIS to be clickable")
        val url = "https://developer.android.com"

        var fcsRed = ForegroundColorSpan(ResourcesCompat.getColor(resources, R.color.colorPink, null))
        var fcsGreen = ForegroundColorSpan(Color.GREEN)

        spannableString.setSpan(URLSpan(url), 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


        val clickableSpan2 = object : ClickableSpan() {
            override fun onClick(widget: View) {
                Toast.makeText(this@MainActivity, "Two", Toast.LENGTH_SHORT).show()
            }
        }

        spannableString.setSpan(clickableSpan2, 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        spannableString.setSpan(fcsRed, 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(fcsGreen, 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        clickable_textView.text = spannableString
        clickable_textView.movementMethod = LinkMovementMethod.getInstance()
    }
}

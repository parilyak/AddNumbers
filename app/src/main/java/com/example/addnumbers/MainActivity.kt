package com.example.addnumbers

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.URLSpan
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
                Toast.makeText(this, "Fill in numbers", Toast.LENGTH_LONG).show()
            }
        }

//        (textView as TextView).setCompoundDrawablesPadding(3)

        resetButton.setOnClickListener {
            editNum1.setText(null)
            editNum2.setText(null)
            textResult.text = "Result: "
            Toast.makeText(this, "Cleared input", Toast.LENGTH_LONG).show()
        }


//        var text = "I want THIS and THIS to be clickable"
//        var spannableText = SpannableString(text)
//        var fcsRed = ForegroundColorSpan(ResourcesCompat.getColor(resources, R.color.colorPink, null))
//        var fcsGreen = ForegroundColorSpan(Color.GREEN)
//
////        val clickableSpan = object : ClickableSpan() {
////            override fun onClick(widget: View) {
//////                Toast.makeText(this@MainActivity, "One", Toast.LENGTH_SHORT).show()
////            }
////        }
//

//
////        spannableText.setSpan(clickableSpan, 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

//        spannableText.setSpan(fcsRed, 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//        spannableText.setSpan(fcsGreen, 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
////        spannableText.setSpan(URLSpan("https://meshtech.no/privacy-policy/"), 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//
//        val string = SpannableString(text)
//        string.setSpan(URLSpan("http://www.developer.android.com"), 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//
//
//        clickable_textView.setText(spannableText)
//        clickable_textView.movementMethod = LinkMovementMethod.getInstance()


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

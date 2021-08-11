package com.example.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val myName:Myname= Myname("Jhoan Olivo")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        /*findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickName(it)
        }*/
        binding.myName=myName
        binding.doneButton.setOnClickListener{
            addNickName(it)
        }
    }

    private fun addNickName(view:View){
        /*val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView= findViewById<TextView>(R.id.nickname_view)
        */
        /*nicknameTextView.text=editText.text
        editText.visibility=View.GONE
        view.visibility=View.GONE
        nicknameTextView.visibility=View.VISIBLE*/
        binding.apply {
            //binding.nicknameView.text=binding.nicknameEdit.text
            myName?.nickName=nicknameEdit.text.toString()

            invalidateAll()

            nicknameEdit.visibility=View.GONE
            view.visibility=View.GONE
            nicknameView.visibility=View.VISIBLE
        }



        //hiding keyboard
        val inm =getSystemService(Context.INPUT_METHOD_SERVICE) as  InputMethodManager
        inm.hideSoftInputFromWindow(view.windowToken,0)



    }
}
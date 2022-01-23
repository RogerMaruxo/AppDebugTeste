package com.cat.degubtestapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IndexOutOfBoundsException
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    private var clicks = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setLogListeners()

        val currentThread = Thread.currentThread()
        currentThread.setUncaughtExceptionHandler { _, throwable ->
            val x = throwable.message
            val cause = throwable.cause
            //todo implemente aqui seu exception handler
        }

    }

    private fun setLogListeners() {
        //todo altere os logs e adicione mais possibilidade de exceptions
        debugBTN?.setOnClickListener { Log.d("click", "Opa! cliquei no debug") }
        errorBTN?.setOnClickListener {
            //Log.e ("click","Opa! cliquei no error $clicks vezes")
            //throw Exception()
            var message: String = ""
            try {
                val list = listOf<Int>(2,1,4)
                val a = list [5]
                message = "Sobrevivi ao try"
            } catch (e: IndexOutOfBoundsException){
                message = "entrei no catch certo :)"
            } catch (i: NullPointerException){
                message = "entre no catch errado :("
            } finally {
                inputEDT?.setText(message)
                val t = 35
            }
        }
        infoBTN?.setOnClickListener { Log.i("click", "Opa! cliquei no info") }
        warningBTN?.setOnClickListener { Log.w("click", "Opa! cliquei no warning") }
        verboseBTN?.setOnClickListener { Log.v("click", "Opa! cliquei no verbose") }
    }
}
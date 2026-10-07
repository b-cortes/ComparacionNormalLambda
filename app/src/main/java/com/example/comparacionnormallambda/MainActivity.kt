package com.example.comparacionnormallambda

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.comparacionnormallambda.logic.Controller
import com.example.comparacionnormallambda.views.DialogClient

class MainActivity : AppCompatActivity() {
    private lateinit var controller: Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialog = DialogClient()
        controller = Controller(this, dialog)
        controller.start()
    }
}

package com.example.comparacionnormallambda

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.comparacionnormallambda.data.Client
import com.example.comparacionnormallambda.logic.Controller
import com.example.comparacionnormallambda.views.DialogClient

class MainActivity : AppCompatActivity() {
    private val controller = Controller()

    private val dialog = DialogClient(
        onAdd = { id, n, s, p -> controller.add(Client(id, n, s, p)) },
        onUpdate = { id, n, s, p -> controller.update(id, n, s, p) },
        onDelete = { id -> controller.delete(id) }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        controller.logList()

        findViewById<ImageButton>(R.id.btnAdd).setOnClickListener { dialog.showAdd(controller.newId()) }
        findViewById<ImageButton>(R.id.btnEdit).setOnClickListener {
            controller.randomId()?.let(dialog::showUpdate)
        }
        findViewById<ImageButton>(R.id.btnDel).setOnClickListener {
            controller.randomId()?.let(dialog::showDelete)
        }
    }

} 
    
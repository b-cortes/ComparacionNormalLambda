package com.example.comparacionnormallambda

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.comparacionnormallambda.data.Client
import com.example.comparacionnormallambda.logic.Controller
import com.example.comparacionnormallambda.logic.interfaces.ClientListener
import com.example.comparacionnormallambda.views.DialogClient

class MainActivity : AppCompatActivity(), ClientListener {
    private val controller = Controller(
        map = TODO()
    )

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

    override fun ClientAdd(
        id: Int,
        name: String,
        surname: String,
        phone: String
    ) {
        TODO("Not yet implemented")
    }

    override fun ClientDel(id: Int) {
        TODO("Not yet implemented")
    }

    override fun ClientUpdate(
        id: Int,
        name: String,
        surname: String,
        phone: String
    ) {
        TODO("Not yet implemented")
    }
} 
    
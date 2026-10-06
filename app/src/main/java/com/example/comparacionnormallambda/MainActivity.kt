package com.example.comparacionnormallambda

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.comparacionnormallambda.data.Client
import com.example.comparacionnormallambda.logic.Controller
import com.example.comparacionnormallambda.logic.interfaces.ClientListener
import com.example.comparacionnormallambda.views.DialogClient

class MainActivity : AppCompatActivity(), ClientListener {
    private val controller = Controller()
    private val dialog = DialogClient(
        onAdd = ::ClientAdd,
        onUpdate = ::ClientUpdate,
        onDelete = ::ClientDel
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
    override fun ClientAdd(id: Int, name: String, surname: String, phone: String) {
        controller.add(Client(id, name, surname, phone))
    }
    override fun ClientDel(id: Int) {
        controller.delete(id)
    }
    override fun ClientUpdate(id: Int, name: String, surname: String, phone: String) {
        controller.update(id, name, surname, phone)
    }
}
    
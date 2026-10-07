package com.example.comparacionnormallambda.logic

import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.example.comparacionnormallambda.MainActivity
import com.example.comparacionnormallambda.R
import com.example.comparacionnormallambda.data.Client
import com.example.comparacionnormallambda.data.Repository
import com.example.comparacionnormallambda.logic.interfaces.ClientListener
import com.example.comparacionnormallambda.views.DialogClient
import com.example.comparacionnormallambda.views.TypeAction

class Controller(
    private val activity: MainActivity,
    private val dialog: DialogClient
) : ClientListener, View.OnClickListener {

    private val TAG = "CRUD"
    private val clients: MutableList<Client> =
        Repository.listClients.map { it.copy() }.toMutableList()
    private var nextId = (clients.maxOfOrNull { it.id } ?: 99) + 1

    fun start() {
        dialog.setListener(this)
        activity.findViewById<ImageButton>(R.id.btnAdd).setOnClickListener(this)
        activity.findViewById<ImageButton>(R.id.btnEdit).setOnClickListener(this)
        activity.findViewById<ImageButton>(R.id.btnDel).setOnClickListener(this)
        updateView()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnAdd -> dialog.show(TypeAction.INSERT, nextId++)
            R.id.btnEdit -> {
                val client = clients.randomOrNull()
                if (client != null) dialog.show(TypeAction.UPDATE, client.id)
            }
            R.id.btnDel -> {
                val client = clients.randomOrNull()
                if (client != null) dialog.show(TypeAction.DELETE, client.id)
            }
        }
    }

    override fun ClientAdd(id: Int, name: String, surname: String, phone: String) {
        clients.add(Client(id, name, surname, phone))
        Log.d(TAG, "El cliente con id = $id, ha sido insertado correctamente")
        updateView()
    }

    override fun ClientUpdate(id: Int, name: String, surname: String, phone: String) {
        val client = clients.find { it.id == id }
        if (client != null) {
            client.name = name; client.surname = surname; client.phone = phone
            Log.d(TAG, "El cliente con id = $id, ha sido actualizado correctamente")
        } else {
            Log.d(TAG, "No existe el cliente con id = $id")
        }
        updateView()
    }

    override fun ClientDel(id: Int) {
        if (clients.removeIf { it.id == id })
            Log.d(TAG, "El cliente con id = $id, ha sido eliminado correctamente")
        else
            Log.d(TAG, "No existe el cliente con id = $id")
        updateView()
    }

    private fun updateView() {
        Log.d(TAG, clients.toString())
        activity.findViewById<TextView>(R.id.tvClients).text =
            clients.joinToString("\n") { "${it.id} - ${it.name} ${it.surname} (${it.phone})" }
    }
}

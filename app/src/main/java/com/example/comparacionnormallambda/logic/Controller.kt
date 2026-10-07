package com.example.comparacionnormallambda.logic

import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import com.example.comparacionnormallambda.MainActivity
import com.example.comparacionnormallambda.R
import com.example.comparacionnormallambda.data.Client
import com.example.comparacionnormallambda.data.Repository
import com.example.comparacionnormallambda.views.DialogClient
import com.example.comparacionnormallambda.views.TypeAction

class Controller(
    private val activity: MainActivity,
    private val dialog: DialogClient
) {
    private val TAG = "CRUD"
    private val clients: MutableList<Client> =
        Repository.listClients.map { it.copy() }.toMutableList()
    private var nextId = (clients.maxOfOrNull { it.id } ?: 99) + 1

    fun start() {
        dialog.setListener(
            onAdd = { id, n, s, p -> add(Client(id, n, s, p)) },
            onUpdate = { id, n, s, p -> update(id, n, s, p) },
            onDelete = { id -> delete(id) }
        )
        activity.findViewById<ImageButton>(R.id.btnAdd).setOnClickListener {
            dialog.show(TypeAction.INSERT, nextId++)
        }
        activity.findViewById<ImageButton>(R.id.btnEdit).setOnClickListener {
            clients.randomOrNull()?.let { dialog.show(TypeAction.UPDATE, it.id) }
        }
        activity.findViewById<ImageButton>(R.id.btnDel).setOnClickListener {
            clients.randomOrNull()?.let { dialog.show(TypeAction.DELETE, it.id) }
        }
        updateView()
    }

    private fun add(client: Client) {
        clients.add(client)
        Log.d(TAG, "El cliente con id = ${client.id}, ha sido insertado correctamente")
        updateView()
    }

    private fun update(id: Int, name: String, surname: String, phone: String) {
        clients.find { it.id == id }?.let {
            it.name = name; it.surname = surname; it.phone = phone
            Log.d(TAG, "El cliente con id = $id, ha sido actualizado correctamente")
        } ?: Log.d(TAG, "No existe el cliente con id = $id")
        updateView()
    }

    private fun delete(id: Int) {
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

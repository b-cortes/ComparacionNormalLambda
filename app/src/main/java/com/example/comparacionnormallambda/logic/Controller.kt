package com.example.comparacionnormallambda.logic


import android.util.Log
import com.example.comparacionnormallambda.data.Client
import com.example.comparacionnormallambda.data.Repository

class Controller {
    private val TAG = "CRUD"
    private val clients: MutableList<Client> =
        Repository.listClients.map { it.copy() }.toMutableList()
    private var nextId = (clients.maxOfOrNull { it.id } ?: 99) + 1
    fun newId(): Int = nextId++
    fun randomId(): Int? = clients.randomOrNull()?.id
    fun add(client: Client) {
        clients.add(client)
        Log.d(TAG, "El cliente con id = ${client.id}, ha sido insertado correctamente")
        logList()
    }
    fun update(id: Int, name: String, surname: String, phone: String) {
        clients.find { it.id == id }?.let {
            it.name = name; it.surname = surname; it.phone = phone
            Log.d(TAG, "El cliente con id = $id, ha sido actualizado correctamente")
        } ?: Log.d(TAG, "No existe el cliente con id = $id")
        logList()
    }
    fun delete(id: Int) {
        if (clients.removeIf { it.id == id })
            Log.d(TAG, "El cliente con id = $id, ha sido eliminado correctamente")
        else
            Log.d(TAG, "No existe el cliente con id = $id")
        logList()
    }
    fun logList() = Log.d(TAG, clients.toString())

}
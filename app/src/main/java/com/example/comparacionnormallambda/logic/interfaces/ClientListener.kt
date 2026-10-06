package com.example.comparacionnormallambda.logic.interfaces

interface ClientListener {
    fun ClientAdd(id: Int, name: String, surname: String, phone: String)
    fun ClientDel(id: Int)
    fun ClientUpdate(id: Int, name: String, surname: String, phone: String)
}

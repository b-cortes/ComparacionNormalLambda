package com.example.comparacionnormallambda.views

import com.example.comparacionnormallambda.logic.interfaces.ClientListener

class DialogClient {
    private lateinit var listener: ClientListener

    fun setListener(listener: ClientListener) {
        this.listener = listener
    }

    fun show(typeAction: TypeAction, id: Int) {
        when (typeAction) {
            TypeAction.INSERT -> listener.ClientAdd(id, "Nuevo", "Pérez", "611000000")
            TypeAction.UPDATE -> listener.ClientUpdate(id, "CAMBIADO", "Cambiado", "699999999")
            TypeAction.DELETE -> listener.ClientDel(id)
        }
    }
}

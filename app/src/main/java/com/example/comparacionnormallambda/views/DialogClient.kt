package com.example.comparacionnormallambda.views

class DialogClient (
    private val onAdd: (Int, String, String, String) -> Unit,
    private val onUpdate: (Int, String, String, String) -> Unit,
    private val onDelete: (Int) -> Unit
    ) {
        fun showAdd(id: Int) = onAdd(id, "Nuevo", "Pérez", "611000000")
        fun showUpdate(id: Int) = onUpdate(id, "CAMBIADO", "Cambiado", "699999999")
        fun showDelete(id: Int) = onDelete(id)
   }
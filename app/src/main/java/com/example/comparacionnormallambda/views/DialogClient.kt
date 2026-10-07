package com.example.comparacionnormallambda.views

class DialogClient {
    private lateinit var onAdd: (Int, String, String, String) -> Unit
    private lateinit var onUpdate: (Int, String, String, String) -> Unit
    private lateinit var onDelete: (Int) -> Unit

    fun setListener(
        onAdd: (Int, String, String, String) -> Unit,
        onUpdate: (Int, String, String, String) -> Unit,
        onDelete: (Int) -> Unit
    ) {
        this.onAdd = onAdd
        this.onUpdate = onUpdate
        this.onDelete = onDelete
    }

    fun show(typeAction: TypeAction, id: Int) {
        when (typeAction) {
            TypeAction.INSERT -> onAdd(id, "Nuevo", "Pérez", "611000000")
            TypeAction.UPDATE -> onUpdate(id, "CAMBIADO", "Cambiado", "699999999")
            TypeAction.DELETE -> onDelete(id)
        }
    }
}

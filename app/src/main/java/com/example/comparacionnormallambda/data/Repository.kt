package com.example.comparacionnormallambda.data

class Repository {
    val listClients: List<Client> = listOf(
        Client(100, "Santi", "Rodenas", "600111222"),
        Client(101, "Brian", "Cortés", "600333444"),
        Client(102, "Guille", "López", "600555666"),
        Client(103, "Ruth", "jiménez", "600777888")
    )

    companion object {
        val listClients: Any
    }
}
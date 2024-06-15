package com.upn.garage.domain.constants

enum class MATRIX_ITEM(val type: String) {
    BOOKED("B"),     // RESERVADO
    RESERVED("R"),   // TOMADO
    AVAILABLE("A"),  // DISPONIBLE
    WHITE_SPACE("E"),  // ESPACIO EN BLANCO
    ROW ("RW"); // ROW
}

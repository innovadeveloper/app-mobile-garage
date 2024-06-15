package com.upn.garage.domain.constants

/**
 *
 *     ROW("ROW"),     // ROW
 *     BOOKED("TOMADO"),     // RESERVADO
 *     RESERVED("RESERVADO"),   // TOMADO
 *     AVAILABLE("DISPONIBLE");  // DISPONIBLE
 */
enum class MATRIX_ITEM(val type: String) {
    BOOKED("TOMADO"),     // RESERVADO
    RESERVED("RESERVADO"),   // TOMADO
    AVAILABLE("DISPONIBLE"),  // DISPONIBLE
    WHITE_SPACE("SPACE"),  // ESPACIO EN BLANCO
    ROW ("ROW"); // ROW

    companion object {
        fun fromType(type: String): MATRIX_ITEM? {
            return MATRIX_ITEM.values().find { it.type == type }
        }
    }
}

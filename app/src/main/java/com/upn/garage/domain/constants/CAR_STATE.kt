package com.upn.garage.domain.constants

enum class CAR_STATE(val type: String) {
    ROW("ROW"),     // ROW
    BOOKED("TOMADO"),     // RESERVADO
    RESERVED("RESERVADO"),   // TOMADO
    AVAILABLE("DISPONIBLE");  // DISPONIBLE
    companion object {
        fun fromType(type: String): CAR_STATE? {
            return values().find { it.type == type }
        }
    }
}

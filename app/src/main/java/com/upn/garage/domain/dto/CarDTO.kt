package com.upn.garage.domain.dto

import com.upn.garage.domain.constants.CAR_STATE


data class CarDTO(val position : Int, val state : CAR_STATE, val description : String)

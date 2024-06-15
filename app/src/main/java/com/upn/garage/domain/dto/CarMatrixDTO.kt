package com.upn.garage.domain.dto

import com.upn.garage.domain.constants.MATRIX_ITEM


data class CarMatrixDTO(val position : Int, val matrixItem : MATRIX_ITEM, val description : String? = "")
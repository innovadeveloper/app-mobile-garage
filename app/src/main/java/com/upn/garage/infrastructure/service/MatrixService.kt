package com.upn.garage.infrastructure.service

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.upn.garage.domain.dto.CarMatrixDTO
import java.util.Queue

interface MatrixService {
    fun iterate(carMatrixQueue: Queue<CarMatrixDTO>, rootView: LinearLayout, context : Context, currentLayout : LinearLayout? = null,
                viewList : MutableList<View>, closure : ((carMatrixQueueElement : CarMatrixDTO, view : View) -> Unit))
}
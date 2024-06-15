package com.upn.garage.infrastructure.service.impl

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.upn.garage.R
import com.upn.garage.domain.constants.MATRIX_ITEM
import com.upn.garage.domain.constants.MatrixConfig
import com.upn.garage.domain.dto.CarMatrixDTO
import com.upn.garage.infrastructure.service.MatrixService
import java.util.Queue

class MatrixServiceImpl : MatrixService {

    override fun iterate(carMatrixQueue: Queue<CarMatrixDTO>, rootView: LinearLayout, context : Context, currentLayout : LinearLayout?,
                         viewList : MutableList<View>, closure : ((carMatrixQueueElement : CarMatrixDTO, view : View) -> Unit)) {
        if(carMatrixQueue.isEmpty() || carMatrixQueue.peek() == null)return;
        val carMatrixQueueElement = carMatrixQueue.remove()
        var currentLayoutTemp = currentLayout
        when(carMatrixQueueElement.matrixItem){
            MATRIX_ITEM.ROW -> {
                currentLayoutTemp = LinearLayout(context)
                currentLayoutTemp.orientation = LinearLayout.HORIZONTAL
                rootView.addView(currentLayoutTemp)
            }
            MATRIX_ITEM.WHITE_SPACE -> {
                val view = TextView(context)
                val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(MatrixConfig.itemWidthSize, MatrixConfig.itemHeightSize)
                layoutParams.setMargins(MatrixConfig.itemGaping, MatrixConfig.itemGaping, MatrixConfig.itemGaping, MatrixConfig.itemGaping)
                view.layoutParams = layoutParams
                view.setBackgroundColor(Color.TRANSPARENT)
                view.text = ""
                currentLayoutTemp?.addView(view)
            }
            MATRIX_ITEM.BOOKED, MATRIX_ITEM.RESERVED, MATRIX_ITEM.AVAILABLE -> {
//                val view = TextView(context)
                val inflater = LayoutInflater.from(context)
                val layout : View = inflater.inflate(R.layout.car_item, currentLayoutTemp, false)
                (layout.findViewById<TextView>(R.id.tvDescription)).text = carMatrixQueueElement.description

                val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(MatrixConfig.itemWidthSize, MatrixConfig.itemHeightSize)
                layoutParams.setMargins(MatrixConfig.itemGaping, MatrixConfig.itemGaping, MatrixConfig.itemGaping, MatrixConfig.itemGaping)
                layout.layoutParams = layoutParams
                currentLayoutTemp?.addView(layout)
                viewList.add(layout)
                layout.setOnClickListener { closure.invoke(carMatrixQueueElement, layout) }
                val textColorValue = if (carMatrixQueueElement.matrixItem == MATRIX_ITEM.BOOKED) Color.GRAY else if
                                                                                                                         (carMatrixQueueElement.matrixItem == MATRIX_ITEM.RESERVED) Color.BLUE else Color.RED
                (layout.findViewById<TextView>(R.id.tvDescription)).setTextColor(textColorValue)   // distinct
            }
            else -> {

            }
        }


        this.iterate(carMatrixQueue, rootView, context, currentLayoutTemp, viewList, closure)
    }
}
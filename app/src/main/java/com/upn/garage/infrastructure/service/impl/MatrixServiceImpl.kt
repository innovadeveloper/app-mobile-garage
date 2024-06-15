package com.upn.garage.infrastructure.service.impl

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
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
                (layout.findViewById<TextView>(R.id.tvDescription)).text = carMatrixQueueElement.description?.uppercase()
                (layout.findViewById<TextView>(R.id.tvPosition)).text = carMatrixQueueElement.position.toString()

                when (carMatrixQueueElement.matrixItem) {
                    MATRIX_ITEM.BOOKED -> {
                        (layout.findViewById<ImageView>(R.id.ivImage)).setColorFilter(ContextCompat.getColor(context, R.color.booked))
                        (layout.findViewById<TextView>(R.id.tvDescription)).setTextColor(ContextCompat.getColor(context, R.color.booked))
                    }
                    MATRIX_ITEM.AVAILABLE -> {
                        (layout.findViewById<ImageView>(R.id.ivImage)).setColorFilter(ContextCompat.getColor(context, R.color.available))
                        (layout.findViewById<TextView>(R.id.tvDescription)).setTextColor(ContextCompat.getColor(context, R.color.available))
                        (layout.findViewById<TextView>(R.id.tvDescription)).setText(carMatrixQueueElement.matrixItem.type)
                    }
                    MATRIX_ITEM.RESERVED -> {
                        (layout.findViewById<ImageView>(R.id.ivImage)).setColorFilter(ContextCompat.getColor(context, R.color.reserved))
                        (layout.findViewById<TextView>(R.id.tvDescription)).setTextColor(ContextCompat.getColor(context, R.color.reserved))
                    }
                    else -> ContextCompat.getColor(context, R.color.available) // Por ejemplo, un color por defecto
                }

                val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(MatrixConfig.itemWidthSize, MatrixConfig.itemHeightSize)
                layoutParams.setMargins(MatrixConfig.itemGaping, MatrixConfig.itemGaping, MatrixConfig.itemGaping, MatrixConfig.itemGaping)
                layout.layoutParams = layoutParams
                currentLayoutTemp?.addView(layout)
                viewList.add(layout)
                layout.setOnClickListener { closure.invoke(carMatrixQueueElement, layout) }
            }
            else -> {

            }
        }


        this.iterate(carMatrixQueue, rootView, context, currentLayoutTemp, viewList, closure)
    }
}
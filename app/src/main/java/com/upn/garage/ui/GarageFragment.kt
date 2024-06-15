package com.upn.garage.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.upn.garage.App
import com.upn.garage.R
import com.upn.garage.data.network.RetrofitInstance
import com.upn.garage.databinding.GarageFragmentBinding
import com.upn.garage.domain.constants.CAR_STATE
import com.upn.garage.domain.constants.MATRIX_ITEM
import com.upn.garage.domain.dto.CarMatrixDTO
import com.upn.garage.domain.dto.LogoutRequest
import com.upn.garage.domain.ext.showToast
import com.upn.garage.infrastructure.service.MatrixService
import com.upn.garage.infrastructure.service.impl.MatrixServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.LinkedList
import java.util.Queue

class GarageFragment : BaseFragment(), View.OnClickListener{

    lateinit var binding : GarageFragmentBinding
    var seatGaping: Int = 10

    var STATUS_AVAILABLE: Int = 1
    var STATUS_BOOKED: Int = 2
    var STATUS_RESERVED: Int = 3
    var selectedIds: String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = GarageFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(requireActivity())
    }

    fun initView(context : Context){
        val layoutSeat = LinearLayout(context)
        val params =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutSeat.orientation = LinearLayout.VERTICAL
        layoutSeat.layoutParams = params

        //        layoutSeat.setBackgroundColor(Color.RED);
        layoutSeat.setPadding(8 * seatGaping, 8 * seatGaping, 8 * seatGaping, 8 * seatGaping)
        binding.layoutSeat.addView(layoutSeat)

        val layout: LinearLayout? = null

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.apiService.getGaragePositionList()
                withContext(Dispatchers.Main) {
                    if(!response.isEmpty()){
                        val carMatrixDTOQueue: Queue<CarMatrixDTO> = LinkedList()
                        response.forEach {garagePosition ->
                            MATRIX_ITEM.fromType(garagePosition.state)?.let {
                                println("car position ${garagePosition.position} , type ${garagePosition.state}")
                                carMatrixDTOQueue.add(CarMatrixDTO(garagePosition.position, it, garagePosition.username))
                            }
                        }
                        val matrixService: MatrixService = MatrixServiceImpl()
                        val viewList: MutableList<View> = ArrayList()
                        matrixService.iterate(carMatrixDTOQueue, layoutSeat, requireActivity(), layout, viewList) { carMatrixDTO: CarMatrixDTO, view: View? ->
                            if(carMatrixDTO.matrixItem == MATRIX_ITEM.BOOKED || carMatrixDTO.matrixItem == MATRIX_ITEM.RESERVED)
                                context.showToast("La posición ${carMatrixDTO.position} fue tomada por ${carMatrixDTO.description}")
                            else
                                context.showToast("La posición ${carMatrixDTO.position} se encuentra libre")
                            null
                        }
                    }
                }
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }

    override fun onClick(view: View) {
        if (view.tag as Int == STATUS_AVAILABLE) {
            if (selectedIds.contains(view.id.toString() + ",")) {
                selectedIds = selectedIds.replace(view.id.toString() + ",", "")
                view.setBackgroundResource(R.drawable.ic_seats_book)
            } else {
                selectedIds = selectedIds + view.id + ","
                view.setBackgroundResource(R.drawable.ic_seats_selected)
            }
        } else if (view.tag as Int == STATUS_BOOKED) {
            requireActivity().showToast("Seat " + view.id + " is Booked")
        } else if (view.tag as Int == STATUS_RESERVED) {
            requireActivity().showToast("Seat " + view.id + " is Reserved")
        }
    }
}

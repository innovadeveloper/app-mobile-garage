package com.upn.garage.ui;


import android.view.View;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.upn.garage.R;
import com.upn.garage.domain.constants.MATRIX_ITEM;
import com.upn.garage.domain.dto.CarMatrixDTO;
import com.upn.garage.infrastructure.service.MatrixService;
import com.upn.garage.infrastructure.service.impl.MatrixServiceImpl;


public class GarageActivity extends AppCompatActivity implements View.OnClickListener{
    ViewGroup layout;

    List<TextView> seatViewList = new ArrayList<>();
    int seatSize = 100;
    int seatGaping = 10;

    int STATUS_AVAILABLE = 1;
    int STATUS_BOOKED = 2;
    int STATUS_RESERVED = 3;
    String selectedIds = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);

        layout = findViewById(R.id.layoutSeat);

//        seats = "/" + seats;

        /**
         * CONSTRUCCION DE UN LAYOUT CONTENEDOR
         */
        LinearLayout layoutSeat = new LinearLayout(this);
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutSeat.setOrientation(LinearLayout.VERTICAL);
        layoutSeat.setLayoutParams(params);
//        layoutSeat.setBackgroundColor(Color.RED);
        layoutSeat.setPadding(8 * seatGaping, 8 * seatGaping, 8 * seatGaping, 8 * seatGaping);
        layout.addView(layoutSeat);

        LinearLayout layout = null;

        Queue<CarMatrixDTO> carMatrixDTOQueue = new LinkedList<>();
        carMatrixDTOQueue.add(new CarMatrixDTO(0, MATRIX_ITEM.ROW, ""));
        carMatrixDTOQueue.add(new CarMatrixDTO(1, MATRIX_ITEM.AVAILABLE, "Kane"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(1, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(1, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(1, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(0, MATRIX_ITEM.ROW, ""));
        carMatrixDTOQueue.add(new CarMatrixDTO(1, MATRIX_ITEM.BOOKED, "Ocupado"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.BOOKED, "Ocupado"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.RESERVED, "Reservado"));
        carMatrixDTOQueue.add(new CarMatrixDTO(0, MATRIX_ITEM.ROW, ""));
        carMatrixDTOQueue.add(new CarMatrixDTO(1, MATRIX_ITEM.BOOKED, "Ocupado"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.WHITE_SPACE, "LIBRE"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.RESERVED, "Reservado"));;
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));;
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(0, MATRIX_ITEM.ROW, ""));
        carMatrixDTOQueue.add(new CarMatrixDTO(1, MATRIX_ITEM.BOOKED, "Ocupado"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.BOOKED, "Ocupado"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.RESERVED, "Reservado"));
        carMatrixDTOQueue.add(new CarMatrixDTO(0, MATRIX_ITEM.ROW, ""));
        carMatrixDTOQueue.add(new CarMatrixDTO(1, MATRIX_ITEM.BOOKED, "Ocupado"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.BOOKED, "Ocupado"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.RESERVED, "Reservado"));
        carMatrixDTOQueue.add(new CarMatrixDTO(0, MATRIX_ITEM.ROW, ""));
        carMatrixDTOQueue.add(new CarMatrixDTO(1, MATRIX_ITEM.BOOKED, "Ocupado"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.BOOKED, "Ocupado"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(2, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.AVAILABLE, "Disponible"));
        carMatrixDTOQueue.add(new CarMatrixDTO(3, MATRIX_ITEM.RESERVED, "Reservado"));

        MatrixService matrixService = new MatrixServiceImpl();
        List<View> viewList = new ArrayList<>();
        matrixService.iterate(carMatrixDTOQueue, layoutSeat, this, layout, viewList, (carMatrixDTO, view) -> {
            Toast.makeText(GarageActivity.this,"Click in " + carMatrixDTO.getDescription(), Toast.LENGTH_SHORT).show();
            return null;
        });

    }

    @Override
    public void onClick(View view) {
        if ((int) view.getTag() == STATUS_AVAILABLE) {
            if (selectedIds.contains(view.getId() + ",")) {
                selectedIds = selectedIds.replace(+view.getId() + ",", "");
                view.setBackgroundResource(R.drawable.ic_seats_book);
            } else {
                selectedIds = selectedIds + view.getId() + ",";
                view.setBackgroundResource(R.drawable.ic_seats_selected);
            }
        } else if ((int) view.getTag() == STATUS_BOOKED) {
            Toast.makeText(this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();
        } else if ((int) view.getTag() == STATUS_RESERVED) {
            Toast.makeText(this, "Seat " + view.getId() + " is Reserved", Toast.LENGTH_SHORT).show();
        }
    }
}
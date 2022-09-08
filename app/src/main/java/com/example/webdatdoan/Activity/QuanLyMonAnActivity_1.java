package com.example.webdatdoan.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.webdatdoan.Adapter.OrderAdapter_1;
import com.example.webdatdoan.DAO.HoaDon_DAO;
import com.example.webdatdoan.Domain.Orderdetail;
import com.example.webdatdoan.R;
import com.example.webdatdoan.model.HoaDon;

import java.util.ArrayList;

public class QuanLyMonAnActivity_1 extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
   // private OrderAdapter orderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderprocessing_main);
        HoaDon_DAO hd = new HoaDon_DAO(this);
        recyclerViewOrder();
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerViewOrder();
    }

    private void recyclerViewOrder() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.Recyclerview1);

        HoaDon_DAO hoaDon_dao = new HoaDon_DAO(this);

        ArrayList<HoaDon> hoaDon =  hoaDon_dao.DanhSachHoaDonCanDuyet();
        if(hoaDon == null)
        {
            Toast.makeText(this, "Không có đơn hàng nào chưa duyệt", Toast.LENGTH_SHORT).show();
            return;
        }
        adapter = new OrderAdapter_1(hoaDon,this);
        //adapter = new OrderAdapter(orderDomain, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);



//        recyclerView.setAdapter(orderAdapter);
//        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
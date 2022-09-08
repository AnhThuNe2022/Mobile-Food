package com.example.webdatdoan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webdatdoan.Adapter.OrderAdapter;
import com.example.webdatdoan.DAO.HoaDonChiTiet_DAO;
import com.example.webdatdoan.DAO.HoaDon_DAO;
import com.example.webdatdoan.Domain.Orderdetail;
import com.example.webdatdoan.R;

import java.util.ArrayList;
import java.util.Locale;

public class ChiTietDonHang  extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private Button duyet;
    private String maDH;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderdetail_main);
        duyet = findViewById(R.id.btduyet);
        maDH = (String) getIntent().getSerializableExtra("maDH");
        recyclerViewOrderDetail();
        duyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HoaDon_DAO hoaDon_dao = new HoaDon_DAO(ChiTietDonHang.this);
                if(hoaDon_dao.UpdateTrangThaiDuyet(maDH))
                {
                    Toast.makeText(ChiTietDonHang.this, "Duyệt Thành Công", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ChiTietDonHang.this,"Lỗi",Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });




    }

    private void recyclerViewOrderDetail() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.Recyclerview_oderdetail);

        HoaDonChiTiet_DAO hdct =new HoaDonChiTiet_DAO(this);
        ArrayList<Orderdetail> orderDomain = hdct.GetHoaDonChiTiets(maDH);
        if(orderDomain == null)
        {
            Toast.makeText(this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
            return;
        }
        adapter = new OrderAdapter(orderDomain,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);


    }


}

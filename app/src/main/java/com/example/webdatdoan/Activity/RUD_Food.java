package com.example.webdatdoan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webdatdoan.Adapter.FoodAdapter;
import com.example.webdatdoan.Adapter.OrderAdapter;
import com.example.webdatdoan.DAO.Food_DAO;
import com.example.webdatdoan.DAO.HoaDonChiTiet_DAO;
import com.example.webdatdoan.Domain.Orderdetail;
import com.example.webdatdoan.R;
import com.example.webdatdoan.model.MonAn;

import java.util.ArrayList;

public class RUD_Food extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    Button addFood;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rud_food);

        addFood = findViewById(R.id.RUD_btthemMon);
        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RUD_Food.this,AddFood.class);
                startActivity(intent);
            }
        });
        RecyclerViewFood();

    }
    @Override
    protected void onResume() {
        super.onResume();
        RecyclerViewFood();
    }

    private void RecyclerViewFood() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.RecycleFoods);

        Food_DAO food_dao = new Food_DAO(this);
        ArrayList<MonAn> monAns = food_dao.Show_Food();


        if(monAns == null)
        {
            Toast.makeText(this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show();
            return;
        }


        adapter = new FoodAdapter(monAns,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);


    }
}

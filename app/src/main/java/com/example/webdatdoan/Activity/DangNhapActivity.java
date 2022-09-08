package com.example.webdatdoan.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.webdatdoan.DAO.KhachHang_DAO;
import com.example.webdatdoan.R;
import com.example.webdatdoan.model.KhachHang;

public class DangNhapActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KhachHang_DAO kh_dao = new KhachHang_DAO(this);



    }
}

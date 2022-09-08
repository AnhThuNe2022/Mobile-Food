package com.example.webdatdoan.Activity;

import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.webdatdoan.DAO.KhachHang_DAO;
import com.example.webdatdoan.R;

public class QuanLyMonAnActivity extends AppCompatActivity {

   Button bt1,bt2;
    private ActionBar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_main);

        bt1 = findViewById(R.id.xuLyDonHang);
        bt2 = findViewById(R.id.quanLy);
        toolbar = getSupportActionBar();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuanLyMonAnActivity.this,QuanLyMonAnActivity_1.class);
                startActivityForResult(intent,2);

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuanLyMonAnActivity.this,RUD_Food.class);
                startActivity(intent);
            }
        });


    }

}


package com.example.webdatdoan.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.webdatdoan.DAO.FoodType_DAO;
import com.example.webdatdoan.DAO.Food_DAO;
import com.example.webdatdoan.Domain.FoodType;
import com.example.webdatdoan.R;
import com.example.webdatdoan.model.MonAn;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class AddFood extends AppCompatActivity {
    Spinner spinner_LoaiMonAn, add_pic;
    FoodType_DAO food_dao;
    Food_DAO food ;
    ImageView anh;
    EditText tenMonAn,loaiMonAn,moTa,soLuongTonKho,donGia,donViTinh;
    TextView maMonAn;
    int indexpic;
    int indexfoodtype;
    Button btThem,btXoa;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rud_addfood);
        AnhXa();
        btXoa = findViewById(R.id.AddFood_btXoa);
        ViewGroup layout = (ViewGroup) btXoa.getParent();
        if(null!=layout) //for safety only  as you are doing onClick
            layout.removeView(btXoa);

        food = new Food_DAO(this);
        String foodId = food.getId();
        if(foodId == null)
        {
            foodId = "MA1";
        }
        else
        {
            foodId = foodId.substring(2);
        }

        int mama =  Integer.parseInt(foodId)+1;
        maMonAn.setText("MA" +mama);

        food_dao  = new FoodType_DAO(this);

        ArrayList<FoodType> foodTypes = food_dao.DSLoaiMonAn();
        ArrayList<String> name = new ArrayList<>();

        for (int i  = 0 ; i < foodTypes.size(); i++)
        {
            name.add(foodTypes.get(i).getTenLoaiMoAn());
        }


        ArrayAdapter<String>  adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,name);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_LoaiMonAn.setAdapter(adapter);

        spinner_LoaiMonAn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indexfoodtype = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        ArrayList<Integer> imageListId = new ArrayList<Integer>();
        ArrayList<String> imageListName = new ArrayList<>();

        Field[] drawables = R.drawable.class.getFields();
        for (Field f : drawables) {
            if (f.getName().contains("pic"))
            {
                imageListId.add(getResources().getIdentifier(f.getName(), "drawable", getPackageName()));
                imageListName.add(f.getName());
            }
        }
        ArrayAdapter<String>  adapterPic = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,imageListName);
        adapterPic.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        add_pic.setAdapter(adapterPic);

        add_pic.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                anh.setImageResource(imageListId.get(i));
                indexpic = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = maMonAn.getText().toString();
                String name = tenMonAn.getText().toString();
                String loaiMonAn = foodTypes.get(indexfoodtype).getMaLoaiMonAn();
                String des = moTa.getText().toString();
                String pic = imageListName.get(indexpic);
                String price = donGia.getText().toString();
                String dvt = donViTinh.getText().toString();
                int sl = -1;
                if(soLuongTonKho.getText().length() > 0)
                {
                    sl = Integer.parseInt(soLuongTonKho.getText().toString());
                }
                if(id == null || name == null || des== null || price.isEmpty() ||dvt.isEmpty() ||sl == -1 )
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(AddFood.this);
                    alert.setTitle("Thông Báo").setMessage("Không Thể Để Trống Các Mục").setCancelable(true).
                            setPositiveButton("Tiếp Tục Thêm", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            }).setNegativeButton("Quay Lại", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }).show();
                    return;
                }



                MonAn m = new MonAn(id,name,loaiMonAn,des,sl,pic,Double.parseDouble(price),dvt);

                if(food.ThemMonAn(m))
                {
                    Toast.makeText(AddFood.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AddFood.this, "Thêm Không Thành Công", Toast.LENGTH_SHORT).show();
                }

                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == 5)
            {
                btThem.setText("Cập Nhật");
                Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
            }
            else
            {
            }
    }

    private void AnhXa()
    {
        spinner_LoaiMonAn = findViewById(R.id.AddFood_Sippner_LoaiMonAn);
        add_pic = findViewById(R.id.AddFood_Spinneranh);
        anh = findViewById(R.id.AddFood_anh);

        maMonAn = findViewById(R.id.AddFood_maMonAn);
        tenMonAn= findViewById(R.id.AddFood_TenMonAn);
        moTa = findViewById(R.id.AddFood_Mota);
        soLuongTonKho = findViewById(R.id.AddFood_sltk);
        donGia = findViewById(R.id.AddFood_dongia);
        donViTinh = findViewById(R.id.AddFood_DonViTinh);
        btThem = findViewById(R.id.AddFood_btThem);

    }
}

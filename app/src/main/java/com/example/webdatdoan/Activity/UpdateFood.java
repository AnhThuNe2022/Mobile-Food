package com.example.webdatdoan.Activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
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
import androidx.recyclerview.widget.RecyclerView;

import com.example.webdatdoan.DAO.FoodType_DAO;
import com.example.webdatdoan.DAO.Food_DAO;
import com.example.webdatdoan.Domain.FoodType;
import com.example.webdatdoan.R;
import com.example.webdatdoan.model.MonAn;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class UpdateFood extends AppCompatActivity
{
    Food_DAO food_dao ;
    FoodType_DAO food_type_dao;
    Spinner spinner_LoaiMonAn, add_pic;
    Food_DAO food ;
    ImageView anh;
    EditText tenMonAn,loaiMonAn,moTa,soLuongTonKho,donGia,donViTinh;
    TextView maMonAn;
    int indexpic;
    int indexfoodtype;
    Button btThem,btXoa;
    String maMA;
    String ten;
    ArrayList<Integer> imageListId = new ArrayList<Integer>();
    ArrayList<String> imageListName = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rud_addfood);
        AnhXa();
        btThem.setText("Xác Nhận Sửa");
        food_dao = new Food_DAO(this);
        food_type_dao = new FoodType_DAO(this);



        ArrayList<FoodType> foodTypes = food_type_dao.DSLoaiMonAn();
        ArrayList<String> name = new ArrayList<>();

        for (int i  = 0 ; i < foodTypes.size(); i++)
        {
            name.add(foodTypes.get(i).getTenLoaiMoAn());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,name);
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
                    AlertDialog.Builder alert = new AlertDialog.Builder(UpdateFood.this);
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
                if(food_dao.update(m))
                {
                    Toast.makeText(UpdateFood.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                    Toast.makeText(UpdateFood.this, "Sửa thất bại", Toast.LENGTH_SHORT).show();
            }
        });


        btXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(food_dao.delete(maMonAn.getText().toString()))
                {
                    Toast.makeText(UpdateFood.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(UpdateFood.this, "Xóa Thất Bại", Toast.LENGTH_SHORT).show();
                }

            }
        });
        maMA = (String) getIntent().getSerializableExtra("MaMonAn");

        getFood();



    }

    private void getFood() {
        MonAn m  = food_dao.GetMonAn(maMA);
        maMonAn.setText(m.getMaMonAn());
        tenMonAn.setText(m.getTenMonAn());
        moTa.setText(m.getMoTa());
        soLuongTonKho.setText(String.valueOf(m.getSoLuongTonKho()));
        donGia.setText(m.getDonGia().toString());
        donViTinh.setText(m.getDonViTinh());
        spinner_LoaiMonAn.setSelection(getIndex(spinner_LoaiMonAn,m.getLoaiMonAn()));
        int k = -1;
        for( int i = 0 ; i <  imageListId.size(); i++) {
            if (imageListId.get(i) == Integer.parseInt(m.getAnh()))
            {
                k = i;
                break;
            }
        }
        add_pic.setSelection(getIndex(add_pic,imageListName.get(k)));

    }
    private int getIndex(Spinner spinner, String myString){
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                return i;
            }
        }
        return 0;
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
        btXoa = findViewById(R.id.AddFood_btXoa);
    }
}

package com.example.webdatdoan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.webdatdoan.Activity.DangNhapActivity;
import com.example.webdatdoan.Activity.QuanLyMonAnActivity;
import com.example.webdatdoan.DAO.KhachHang_DAO;
import com.example.webdatdoan.database.DatabaseHelper;
import com.example.webdatdoan.model.KhachHang;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class MainActivity extends AppCompatActivity {

    TextView text ;
    Button bt,btinsert;

    private DatabaseHelper mDB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDB = new DatabaseHelper(this);

        KhachHang_DAO kh_dao = new KhachHang_DAO(this);
        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);

        if(false == database.exists())
        {
            mDB.getReadableDatabase();
            if(copyDatabase(this))
            {
                Toast.makeText(this, "Copy database success", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Copy database error", Toast.LENGTH_SHORT).show();
                return;

            }
        }

//        Intent k = new Intent(MainActivity.this, DangNhapActivity.class);
//        startActivityForResult(k,1);

        Intent k1 = new Intent(MainActivity.this, QuanLyMonAnActivity.class);
        startActivityForResult(k1,2);



    }


    private boolean copyDatabase(Context context) {

        try{
            InputStream myinput =  context.getAssets().open(DatabaseHelper.DBNAME);
            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;


            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int len = 0;

            while((len = myinput.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }

            outputStream.flush();
            outputStream.close();
            myinput.close();
            Log.w("Main", "DB copied");
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
            Log.e("Lỗi sao chép",e.toString());
            return false;
        }
    }
}
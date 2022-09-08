package com.example.webdatdoan.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.webdatdoan.Domain.Orderdetail;
import com.example.webdatdoan.database.DatabaseHelper;
import com.example.webdatdoan.model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class HoaDon_DAO {
    Context context;

    public HoaDon_DAO(Context context)
    {
        this.context = context;
    }

    public void duyetHoaDon()
    {
        DatabaseHelper db = new DatabaseHelper(context);
        db.opendatabase();


        db.closeDatabase();
    }
    public ArrayList<HoaDon> DanhSachHoaDonCanDuyet()
    {
        DatabaseHelper db = new DatabaseHelper(context);
        db.opendatabase();
        Cursor c = db.getmDatabase().rawQuery("SELECT MAHOADON,MAKH,NGAYDAT,TONGTIEN FROM HOADON WHERE TRANGTHAI = -1 ",null);

        ArrayList<HoaDon> hd = new ArrayList<>();


        if(c.getCount()>0)
        {
            c.moveToFirst();
            do{
                HoaDon h = new HoaDon(c.getString(0),c.getString(1),c.getString(2),Double.valueOf(c.getString(3)));
                hd.add(h);
            }while (c.moveToNext());

        }
        db.closeDatabase();
        return hd;

    }

    public boolean UpdateTrangThaiDuyet(String maHD)
    {
        DatabaseHelper db = new DatabaseHelper(context);
        ArrayList<Orderdetail> hoaDonChiTiets = new ArrayList<>();
        try{

            db.opendatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("TrangThai",0);

            Cursor c = db.getmDatabase().rawQuery("select * from HoaDon where MaHoaDon = ?", new String[]{maHD});
            if(c.getCount() > 0)
            {
                long result = db.getmDatabase().update("HoaDon",contentValues,"MaHoaDon = ?",new String[]{maHD});
                if(result == -1)
                    return false;
                else
                    return true;
            }
            return false;
        }
        finally {
            db.closeDatabase();
        }


    }


    public boolean Update(String maHD) {
        DatabaseHelper db = new DatabaseHelper(context);
        ArrayList<Orderdetail> hoaDonChiTiets = new ArrayList<>();
        try {

            db.opendatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("TrangThai", -1);

            Cursor c = db.getmDatabase().rawQuery("select * from HoaDon where MaHoaDon = ?", new String[]{maHD});
            if (c.getCount() > 0) {
                long result = db.getmDatabase().update("HoaDon", contentValues, "MaHoaDon = ?", new String[]{maHD});
                if (result == -1)
                    return false;
                else
                    return true;
            }
            return false;
        } finally {
            db.closeDatabase();
        }
    }


    public boolean delete(ArrayList<String >  maDH)
    {
        DatabaseHelper db = new DatabaseHelper(context);

        try{
            db.opendatabase();

            for(String i : maDH)
            {
                Cursor c = db.getmDatabase().rawQuery("select * from HoaDon where maHoaDon = ?", new String[]{i});
                if(c.getCount() > 0)
                {
                    long result = db.getmDatabase().delete("HoaDon","maHoaDon=?",new String[]{i});
                    if(result == -1)
                    {
                        return false;
                    }
                }
            }
            return true;


        }finally {
            db.closeDatabase();
        }
    }

}

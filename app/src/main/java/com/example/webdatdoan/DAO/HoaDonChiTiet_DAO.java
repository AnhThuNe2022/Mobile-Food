package com.example.webdatdoan.DAO;

import android.content.Context;
import android.database.Cursor;


import com.example.webdatdoan.Domain.Orderdetail;

import com.example.webdatdoan.database.DatabaseHelper;


import java.util.ArrayList;
import java.util.Locale;

public class HoaDonChiTiet_DAO {
    Context context;
    public HoaDonChiTiet_DAO(Context context)
    {
        this.context =context;
    }

    public ArrayList<Orderdetail> GetHoaDonChiTiets(String maHoaDon)
    {
        DatabaseHelper db = new DatabaseHelper(context);
        ArrayList<Orderdetail> hoaDonChiTiets = new ArrayList<>();
        try{

            db.opendatabase();


            Cursor c = db.getmDatabase().rawQuery("SELECT TenMonAn,SoLuong,MonAn.DonGia,Anh FROM HoaDonChiTiet, MonAn\n" +
                    "WHERE HoaDonChiTiet.MaMonAn = MonAn.MaMonAn \n" +
                    "AND MaHoaDon = ?",new String[]{maHoaDon});

            if(c.getCount()>0)
            {
                c.moveToFirst();
                do{
                    int resource = context.getResources().getIdentifier(c.getString(3).toLowerCase(),"drawable",context.getPackageName());
                    Orderdetail orderdetail = new Orderdetail(c.getString(0),c.getInt(1),Double.valueOf(c.getString(2)),resource);
                    hoaDonChiTiets.add(orderdetail);

                }while (c.moveToNext());

            }
            else
               return null;
            return hoaDonChiTiets;
        }
        finally {
            db.closeDatabase();
        }


    }


    public boolean delete(String maMA,ArrayList<String> maDH)
    {
        DatabaseHelper db = new DatabaseHelper(context);

        try{
            db.opendatabase();
            Cursor c = db.getmDatabase().rawQuery("select * from HoaDonChiTiet WHERE MaMonAn = ?", new String[]{maMA});
            if(c.getCount() > 0)
            {
                if(c.getCount() == 1)
                {
                    for(int i = 0 ; i < c.getCount() ; i++)
                    {
                        c.moveToNext();
                        maDH.add(c.getString(0));
                    }
                }


                long result = db.getmDatabase().delete("HoaDonChiTiet","MaMonAn=?",new String[]{maMA});


                if(result == -1)
                    return false;
                else
                    return true;
            }
            return false;

        }finally {
            db.closeDatabase();
        }
    }

}

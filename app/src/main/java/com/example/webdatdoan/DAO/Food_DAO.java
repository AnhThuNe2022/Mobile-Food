package com.example.webdatdoan.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.webdatdoan.database.DatabaseHelper;
import com.example.webdatdoan.model.MonAn;

import java.util.ArrayList;

public class Food_DAO {
    Context context;
    public Food_DAO(Context context)
    {
        this.context = context;
    }

    public ArrayList<MonAn> Show_Food()
    {
        DatabaseHelper db = new DatabaseHelper(context);

        try{
            db.opendatabase();
            Cursor c = db.getmDatabase().rawQuery("\n" +
                    "select MaMonAn, TenMonAn,TenLoai,MoTa,SoLuongTonKho,Anh,DonGia,DonViTinh\n" +
                    "from MonAn,LoaiMonAn\n" +
                    "WHERE MonAn.LoaiMonAn = LoaiMonAn.MaLoaiMonAn ",null);

            ArrayList<MonAn> ma = new ArrayList<>();
            if(c.getCount()>0)
            {
                c.moveToFirst();
                do{
                    int resource = context.getResources().getIdentifier(c.getString(5).toLowerCase(),"drawable",context.getPackageName());
                    MonAn h = new MonAn(c.getString(0),c.getString(1),c.getString(2),c.getString(3),
                            c.getInt(4),String.valueOf(resource),Double.parseDouble(c.getString(6)),c.getString(7));
                    ma.add(h);
                }while (c.moveToNext());
                return ma;
            }
          return null;
        }finally {
            db.closeDatabase();
        }

    }


    public MonAn GetMonAn(String mama)
    {
        DatabaseHelper db = new DatabaseHelper(context);

        try{
            db.opendatabase();
            Cursor c = db.getmDatabase().rawQuery("SELECT MaMonAn,TenMonAn,TenLoai,MoTa,SoLuongTonKho,Anh,DonGia,DonViTinh \n" +
                    "FROM MONAN,LoaiMonAn WHERE MonAn.LoaiMonAn = LoaiMonAn.MaLoaiMonAn and  MAMONAN= ?",new String[] {mama});
            if(c.getCount()>0)
            {
                c.moveToFirst();
                int resource = context.getResources().getIdentifier(c.getString(5).toLowerCase(),"drawable",context.getPackageName());
                MonAn h = new MonAn(c.getString(0),c.getString(1),c.getString(2),c.getString(3),
                        c.getInt(4),String.valueOf(resource),Double.parseDouble(c.getString(6)),c.getString(7));
                return h;
            }

            return null;

        }finally {
            db.closeDatabase();
        }

    }


    public boolean ThemMonAn(MonAn monAn)
    {

        DatabaseHelper db = new DatabaseHelper(context);

        try{
            db.opendatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put ("MaMonAn",monAn.getMaMonAn()); ;
            contentValues.put("TenMonAn",monAn.getTenMonAn());
            contentValues.put("MoTa",monAn.getMoTa());
            contentValues.put("LoaiMonAn",monAn.getLoaiMonAn());
            contentValues.put("SoLuongTonKho",monAn.getSoLuongTonKho());
            contentValues.put("Anh",monAn.getAnh());
            contentValues.put("DonGia",monAn.getDonGia().toString());
            contentValues.put("DonViTinh",monAn.getDonViTinh());
            long result = db.getmDatabase().insert("MonAn", null,contentValues);

            if(result == -1)
                return false;
            else
                return true;
        }finally {
            db.closeDatabase();
        }
    }


    public String try5()
    {

        DatabaseHelper db = new DatabaseHelper(context);

        try{
            db.opendatabase();
            return null;

        }finally {
            db.closeDatabase();
        }

    }

    public String getId()
    {

        DatabaseHelper db = new DatabaseHelper(context);
        try{
            db.opendatabase();

            Cursor c = db.getmDatabase().rawQuery("select MaMonAn\n" +
                    "from MonAn\n" +
                    "ORDER BY MaMonAn DESC\n" +
                    "LIMIT 1",null);
            if(c.getCount()>0)
            {
                c.moveToFirst();

                return c.getString(0);
            }
            return null;

        }finally {
            db.closeDatabase();
        }
    }

    public boolean update(MonAn monAn)
    {
        DatabaseHelper db = new DatabaseHelper(context);
        try{
            db.opendatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("TenMonAn",monAn.getTenMonAn());
            contentValues.put("LoaiMonAn",monAn.getLoaiMonAn());
            contentValues.put("SoLuongTonKho",monAn.getSoLuongTonKho());
            contentValues.put("Anh",monAn.getAnh());
            contentValues.put("MoTa",monAn.getMoTa());
            contentValues.put("DonGia",monAn.getDonGia().toString());
            contentValues.put("DonViTinh",monAn.getDonViTinh());

            long result = db.getmDatabase().update("MonAn",contentValues,"MaMonAn = ?",new String[]{monAn.getMaMonAn()});

            if(result == -1)
                return false;
            else
                return true;

        }finally {
            db.closeDatabase();
        }

    }


    public boolean delete(String maDA)
    {
        DatabaseHelper db = new DatabaseHelper(context);

        try{
            db.opendatabase();

            Cursor c = db.getmDatabase().rawQuery("select * from MonAn where MaMonAn = ?", new String[]{maDA});
            if(c.getCount() > 0)
            {
                ArrayList<String> hd = new ArrayList<>();
                HoaDonChiTiet_DAO hdct = new HoaDonChiTiet_DAO(context);
                hdct.delete(maDA,hd);
                if(hd.size() > 0)
                {
                    HoaDon_DAO hd_dao = new HoaDon_DAO(context);
                    hd_dao.delete(hd);

                }
                long result = db.getmDatabase().delete("MonAn","MaMonAn=?",new String[]{maDA});
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

package com.example.webdatdoan.DAO;

import android.content.Context;
import android.database.Cursor;

import com.example.webdatdoan.Domain.FoodType;
import com.example.webdatdoan.database.DatabaseHelper;

import java.util.ArrayList;

public class FoodType_DAO {

    Context context;


    public FoodType_DAO(Context context)
    {
        this.context = context;
    }

    public ArrayList<FoodType> DSLoaiMonAn()
    {
        DatabaseHelper db = new DatabaseHelper(context);
        try{
            db.opendatabase();
            Cursor c = db.getmDatabase().rawQuery("select * from LoaiMonAn",null);

            ArrayList<FoodType> ma = new ArrayList<>();
            if(c.getCount()>0)
            {
                c.moveToFirst();
                do{
                    FoodType foodType = new FoodType(c.getString(0),c.getString(1));
                    ma.add(foodType);
                }while (c.moveToNext());
                return ma;
            }
            return null;
        }finally {
            db.closeDatabase();
        }

    }


    }




package com.example.webdatdoan.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final  String DBNAME = "data.db";
    public static String DBLOCATION = "/data/data/ com.example.test1/databases/";
    public static final int VERSION = 1;
    private static final String BANGGIASHIP = "BangGiaShip";
    private Context mContext = null;


    private SQLiteDatabase mDatabase;
    public DatabaseHelper(@Nullable Context context) {
        super(context, DBNAME,null,VERSION);


        if(android.os.Build.VERSION.SDK_INT >= 17){
            DBLOCATION = context.getApplicationInfo().dataDir + "/databases/";
        }
        else
        {
            DBLOCATION = "/data/data/"+ context.getPackageName() + "/databases/";
        }
        this.mContext =context;
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void opendatabase(){
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase != null && mDatabase.isOpen())
        {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath,null,SQLiteDatabase.OPEN_READWRITE);
    }

    public  void closeDatabase()
    {
        if(mDatabase != null)
        {
            mDatabase.close();
        }

    }



    public Context getmContext() {
        return mContext;
    }

    public SQLiteDatabase getmDatabase() {
        return mDatabase;
    }
}

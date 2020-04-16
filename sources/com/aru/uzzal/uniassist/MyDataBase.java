package com.aru.uzzal.uniassist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDataBase extends SQLiteOpenHelper {
    private static final String CHOICE1 = "choice1";
    private static final String CHOICE2 = "choice2";
    private static final String CHOICE3 = "choice3";
    private static final String DATABASE_NAME = "applyinfo.db";
    private static final String DROP_TABLE = " DROP TABLE IF EXISTS apply";
    private static final String HSCBOARD = "hscboard";
    private static final String HSCREG = "hscreg";
    private static final String HSCROLL = "hscroll";
    private static final String NAME = "name";
    private static final String SSCBOARD = "sscboard";
    private static final String SSCREG = "sscreg";
    private static final String SSCROLL = "sscroll";
    private static final String TABLE_NAME = "apply";
    private static final int VERSION_NUMBER = 7;
    private Context context;

    public MyDataBase(Context context2) {
        super(context2, DATABASE_NAME, null, 7);
        this.context = context2;
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL("CREATE TABLE apply (name VARCHAR(100) NOT NULL, sscroll VARCHAR(100) NOT NULL, sscreg VARCHAR(100) NOT NULL, sscboard VARCHAR(100) NOT NULL, hscroll VARCHAR(100) NOT NULL, hscreg VARCHAR(100) NOT NULL,hscboard VARCHAR(100) NOT NULL, choice1 VARCHAR(100) NOT NULL,choice2 VARCHAR(100) NOT NULL,choice3 VARCHAR(100) NOT NULL)");
            Toast.makeText(this.context, "Oncreate", 0).show();
        } catch (Exception e) {
            Context context2 = this.context;
            StringBuilder sb = new StringBuilder();
            sb.append("Ex");
            sb.append(e);
            Toast.makeText(context2, sb.toString(), 1).show();
        }
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        } catch (Exception e) {
            Context context2 = this.context;
            StringBuilder sb = new StringBuilder();
            sb.append("Ex");
            sb.append(e);
            Toast.makeText(context2, sb.toString(), 1).show();
        }
    }

    public long applyData(String name, String sscroll, String sscreg, String sscboard, String hscroll, String hscreg, String hscboard, String choice1, String choice2, String choice3) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(NAME, name);
        contentValues1.put(SSCROLL, sscroll);
        contentValues1.put(SSCREG, sscreg);
        contentValues1.put(SSCBOARD, sscboard);
        contentValues1.put(HSCROLL, hscroll);
        contentValues1.put(HSCREG, hscreg);
        contentValues1.put(HSCBOARD, hscboard);
        contentValues1.put(CHOICE1, choice1);
        contentValues1.put(CHOICE2, choice2);
        contentValues1.put(CHOICE3, choice3);
        return sqLiteDatabase.insert(TABLE_NAME, null, contentValues1);
    }

    public Cursor getData(String search) {
        return getWritableDatabase().rawQuery("SELECT * FROM apply", null);
    }
}

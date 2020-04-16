package com.aru.uzzal.uniassist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_TABLE = "CREATE TABLE signup(name VARCHAR(100) NOT NULL,username VARCHAR(10) NOT NULL, email VARCHAR(50) NOT NULL, password VARCHAR(50) NOT NULL)";
    private static final String DATABASE_NAME = "userinfo.db";
    private static final String DROP_TABLE = " DROP TABLE IF EXISTS signup";
    private static final String EMAIL = "email";
    private static final String NAME = "name";
    private static final String PASSWORD = "password";
    private static final String SHOW = "SELECT * FROM signup";
    private static final String TABLE_NAME = "signup";
    private static final String USERNAME = "username";
    private static final int VERSION_NUMBER = 9;
    private Context context;

    public DatabaseHelper(Context context2) {
        super(context2, DATABASE_NAME, null, 9);
        this.context = context2;
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_TABLE);
            Toast.makeText(this.context, "Oncreate", 0).show();
        } catch (Exception e) {
            Context context2 = this.context;
            StringBuilder sb = new StringBuilder();
            sb.append("Ex");
            sb.append(e);
            Toast.makeText(context2, sb.toString(), 0).show();
        }
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        } catch (Exception e) {
        }
    }

    public long insertData(userDetails userDetails) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, userDetails.getName());
        contentValues.put(USERNAME, userDetails.getUsername());
        contentValues.put("email", userDetails.getEmail());
        contentValues.put(PASSWORD, userDetails.getPassword());
        return sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public Boolean findPassword(String uemail, String upassword) {
        Cursor cursor = getReadableDatabase().rawQuery(SHOW, null);
        Boolean result = Boolean.valueOf(false);
        if (cursor.getCount() == 0) {
            Toast.makeText(this.context, "Email and Password did not match", 0).show();
            return result;
        }
        while (cursor.moveToNext()) {
            String email = cursor.getString(2);
            String password = cursor.getString(3);
            if (email.equals(uemail) && password.equals(upassword)) {
                return Boolean.valueOf(true);
            }
        }
        return result;
    }

    public Cursor getData(String search) {
        return getWritableDatabase().rawQuery(SHOW, null);
    }

    public int DeleteData(String search) {
        return getWritableDatabase().delete(TABLE_NAME, "email= ?", new String[]{search});
    }

    public boolean UpdateData(String name, String username, String search, String pass) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(USERNAME, username);
        contentValues.put("email", search);
        contentValues.put(PASSWORD, pass);
        sqLiteDatabase.update(TABLE_NAME, contentValues, "email = ?", new String[]{search});
        return true;
    }
}

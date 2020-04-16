package com.aru.uzzal.uniassist;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class AppliedActivity extends AppCompatActivity {
    String fullname;
    MyDataBase myDataBase;
    TextView one;
    TextView three;
    TextView two;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0457R.layout.activity_applied);
        this.one = (TextView) findViewById(C0457R.C0459id.one);
        this.two = (TextView) findViewById(C0457R.C0459id.two);
        this.three = (TextView) findViewById(C0457R.C0459id.three);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.fullname = bundle.getString("name");
        }
        this.myDataBase = new MyDataBase(this);
        SQLiteDatabase readableDatabase = this.myDataBase.getReadableDatabase();
        Cursor cursor = this.myDataBase.getData(this.fullname);
        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "Not found", 0).show();
            return;
        }
        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            String choice1 = cursor.getString(7);
            String choice2 = cursor.getString(8);
            String choice3 = cursor.getString(9);
            if (name.equals(this.fullname)) {
                this.one.setText(choice1);
                this.two.setText(choice2);
                this.three.setText(choice3);
                return;
            }
        }
    }
}

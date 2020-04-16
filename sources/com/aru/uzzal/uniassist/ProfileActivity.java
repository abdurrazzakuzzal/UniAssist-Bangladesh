package com.aru.uzzal.uniassist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    Button applied;
    Button apply;
    DatabaseHelper databaseHelper;
    Button edit;
    TextView email;
    String fullname;
    String mail;
    TextView name;
    String password;
    TextView user;
    View view;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0457R.layout.activity_profile);
        this.edit = (Button) findViewById(C0457R.C0459id.edit);
        this.apply = (Button) findViewById(C0457R.C0459id.apply);
        this.applied = (Button) findViewById(C0457R.C0459id.applied);
        this.name = (TextView) findViewById(C0457R.C0459id.pname);
        this.email = (TextView) findViewById(C0457R.C0459id.pemail);
        this.user = (TextView) findViewById(C0457R.C0459id.use);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.mail = bundle.getString("mail");
        }
        this.databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase readableDatabase = this.databaseHelper.getReadableDatabase();
        Cursor cursor = this.databaseHelper.getData(this.mail);
        if (cursor.getCount() != 0) {
            while (true) {
                if (!cursor.moveToNext()) {
                    break;
                }
                this.fullname = cursor.getString(0);
                String username = cursor.getString(1);
                String email2 = cursor.getString(2);
                this.password = cursor.getString(3);
                if (email2.equals(this.mail)) {
                    this.name.setText(this.fullname);
                    this.user.setText(username);
                    break;
                }
            }
        } else {
            Toast.makeText(getApplicationContext(), "Not found", 0).show();
        }
        this.email.setText(this.mail);
        this.edit.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, EditprofileActivity.class);
                Bundle b = new Bundle();
                b.putString("name", ProfileActivity.this.name.getText().toString());
                b.putString("username", ProfileActivity.this.user.getText().toString());
                b.putString("mail", ProfileActivity.this.mail);
                b.putString("password", ProfileActivity.this.password);
                intent.putExtras(b);
                ProfileActivity.this.startActivity(intent);
            }
        });
        this.apply.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, ApplyActivity.class);
                Bundle b = new Bundle();
                b.putString("name", ProfileActivity.this.name.getText().toString());
                intent.putExtras(b);
                ProfileActivity.this.startActivity(intent);
            }
        });
        this.applied.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, AppliedActivity.class);
                Bundle b = new Bundle();
                b.putString("name", ProfileActivity.this.fullname);
                intent.putExtras(b);
                ProfileActivity.this.startActivity(intent);
            }
        });
    }
}

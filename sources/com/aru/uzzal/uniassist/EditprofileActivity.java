package com.aru.uzzal.uniassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditprofileActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    Button delete;
    Button done;
    String email;
    String ename;
    String epass;
    String eusername;
    EditText mail;
    EditText name;
    EditText password;
    EditText username;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0457R.layout.activity_editprofile);
        this.databaseHelper = new DatabaseHelper(this);
        this.name = (EditText) findViewById(C0457R.C0459id.f54na);
        this.username = (EditText) findViewById(C0457R.C0459id.use);
        this.mail = (EditText) findViewById(C0457R.C0459id.f52em);
        this.password = (EditText) findViewById(C0457R.C0459id.pass);
        this.done = (Button) findViewById(C0457R.C0459id.edit);
        this.delete = (Button) findViewById(C0457R.C0459id.delete);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.ename = bundle.getString("name");
            this.eusername = bundle.getString("username");
            this.epass = bundle.getString("password");
            this.email = bundle.getString("mail");
            this.name.setText(this.ename);
            this.mail.setText(this.email);
            this.username.setText(this.eusername);
            this.password.setText(this.epass);
        }
        this.done.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String ename = EditprofileActivity.this.name.getText().toString();
                String eusername = EditprofileActivity.this.username.getText().toString();
                String epass = EditprofileActivity.this.password.getText().toString();
                if (Boolean.valueOf(EditprofileActivity.this.databaseHelper.UpdateData(ename, eusername, EditprofileActivity.this.mail.getText().toString(), epass)).booleanValue()) {
                    Toast.makeText(EditprofileActivity.this.getApplicationContext(), "Please, Login Again", 0).show();
                    EditprofileActivity.this.startActivity(new Intent(EditprofileActivity.this, SigninActivity.class));
                    return;
                }
                Toast.makeText(EditprofileActivity.this.getApplicationContext(), "Not Update", 1).show();
            }
        });
        this.delete.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                int DeleteData = EditprofileActivity.this.databaseHelper.DeleteData(EditprofileActivity.this.email);
                Toast.makeText(EditprofileActivity.this.getApplicationContext(), "Account Deleted", 1).show();
                EditprofileActivity.this.startActivity(new Intent(EditprofileActivity.this, SigninActivity.class));
            }
        });
    }
}

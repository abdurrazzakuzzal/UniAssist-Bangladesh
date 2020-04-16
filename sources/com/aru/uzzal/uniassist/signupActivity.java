package com.aru.uzzal.uniassist;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    Button signup;
    EditText temail;
    EditText tname;
    EditText tpassword;
    EditText tpassword2;
    EditText tusername;
    userDetails userDetails;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0457R.layout.activity_signup);
        this.userDetails = new userDetails();
        this.tname = (EditText) findViewById(C0457R.C0459id.name);
        this.tusername = (EditText) findViewById(C0457R.C0459id.username);
        this.temail = (EditText) findViewById(C0457R.C0459id.email);
        this.tpassword = (EditText) findViewById(C0457R.C0459id.password);
        this.tpassword2 = (EditText) findViewById(C0457R.C0459id.password2);
        this.signup = (Button) findViewById(C0457R.C0459id.signup);
        this.databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        this.signup.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String name = signupActivity.this.tname.getText().toString();
                String username = signupActivity.this.tusername.getText().toString();
                String email = signupActivity.this.temail.getText().toString();
                String password = signupActivity.this.tpassword.getText().toString();
                String password2 = signupActivity.this.tpassword2.getText().toString();
                signupActivity.this.temail.setError(null);
                signupActivity.this.tpassword.setError(null);
                if (TextUtils.isEmpty(name)) {
                    signupActivity.this.tname.setError(signupActivity.this.getString(C0457R.string.error_field_required));
                    View focusView = signupActivity.this.tname;
                }
                if (TextUtils.isEmpty(username)) {
                    signupActivity.this.tusername.setError(signupActivity.this.getString(C0457R.string.error_field_required));
                    View focusView2 = signupActivity.this.tusername;
                }
                if (!password.equals(password2)) {
                    signupActivity.this.tpassword2.setError(signupActivity.this.getString(C0457R.string.error_incorrect_password));
                    View focusView3 = signupActivity.this.tpassword2;
                }
                if (!TextUtils.isEmpty(password) || !signupActivity.this.isPasswordValid(password)) {
                    signupActivity.this.tpassword.setError(signupActivity.this.getString(C0457R.string.error_invalid_password));
                    View focusView4 = signupActivity.this.tpassword;
                }
                if (TextUtils.isEmpty(email)) {
                    signupActivity.this.temail.setError(signupActivity.this.getString(C0457R.string.error_field_required));
                    View focusView5 = signupActivity.this.temail;
                } else if (!signupActivity.this.isEmailValid(email)) {
                    signupActivity.this.temail.setError(signupActivity.this.getString(C0457R.string.error_invalid_email));
                    View focusView6 = signupActivity.this.temail;
                }
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || !signupActivity.this.isEmailValid(email) || !signupActivity.this.isPasswordValid(password)) {
                    Toast.makeText(signupActivity.this.getApplicationContext(), "Please, enter all information carefully", 0).show();
                    return;
                }
                signupActivity.this.userDetails.setName(name);
                signupActivity.this.userDetails.setUsername(username);
                signupActivity.this.userDetails.setEmail(email);
                signupActivity.this.userDetails.setPassword(password);
                if (signupActivity.this.databaseHelper.insertData(signupActivity.this.userDetails) > 0) {
                    Toast.makeText(signupActivity.this.getApplicationContext(), "Sign up Successful", 0).show();
                    signupActivity.this.tname.setText("");
                    signupActivity.this.temail.setText("");
                    signupActivity.this.tusername.setText("");
                    signupActivity.this.tpassword.setText("");
                    signupActivity.this.tpassword2.setText("");
                    return;
                }
                Toast.makeText(signupActivity.this.getApplicationContext(), "Sign up Failed", 0).show();
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean isEmailValid(String email) {
        return email.contains("@");
    }

    /* access modifiers changed from: private */
    public boolean isPasswordValid(String password) {
        return password.length() > 4;
    }
}

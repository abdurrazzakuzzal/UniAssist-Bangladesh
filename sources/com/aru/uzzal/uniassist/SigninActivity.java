package com.aru.uzzal.uniassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {
    public static final String Email = Email;
    DatabaseHelper databaseHelper;
    EditText email;
    Button login;
    EditText password;
    Button signup;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0457R.layout.activity_signin);
        this.databaseHelper = new DatabaseHelper(this);
        this.email = (EditText) findViewById(C0457R.C0459id.email);
        this.password = (EditText) findViewById(C0457R.C0459id.password);
        this.login = (Button) findViewById(C0457R.C0459id.login);
        this.signup = (Button) findViewById(C0457R.C0459id.signup);
        this.login.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String uemail = SigninActivity.this.email.getText().toString();
                String upassword = SigninActivity.this.password.getText().toString();
                SigninActivity.this.email.setError(null);
                SigninActivity.this.password.setError(null);
                if (!TextUtils.isEmpty(upassword) && !SigninActivity.this.isPasswordValid(upassword)) {
                    SigninActivity.this.password.setError(SigninActivity.this.getString(C0457R.string.error_invalid_password));
                    View focusView = SigninActivity.this.password;
                }
                if (TextUtils.isEmpty(uemail)) {
                    SigninActivity.this.email.setError(SigninActivity.this.getString(C0457R.string.error_field_required));
                    View focusView2 = SigninActivity.this.email;
                } else if (!SigninActivity.this.isEmailValid(uemail)) {
                    SigninActivity.this.email.setError(SigninActivity.this.getString(C0457R.string.error_invalid_email));
                    View focusView3 = SigninActivity.this.email;
                }
                if (SigninActivity.this.databaseHelper.findPassword(uemail, upassword).booleanValue()) {
                    Intent intent = new Intent(SigninActivity.this, ProfileActivity.class);
                    Bundle b = new Bundle();
                    b.putString("mail", uemail);
                    intent.putExtras(b);
                    SigninActivity.this.startActivity(intent);
                    return;
                }
                Toast.makeText(SigninActivity.this.getApplicationContext(), "Email and Password did not match", 0).show();
            }
        });
        this.signup.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                SigninActivity.this.startActivity(new Intent(SigninActivity.this, signupActivity.class));
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean isEmailValid(String email2) {
        return email2.contains("@");
    }

    /* access modifiers changed from: private */
    public boolean isPasswordValid(String password2) {
        return password2.length() > 4;
    }
}

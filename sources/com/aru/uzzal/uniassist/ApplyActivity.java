package com.aru.uzzal.uniassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ApplyActivity extends AppCompatActivity {
    Button apply;
    String fullname;
    EditText hboard;
    EditText hreg;
    EditText hroll;
    ApplyInfo info;
    MyDataBase myDataBase;
    EditText name;
    EditText sboard;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    EditText sreg;
    EditText sroll;
    TextView tone;
    TextView tthree;
    TextView ttwo;
    String[] uniname;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0457R.layout.activity_apply);
        this.myDataBase = new MyDataBase(this);
        this.info = new ApplyInfo();
        this.uniname = getResources().getStringArray(C0457R.array.universities);
        this.apply = (Button) findViewById(C0457R.C0459id.apply);
        this.name = (EditText) findViewById(C0457R.C0459id.fullname);
        this.sroll = (EditText) findViewById(C0457R.C0459id.sscroll);
        this.sreg = (EditText) findViewById(C0457R.C0459id.sscreg);
        this.sboard = (EditText) findViewById(C0457R.C0459id.sssboard);
        this.hroll = (EditText) findViewById(C0457R.C0459id.hscroll);
        this.hreg = (EditText) findViewById(C0457R.C0459id.hscreg);
        this.hboard = (EditText) findViewById(C0457R.C0459id.hscboard);
        this.spinner1 = (Spinner) findViewById(C0457R.C0459id.spinner);
        this.spinner2 = (Spinner) findViewById(C0457R.C0459id.spinner2);
        this.spinner3 = (Spinner) findViewById(C0457R.C0459id.spinner3);
        this.tone = (TextView) findViewById(C0457R.C0459id.one);
        this.ttwo = (TextView) findViewById(C0457R.C0459id.two);
        this.tthree = (TextView) findViewById(C0457R.C0459id.three);
        this.tone.setText((CharSequence) this.spinner1.getSelectedItem());
        this.ttwo.setText((CharSequence) this.spinner2.getSelectedItem());
        this.tthree.setText((CharSequence) this.spinner3.getSelectedItem());
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.fullname = bundle.getString("name");
        }
        this.name.setText(this.fullname);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, C0457R.layout.sample, C0457R.C0459id.textView15, this.uniname);
        this.spinner1.setAdapter(adapter);
        this.spinner2.setAdapter(adapter);
        this.spinner3.setAdapter(adapter);
        this.apply.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                int i;
                String fullname = ApplyActivity.this.name.getText().toString();
                String sscroll = ApplyActivity.this.sroll.getText().toString();
                String sscreg = ApplyActivity.this.sreg.getText().toString();
                String sscboard = ApplyActivity.this.sboard.getText().toString();
                String hscroll = ApplyActivity.this.hroll.getText().toString();
                String hscreg = ApplyActivity.this.hreg.getText().toString();
                String hscboard = ApplyActivity.this.hboard.getText().toString();
                String one = ApplyActivity.this.tone.getText().toString();
                String two = ApplyActivity.this.ttwo.getText().toString();
                String three = ApplyActivity.this.tthree.getText().toString();
                if (TextUtils.isEmpty(fullname) || TextUtils.isEmpty(sscroll) || TextUtils.isEmpty(sscreg) || TextUtils.isEmpty(sscboard) || TextUtils.isEmpty(hscroll) || TextUtils.isEmpty(hscreg)) {
                    String str = two;
                    String str2 = one;
                    String str3 = hscboard;
                    String str4 = hscreg;
                    String str5 = hscroll;
                    String str6 = sscroll;
                    i = 0;
                } else if (TextUtils.isEmpty(hscboard)) {
                    String str7 = three;
                    String str8 = two;
                    String str9 = one;
                    String str10 = hscboard;
                    String str11 = hscreg;
                    String str12 = hscroll;
                    String str13 = sscroll;
                    i = 0;
                } else {
                    ApplyActivity.this.info.setName(fullname);
                    ApplyActivity.this.info.setSscroll(sscroll);
                    ApplyActivity.this.info.setSscreg(sscreg);
                    ApplyActivity.this.info.setSscboard(sscboard);
                    ApplyActivity.this.info.setHscroll(hscroll);
                    ApplyActivity.this.info.setHscreg(hscreg);
                    ApplyActivity.this.info.setHscboard(hscboard);
                    ApplyActivity.this.info.setChoice1(one);
                    ApplyActivity.this.info.setChoice2(two);
                    ApplyActivity.this.info.setChoice3(three);
                    String str14 = sscroll;
                    String str15 = hscboard;
                    String str16 = hscreg;
                    String str17 = hscroll;
                    if (ApplyActivity.this.myDataBase.applyData(fullname, sscroll, sscreg, sscboard, hscroll, hscreg, hscboard, one, two, three) > 0) {
                        Toast.makeText(ApplyActivity.this.getApplicationContext(), "Sign up Successful", 0).show();
                        Intent intent = new Intent(ApplyActivity.this, AppliedActivity.class);
                        Bundle b = new Bundle();
                        b.putString("name", fullname);
                        intent.putExtras(b);
                        ApplyActivity.this.startActivity(intent);
                        return;
                    }
                    Toast.makeText(ApplyActivity.this.getApplicationContext(), "Sign up Failed", 0).show();
                    return;
                }
                Toast.makeText(ApplyActivity.this.getApplicationContext(), C0457R.string.error_field_required, i).show();
            }
        });
    }
}

package com.aru.uzzal.uniassist;

import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class uniprofileActivity extends AppCompatActivity {
    String aiub = "American International University-Bangladesh";
    String aust = "Ahsanullah University of Science and Technology";

    /* renamed from: bu */
    String f57bu = "Brac University";
    String bubt = "Bangladesh University of Business and Technology";
    TextView details;
    String diu = "Daffodil International University";
    String ewu = "East West University";
    String gub = "Green University of Bangladesh";
    ImageView imageView;
    ImageView imageView2;
    TextView textView;
    String uap = "University of Asia Pacific";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0457R.layout.activity_uniprofile);
        this.imageView = (ImageView) findViewById(C0457R.C0459id.unilogo);
        this.imageView2 = (ImageView) findViewById(C0457R.C0459id.fee);
        this.textView = (TextView) findViewById(C0457R.C0459id.uname);
        this.details = (TextView) findViewById(C0457R.C0459id.info);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            show(bundle.getString("name"));
        }
    }

    /* access modifiers changed from: 0000 */
    public void show(String uniname) {
        this.textView.setText(uniname);
        if (uniname.equals(this.uap)) {
            this.imageView.setImageResource(C0457R.C0458drawable.logouap);
            this.imageView2.setImageResource(C0457R.C0458drawable.uapfees);
        } else if (uniname.equals(this.aiub)) {
            this.imageView.setImageResource(C0457R.C0458drawable.logoaiub);
            this.imageView2.setImageResource(C0457R.C0458drawable.aiubfees);
        } else if (uniname.equals(this.bubt)) {
            this.imageView.setImageResource(C0457R.C0458drawable.logobubt);
            this.imageView2.setImageResource(C0457R.C0458drawable.bubtfees);
        } else if (uniname.equals(this.f57bu)) {
            this.imageView.setImageResource(C0457R.C0458drawable.logobracu);
            this.imageView2.setImageResource(C0457R.C0458drawable.bracufees);
        } else if (uniname.equals(this.diu)) {
            this.imageView.setImageResource(C0457R.C0458drawable.logodiu);
            this.imageView2.setImageResource(C0457R.C0458drawable.f44d1);
        } else if (uniname.equals(this.gub)) {
            this.imageView.setImageResource(C0457R.C0458drawable.logogreen);
            this.imageView2.setImageResource(C0457R.C0458drawable.gubfees);
        } else if (uniname.equals(this.ewu)) {
            this.imageView.setImageResource(C0457R.C0458drawable.logoewu);
            this.imageView2.setImageResource(C0457R.C0458drawable.ewufees);
        } else {
            this.imageView.setImageResource(C0457R.C0458drawable.logoaust);
            this.details.setText(C0457R.string.aust);
            this.imageView2.setImageResource(C0457R.C0458drawable.austfees);
        }
    }
}

package com.aru.uzzal.uniassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button about;
    Button international;
    Button login;
    Button universities;
    ViewFlipper v_flipper;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0457R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(C0457R.C0459id.actionbar);
        setSupportActionBar(toolbar);
        toolbar.setOverflowIcon(ContextCompat.getDrawable(getApplicationContext(), C0457R.C0458drawable.ic_menu));
        this.universities = (Button) findViewById(C0457R.C0459id.universities);
        this.international = (Button) findViewById(C0457R.C0459id.international);
        this.about = (Button) findViewById(C0457R.C0459id.about);
        this.login = (Button) findViewById(C0457R.C0459id.login);
        int[] images = {C0457R.C0458drawable.f49p1, C0457R.C0458drawable.f50p2, C0457R.C0458drawable.f51p3};
        this.v_flipper = (ViewFlipper) findViewById(C0457R.C0459id.v_flipper);
        for (int image : images) {
            flipperimage(image);
        }
        this.universities.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, universitylistActivity.class));
            }
        });
        this.international.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, internationalActivity.class));
            }
        });
        this.about.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, aboutActivity.class));
            }
        });
        this.login.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, SigninActivity.class));
            }
        });
    }

    public void flipperimage(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        this.v_flipper.addView(imageView);
        this.v_flipper.setFlipInterval(4000);
        this.v_flipper.setAutoStart(true);
        this.v_flipper.setInAnimation(this, 17432578);
        this.v_flipper.setOutAnimation(this, 17432579);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0457R.C0460menu.navidrawer, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == C0457R.C0459id.universities) {
            startActivity(new Intent(this, universitylistActivity.class));
        } else if (item.getItemId() == C0457R.C0459id.international) {
            startActivity(new Intent(this, internationalActivity.class));
        } else if (item.getItemId() == C0457R.C0459id.about) {
            startActivity(new Intent(this, aboutActivity.class));
        } else if (item.getItemId() == C0457R.C0459id.home) {
            startActivity(new Intent(this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}

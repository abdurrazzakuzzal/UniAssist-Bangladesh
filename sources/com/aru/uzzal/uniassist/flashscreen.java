package com.aru.uzzal.uniassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;

public class flashscreen extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) C0457R.layout.activity_flashscreen);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flashscreen.this.startActivity(new Intent(flashscreen.this, MainActivity.class));
                flashscreen.this.finish();
            }
        }).start();
    }
}

package com.aru.uzzal.uniassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class universitylistActivity extends AppCompatActivity {
    private int[] flags = {C0457R.C0458drawable.logoaust, C0457R.C0458drawable.logoaiub, C0457R.C0458drawable.logobubt, C0457R.C0458drawable.logobracu, C0457R.C0458drawable.logodiu, C0457R.C0458drawable.logoewu, C0457R.C0458drawable.logogreen, C0457R.C0458drawable.logouap};
    private ListView listView;
    /* access modifiers changed from: private */
    public String[] uniname;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0457R.layout.activity_universitylist);
        Toolbar toolbar = (Toolbar) findViewById(C0457R.C0459id.actionbar);
        setSupportActionBar(toolbar);
        toolbar.setOverflowIcon(ContextCompat.getDrawable(getApplicationContext(), C0457R.C0458drawable.ic_menu));
        this.listView = (ListView) findViewById(C0457R.C0459id.listid);
        this.uniname = getResources().getStringArray(C0457R.array.universities);
        this.listView.setAdapter(new CustomAdapter(this, this.uniname, this.flags));
        this.listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = universitylistActivity.this.uniname[i];
                Intent intent = new Intent(universitylistActivity.this, uniprofileActivity.class);
                intent.putExtra("name", value);
                universitylistActivity.this.startActivity(intent);
            }
        });
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

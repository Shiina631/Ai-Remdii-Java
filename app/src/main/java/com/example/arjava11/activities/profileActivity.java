package com.example.arjava11.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.arjava11.R;


public class profileActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageButton drawerLayout = (ImageButton) findViewById(R.id.ivNavMenu);
        TextView btn_home=(TextView) findViewById(R.id.homeBtn);
        TextView btn_treatment=(TextView) findViewById(R.id.treatmentBtn);
        TextView btn_setting=(TextView) findViewById(R.id.settingBtn);
        TextView btn_logout=(TextView) findViewById(R.id.logoutBtn);

        btn_home.setOnClickListener(this);
        btn_treatment.setOnClickListener(this);
        btn_setting.setOnClickListener(this);
        btn_logout.setOnClickListener(this);

        drawerLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.homeBtn:
                Intent intent=new Intent( profileActivity.this,mainPageActivity.class);
                startActivity(intent);
                break;
            case R.id.treatmentBtn:
                Intent intent2=new Intent( profileActivity.this,treatmentActivity.class);
                startActivity(intent2);
                break;
            case R.id.settingBtn:
                Intent intent3=new Intent( profileActivity.this,settingActivity.class);
                startActivity(intent3);
                break;
            case R.id.logoutBtn:
                Intent intent4=new Intent( profileActivity.this,MainActivity.class);
                startActivity(intent4);
                break;
            case R.id.ivNavMenu:
                toggleLeftDrawer();
                break;
            default:
                break;

        }

    }

    private void toggleLeftDrawer() {
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        }else{
            mDrawerLayout.openDrawer(Gravity.LEFT);
        }
    }


}
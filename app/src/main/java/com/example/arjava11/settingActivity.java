package com.example.arjava11;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class settingActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ImageButton drawerLayout = (ImageButton) findViewById(R.id.ivNavMenu);
        TextView btn_home=(TextView) findViewById(R.id.homeBtn);
        TextView btn_treatment=(TextView) findViewById(R.id.treatmentBtn);
        TextView btn_profile=(TextView) findViewById(R.id.profileBtn);
        TextView btn_logout=(TextView) findViewById(R.id.logoutBtn);

        btn_home.setOnClickListener(this);
        btn_treatment.setOnClickListener(this);
        btn_profile.setOnClickListener(this);
        btn_logout.setOnClickListener(this);

        drawerLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.homeBtn:
                Intent intent=new Intent( settingActivity.this,mainPageActivity.class);
                startActivity(intent);
                break;
            case R.id.treatmentBtn:
                Intent intent2=new Intent( settingActivity.this,treatmentActivity.class);
                startActivity(intent2);
                break;
            case R.id.profileBtn:
                Intent intent3=new Intent( settingActivity.this,profileActivity.class);
                startActivity(intent3);
                break;
            case R.id.logoutBtn:
                Intent intent4=new Intent( settingActivity.this,MainActivity.class);
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
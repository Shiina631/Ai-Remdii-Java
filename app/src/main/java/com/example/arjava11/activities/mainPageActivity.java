package com.example.arjava11.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.arjava11.R;


public class mainPageActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        ImageButton drawerLayout = (ImageButton) findViewById(R.id.ivNavMenu);
        Button btn_takePhoto=(Button) findViewById(R.id.takePhotoBtn);
        TextView btn_treatment=(TextView) findViewById(R.id.treatmentBtn);
        TextView btn_profile=(TextView) findViewById(R.id.profileBtn);
        TextView btn_setting=(TextView) findViewById(R.id.settingBtn);
        TextView btn_logout=(TextView) findViewById(R.id.logoutBtn);

        btn_treatment.setOnClickListener(this);
        btn_profile.setOnClickListener(this);
        btn_setting.setOnClickListener(this);
        btn_logout.setOnClickListener(this);

        drawerLayout.setOnClickListener(this);

        /*val btn_treatment = findViewById<TextView>(R.id.treatmentBtn)
                btn_treatment.setOnClickListener {
            val intent = Intent(this, treatmentActivity::class.java)
            startActivity(intent)
        }

        val btn_profile = findViewById<TextView>(R.id.profileBtn)
                btn_profile.setOnClickListener {
            val intent = Intent(this, profileActivity::class.java)
            startActivity(intent)
        }

        val btn_setting = findViewById<TextView>(R.id.settingBtn)
                btn_setting.setOnClickListener {
            val intent = Intent(this, settingActivity::class.java)
            startActivity(intent)
        }

        val btn_logout = findViewById<TextView>(R.id.logoutBtn)
                btn_logout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }*/
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.treatmentBtn:
                Intent intent=new Intent( mainPageActivity.this,treatmentActivity.class);
                startActivity(intent);
                break;
            case R.id.profileBtn:
                Intent intent2=new Intent( mainPageActivity.this,profileActivity.class);
                startActivity(intent2);
                break;
            case R.id.settingBtn:
                Intent intent3=new Intent( mainPageActivity.this,settingActivity.class);
                startActivity(intent3);
                break;
            case R.id.logoutBtn:
                Intent intent4=new Intent( mainPageActivity.this,MainActivity.class);
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



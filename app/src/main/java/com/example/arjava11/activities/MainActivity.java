package com.example.arjava11.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.arjava11.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_register= findViewById(R.id.registerBtn);
        Button btn_loginAcc= findViewById(R.id.loginBtn);
        Button btn_freeTrial= findViewById(R.id.freeTrialBtn);

        btn_register.setOnClickListener(this);
        btn_loginAcc.setOnClickListener(this);
        btn_freeTrial.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.registerBtn:
                Intent intent=new Intent( MainActivity.this,registerActivity.class);
                startActivity(intent);
                break;
            case R.id.loginBtn:
                Intent intent2=new Intent( MainActivity.this,loginActivity.class);
                startActivity(intent2);
                break;
            case R.id.freeTrialBtn:
                Intent intent3=new Intent( MainActivity.this,surveyActivity.class);
                startActivity(intent3);
                break;
            default:
                break;

        }
    }

}
package com.example.arjava11;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class loginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn_register=(Button) findViewById(R.id.registerBtn);
        Button btn_loginAcc=(Button) findViewById(R.id.loginAccBtn);
        ImageButton btn_back=(ImageButton) findViewById(R.id.backBtn);

        btn_register.setOnClickListener(this);
        btn_loginAcc.setOnClickListener(this);
        btn_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.registerBtn:
                Intent intent=new Intent( loginActivity.this,registerActivity.class);
                startActivity(intent);
                break;
            case R.id.loginAccBtn:
                Intent intent2=new Intent( loginActivity.this,fullSurveyActivity.class);
                startActivity(intent2);
                break;
            case R.id.backBtn:
                finish();
                break;
            default:
                break;

        }
    }
}
package com.example.arjava11;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class fullSurveyActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_survey);

        Button btn_mainPage=(Button) findViewById(R.id.userMainPageBtn);
        ImageButton btn_back=(ImageButton) findViewById(R.id.backBtn6);

        btn_mainPage.setOnClickListener(this);
        btn_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.userMainPageBtn:
                Intent intent=new Intent( fullSurveyActivity.this,mainPageActivity.class);
                startActivity(intent);
                break;
            case R.id.backBtn6:
                finish();
                break;
            default:
                break;

        }
    }
}
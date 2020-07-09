package com.example.arjava11.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.arjava11.R;


public class surveyActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        Button btn_bodyPartSelect=(Button) findViewById(R.id.bodyPartSelectBtn);
        ImageButton btn_back=(ImageButton) findViewById(R.id.backBtn3);

        btn_bodyPartSelect.setOnClickListener(this);
        btn_back.setOnClickListener(this);

//        btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//
//        btn_bodyPartSelect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent( surveyActivity.this,bodyPartSelectActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bodyPartSelectBtn:
                Intent intent=new Intent( surveyActivity.this,bodyPartSelectActivity.class);
                startActivity(intent);
                break;
            case R.id.backBtn3:
                finish();
                break;
            default:
                break;

        }
    }
}
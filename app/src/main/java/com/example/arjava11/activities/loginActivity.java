package com.example.arjava11.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.arjava11.api.RetrofitClient;
import com.example.arjava11.model.LoginResponse;
import com.example.arjava11.storage.sharedPrefManager;

import com.example.arjava11.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class loginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextEmail,editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn_register=(Button) findViewById(R.id.registerBtn);
        Button btn_loginAcc=(Button) findViewById(R.id.loginAccBtn);
        ImageButton btn_back=(ImageButton) findViewById(R.id.backBtn);

        //login
        editTextEmail = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);

        btn_register.setOnClickListener(this);
        btn_loginAcc.setOnClickListener(this);
        btn_back.setOnClickListener(this);

    }

    //check everytime open an app if already log in will keep log in
    @Override
    protected void onStart() {
        super.onStart();
        if(sharedPrefManager.getInstance(this).isLoggedIn())
        {
            Intent intent = new Intent(this,mainPageActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void userLogin()
    {
        String email = editTextEmail.getText().toString().trim();
        String pass = editTextPassword.getText().toString().trim();


        if(email.isEmpty())
        {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        //check valid email pattern
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if(pass.isEmpty())
        {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        if(pass.length() < 6)
        {
            editTextPassword.setError("Password should be at least 6 character long");
            editTextPassword.requestFocus();
            return;
        }

        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .userLogin(email,pass);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if(!loginResponse.isError())
                {
                    //proceed with login
                    //safe user using shared preferences
                    //open profile
                    sharedPrefManager.getInstance(loginActivity.this)
                            .saveUser(loginResponse.getUser());
                    //close all the activities so when click back wont back to login

                    Intent intent = new Intent(loginActivity.this,mainPageActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(loginActivity.this,loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.registerBtn:
                Intent intent=new Intent( loginActivity.this,registerActivity.class);
                startActivity(intent);
                break;
            case R.id.loginAccBtn:
                userLogin();
                break;
            case R.id.backBtn:
                finish();
                break;
            default:
                break;

        }
    }
}
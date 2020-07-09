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
import com.example.arjava11.R;
import com.example.arjava11.model.DefaultResponse;
import com.example.arjava11.storage.sharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class registerActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextEmailAddress, editTextAge, editTextUserName, editTextPassword,editTextRepeatedPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btn_register=(Button) findViewById(R.id.registerBtn);
        Button btn_loginBtn=(Button) findViewById(R.id.loginBtn);
        ImageButton btn_back=(ImageButton) findViewById(R.id.backBtn2);



        //register
        editTextEmailAddress = findViewById(R.id.editTextEmailAddress);
        editTextAge = findViewById(R.id.editTextAge);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextRepeatedPassword = findViewById(R.id.editTextRepeatedPassword);

        btn_register.setOnClickListener(this);
        btn_loginBtn.setOnClickListener(this);
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
    private void userRegister() {
        String emailAddress = editTextEmailAddress.getText().toString().trim();
        Integer age = Integer.parseInt(editTextAge.getText().toString());
        String username = editTextUserName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String repeatedPassword = editTextRepeatedPassword.getText().toString().trim();

        String profileStatus= "register";

        if(emailAddress.isEmpty())
        {
            editTextEmailAddress.setError("Email is required");
            editTextEmailAddress.requestFocus();
            return;
        }

        //check valid email pattern
        if(!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches())
        {
            editTextEmailAddress.setError("Enter a valid email");
            editTextEmailAddress.requestFocus();
            return;
        }

        if(password.isEmpty())
        {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length() < 6)
        {
            editTextPassword.setError("Password should be at least 6 character long");
            editTextPassword.requestFocus();
            return;
        }

        if(repeatedPassword.isEmpty())
        {
            editTextRepeatedPassword.setError("Repeated Password is required");
            editTextRepeatedPassword.requestFocus();
            return;
        }

        if(!repeatedPassword.equals(password))
        {
            editTextRepeatedPassword.setError("Repeated Password should be same wif password");
            editTextRepeatedPassword.requestFocus();
            return;
        }

        if(username.isEmpty())
        {
            editTextUserName.setError("name is required");
            editTextUserName.requestFocus();
            return;
        }

        Toast.makeText(getApplicationContext(),"Test for error message",Toast.LENGTH_SHORT).show();

        //creatring user right here
        Call<DefaultResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .createUser(username, emailAddress, age, password, profileStatus);

        // do user registeration in the api call
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {

                if(response.code() == 201)
                {
                    DefaultResponse dr =response.body();
                    Toast.makeText(registerActivity.this, dr.getMsg(), Toast.LENGTH_LONG).show();
                }
                else if(response.code() == 422)//exist
                {
                    Toast.makeText(registerActivity.this, "User exist", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(registerActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.registerBtn:
                userRegister();
                break;
            case R.id.loginBtn:
                Intent intent2=new Intent( registerActivity.this,loginActivity.class);
                startActivity(intent2);
                break;
            case R.id.backBtn2:
                finish();
                break;
            default:
                break;

        }
    }


}
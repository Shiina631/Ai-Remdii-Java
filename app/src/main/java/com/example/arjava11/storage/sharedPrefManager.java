package com.example.arjava11.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.arjava11.model.User;

public class sharedPrefManager {

    private static  final String SHARED_PREF_NAME = "my_shared_preff";

    private static sharedPrefManager mInstance;
    private Context mCtx;

    private sharedPrefManager(Context mCtx)
    {
        this.mCtx = mCtx;

    }

    //synchronized for single instance only which = 1 user login to this app per time
    public static synchronized sharedPrefManager getInstance(Context mCtx)
    {
        if(mInstance == null)
        {
            mInstance = new sharedPrefManager(mCtx);
        }
        return mInstance;
    }

    public void saveUser(User user)
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("id",user.getId());
        editor.putString("name",user.getName());
        editor.putString("email",user.getEmail());
        editor.putInt("age",user.getAge());
        editor.putString("profileStatus",user.getProfileStatus());

        editor.apply();
    }

    //check whether user is already login and keep him login
    public boolean isLoggedIn()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id",-1)!= -1; //mysql id auto gen cant be more than -1 or is -1 start from 1 de
    }

    public User getUser()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt("id",-1),
                sharedPreferences.getString("name",null),
                sharedPreferences.getString("email",null),
                sharedPreferences.getInt("age",-1),
                sharedPreferences.getString("profileStatus",null)

        );

    }
    //for logout
    public void clear()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}

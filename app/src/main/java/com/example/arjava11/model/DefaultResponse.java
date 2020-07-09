package com.example.arjava11.model;

import com.google.gson.annotations.SerializedName;

public class DefaultResponse {

    @SerializedName("error")//if dw same name
    private boolean err;// can keep the name same as json name

    @SerializedName("message")
    private String msg;

    public DefaultResponse(boolean err, String msg)
    {
        this.err = err;
        this.msg = msg;

    }

    public boolean isErr()
    {
        return err;
    }

    public String getMsg()
    {
        return msg;
    }

}

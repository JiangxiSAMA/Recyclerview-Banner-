package com.example.jiangxi.nigthwork.model;

public interface IModel {
    interface OnRequestListener{
       void onSuccess(String s);
       void onError();

    }


    void requestNetData(String url,OnRequestListener listener);
}

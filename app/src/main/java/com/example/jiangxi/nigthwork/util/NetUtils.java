package com.example.jiangxi.nigthwork.util;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class NetUtils {
    public static OkHttpClient client = null;
    public static synchronized OkHttpClient getClient(){

        if (client==null){
            client = new OkHttpClient();


        }

        return client;
    }






    public static void doGet(String url, Callback callback){

        Request request = new Request.Builder()
                .url(url)
                .build();
        getClient().newCall(request).enqueue(callback);




    }


}

package com.example.jiangxi.nigthwork.model;

import com.example.jiangxi.nigthwork.util.NetUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class GoodsModel implements IModel {




    @Override
    public void requestNetData(String url, final OnRequestListener listener) {
        NetUtils.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                listener.onSuccess(response.body().string());

            }
        });

    }
}

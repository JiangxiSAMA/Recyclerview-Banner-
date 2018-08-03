package com.example.jiangxi.nigthwork.presenter;

import android.os.Handler;
import android.os.Message;

import com.example.jiangxi.nigthwork.bean.GoodsBean;
import com.example.jiangxi.nigthwork.model.GoodsModel;
import com.example.jiangxi.nigthwork.model.IModel;
import com.example.jiangxi.nigthwork.view.IView;
import com.google.gson.Gson;

import java.util.List;

public class PresenterImp implements IPresenter {
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1){
                iView.getNetData((List<GoodsBean.DataBean>) msg.obj);

            }

        }
    };


    private IModel model;
    private IView iView;

    public PresenterImp( IView iView) {
        this.model = new GoodsModel();
        this.iView = iView;
    }

    @Override
    public void takeData(String url) {


        model.requestNetData(url, new IModel.OnRequestListener() {
            @Override
            public void onSuccess(String s) {

                Gson gson = new Gson();
                GoodsBean goodsBean = gson.fromJson(s, GoodsBean.class);
                List<GoodsBean.DataBean> data = goodsBean.getData();
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = data;
                handler.sendMessage(obtain);


            }

            @Override
            public void onError() {

            }
        });








    }
}

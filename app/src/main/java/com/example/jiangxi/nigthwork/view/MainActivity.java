package com.example.jiangxi.nigthwork.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.jiangxi.nigthwork.R;
import com.example.jiangxi.nigthwork.adapter.MyAdapter;
import com.example.jiangxi.nigthwork.bean.GoodsBean;
import com.example.jiangxi.nigthwork.presenter.IPresenter;
import com.example.jiangxi.nigthwork.presenter.PresenterImp;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.xrv)
    XRecyclerView xrv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        IPresenter presenter = new PresenterImp(this);
        String url = "http://www.zhaoapi.cn/product/searchProducts?keywords=%E6%89%8B%E6%9C%BA&page=1&sort=0";
        presenter.takeData(url);


    }

    @Override
    public void getNetData(List<GoodsBean.DataBean> list) {
        xrv.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        MyAdapter adapter = new MyAdapter(MainActivity.this,list);
        xrv.setAdapter(adapter);



    }
}

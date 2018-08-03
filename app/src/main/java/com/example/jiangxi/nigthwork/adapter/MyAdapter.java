package com.example.jiangxi.nigthwork.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jiangxi.nigthwork.R;
import com.example.jiangxi.nigthwork.bean.GoodsBean;

import com.example.jiangxi.nigthwork.util.MyBanner;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter{
    private String url1 = "http://d.5857.com/wmgf_160811/001.jpg";
    private String url2 = "http://d.5857.com/wmgf_160811/002.jpg";
    private String url3 = "http://d.5857.com/wmgf_160811/003.jpg";

    List<String> list1 = new ArrayList<>();








    

    public static final int TYPE_ONE = 0;
    public static final int TYPE_TWO = 1;
    public static final int TYPE_THREE = 2;
    public static final int TYPE_FOUR = 3;


    private Context context;
    private List<GoodsBean.DataBean> list;


    public MyAdapter(Context context, List<GoodsBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_ONE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
            return new ViewHolder(view);
        } else if (viewType == TYPE_TWO) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, null);
            return new TypeTwoHolder(view);
        }else if (viewType == TYPE_THREE){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item3,null);
            return new TypeThreeHolder(view);
        }else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item4,null);
            return new TypeFourHolder(view);

        }

    }





    @Override
    public int getItemViewType(int position) {
        if (position%2 == 0 && position !=0){
            return TYPE_FOUR;
        }else if (position%2  == 1 && position != 1){
            return TYPE_THREE;
        }else if (position == 0){
            return TYPE_ONE;
        }else if (position == 1){
            return TYPE_TWO;
        }


        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case TYPE_ONE:
                ViewHolder holder1 = (ViewHolder) holder;
//                Glide.with(context).load(list.get(position).getImages().split("\\|")[0]).into(holder1.iv1);
//                Glide.with(context).load(list.get(position).getImages().split("\\|")[0]).into(holder1.iv2);
//                Glide.with(context).load(list.get(position).getImages().split("\\|")[0]).into(holder1.iv3);

                ((ViewHolder) holder).iv1.setImageURI(list.get(position).getImages().split("\\|")[0]);
                ((ViewHolder) holder).iv2.setImageURI(list.get(position).getImages().split("\\|")[1]);
                ((ViewHolder) holder).iv3.setImageURI(list.get(position).getImages().split("\\|")[2]);

                break;

            case TYPE_TWO:
                TypeTwoHolder holder2 = (TypeTwoHolder) holder;
                list1.add(url1);
                list1.add(url2);
                list1.add(url3);
                holder2.banner.setImageLoader(new MyBanner());
                holder2.banner.setImages(list1);
                holder2.banner.start();
                break;

            case TYPE_THREE:
                TypeThreeHolder holder3 = (TypeThreeHolder) holder;
//                Glide.with(context).load(list.get(position).getImages().split("\\|")[0]).into(holder3.it3Iv1);
//                Glide.with(context).load(list.get(position).getImages().split("\\|")[0]).into(holder3.it3Iv2);
                holder3.it3Iv1.setImageURI(list.get(position).getImages().split("\\|")[2]);
                holder3.it3Iv2.setImageURI(list.get(position).getImages().split("\\|")[2]);

                holder3.it3Tv1.setText(list.get(position).getTitle());
                break;
            case TYPE_FOUR:
                TypeFourHolder holder4 = (TypeFourHolder) holder;
                Glide.with(context).load(list.get(position).getImages().split("\\|")[2]).into(holder4.it4Iv1);
                holder4.it4Tv.setText(list.get(position).getTitle());
                break;



        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       SimpleDraweeView iv1;
       SimpleDraweeView iv2;
       SimpleDraweeView iv3;

        public ViewHolder(View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.iv1);
            iv2 = itemView.findViewById(R.id.iv2);
            iv3 = itemView.findViewById(R.id.iv3);
        }
    }


    class TypeTwoHolder extends RecyclerView.ViewHolder {
        Banner banner;


        public TypeTwoHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    class TypeThreeHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView it3Iv1 ;
        TextView it3Tv1;
        SimpleDraweeView it3Iv2;

        public TypeThreeHolder(View itemView) {
            super(itemView);
            it3Iv1 = itemView.findViewById(R.id.item3_iv1);
            it3Iv2 = itemView.findViewById(R.id.item3_iv2);
            it3Tv1 = itemView.findViewById(R.id.item3_tv1);


        }
    }

    class TypeFourHolder extends RecyclerView.ViewHolder {
        ImageView it4Iv1;
        TextView it4Tv;


        public TypeFourHolder(View itemView) {
            super(itemView);
            it4Iv1 = itemView.findViewById(R.id.item4_iv1);
            it4Tv = itemView.findViewById(R.id.item4_tv);

        }
    }


}

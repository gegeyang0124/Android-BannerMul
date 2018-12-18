package com.zy.bannermul;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class BannerMul extends LinearLayout {

//    private int mode = BannerModel.mode;//当前UI模式，默认是1
    private List<BannerModel> dataList;

    public BannerMul(@NonNull Context context)
    {
        super(context);
        init(context,null,0);
    }

    public BannerMul(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init(context,attrs,0);

    }

    public BannerMul(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context,attrs,defStyleAttr);
    }

    /**
     * //@RequiresApi
     * **/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BannerMul(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs,defStyleAttr);
    }

    private void init(Context context,AttributeSet attrs,int defStyle){
        if(true){
            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs, R.styleable.BannerMul, defStyle, 0);

            BannerModel.mode = a.getInt(R.styleable.BannerMul_mode,BannerModel.mode);

            /*for (int i = 0; i < a.getIndexCount(); i++){
                int attr = a.getIndex(i);
                switch (attr){
                    case R.styleable.BannerMul_mode:
                    {
                        mode = a.getInt(attr,1);
                    }
                }
            }*/

            a.recycle();
        }
    }

    public void setDataList(List<BannerModel> dataList){
        setDataList(dataList,BannerModel.mode);
    }

    public void setDataList(List<BannerModel> dataList,int mode){
        this.removeAllViews();

        BannerModel.mode = mode;
        if (dataList == null || dataList.size() == 0){
            return;
        }

        LinearLayout.LayoutParams vp_param = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT,BannerModel.screenPercent1);
        vp_param.gravity = Gravity.CENTER;
        LinearLayout linearLayout1 = new LinearLayout(getContext());
        linearLayout1.setLayoutParams(vp_param);
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams vp_param0 = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT,BannerModel.screenPercent1);
        vp_param0.gravity = Gravity.CENTER;
        Banner banner1 = new Banner(getContext());
        banner1.setLayoutParams(vp_param0);

        BannerModel bannerModel1 = dataList.get(0);
        bannerModel1.banner = banner1;

        linearLayout1.addView(banner1);

        this.addView(linearLayout1);

        if(BannerModel.mode > BannerModel.MONE_ONE){

            vp_param.bottomMargin = 5;

            LinearLayout.LayoutParams vp_param2 = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT,BannerModel.SCREEN_PERCENT - BannerModel.screenPercent1);
            vp_param2.gravity = Gravity.CENTER;
            vp_param2.topMargin = 5;
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setLayoutParams(vp_param2);
            linearLayout2.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout.LayoutParams vp_param3 = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT,BannerModel.screenPercent2);
            Banner banner2 = new Banner(getContext());
            banner2.setLayoutParams(vp_param3);

            BannerModel bannerModel2 = dataList.get(1);
            bannerModel2.banner = banner2;

            linearLayout2.addView(banner2);

            if(BannerModel.mode == BannerModel.MONE_THREE){
                LinearLayout.LayoutParams vp_param4 = new LinearLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.MATCH_PARENT,BannerModel.SCREEN_PERCENT - BannerModel.screenPercent2);
                vp_param4.leftMargin = 10;
                Banner banner3 = new Banner(getContext());
                banner3.setLayoutParams(vp_param4);

                BannerModel bannerModel3 = dataList.get(2);
                bannerModel3.banner = banner3;

                linearLayout2.addView(banner3);
            }

            this.addView(linearLayout2);
        }

        this.dataList = dataList;
        startBanner();
    }

    private void startBanner(){
        for(int i = 0; i < this.dataList.size()
                && i < BannerModel.mode; i++){
            BannerModel bannerModel = this.dataList.get(i);
            if(bannerModel.banner != null){
                bannerModel.banner.setDataList(bannerModel.list,bannerModel.index);
                //bannerModel.banner.setImgDelyed(bannerModel.imgDelyed);
                bannerModel.banner.startBanner();
                bannerModel.banner.startAutoPlay();
            }
        }
    }

    public void destroy(){
        for(int i = 0; i < this.dataList.size() && i < BannerModel.mode; i++){
            BannerModel bannerModel = this.dataList.get(i);
            if(bannerModel.banner != null){
                bannerModel.banner.destroy();
            }
        }
    }


    public class Inner {
        public String ss ="s1";

        private Inner(){

        }

    }
}

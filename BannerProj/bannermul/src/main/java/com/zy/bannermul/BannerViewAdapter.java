package com.zy.bannermul;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steven on 2018/5/14.
 */
public class BannerViewAdapter extends PagerAdapter
{
    private List<View> listBean;

    public BannerViewAdapter(List<View> list,Context context){
        if (list == null){
            list = new ArrayList<>();
        }

        setDataList(list,context);
//        this.listBean = list;
    }

    public void setDataList(List<View> list,Context context){
        if (list != null && list.size() > 0){
            this.listBean = list;
            this.listBean = new ArrayList<>();
            for(int i = 0; i < list.size(); i++){
                View view = list.get(i);
                /**
                 * LinearLayout有两个非常相似的属性：android:gravity与android:layout_gravity。
                 * 他们的区别在于：android:gravity用于设置View组件的对齐方式，
                 * 而android:layout_gravity用于设置Container组件的对齐方式。
                 * View view = list.get(i);
                 * 举个例子，我们可以通过设置android:gravity="center"来让view中的内容在view组件中居中显示；
                 * 同时我们设置view的android:layout_gravity="right"来让view组件在LinearLayout中居中显示。
                 * **/
                LinearLayout linearLayout = new LinearLayout(context);
                //设置LinearLayout属性(宽和高)
                LinearLayout.LayoutParams layoutParams = new LinearLayout
                        .LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                //layoutParams.gravity = Gravity.CENTER_VERTICAL;//android:gravity用于设置View组件的对齐方式，
                linearLayout.setGravity(Gravity.CENTER);//用于设置，android:layout_gravity用于设置Container组件的对齐方式
                linearLayout.setLayoutParams(layoutParams);
                //linearLayout.setBackgroundColor(Color.BLUE);
                linearLayout.addView(view);
                this.listBean.add(linearLayout);
            };
        }
    }

    //目的是展示title上的文字，
   /* @Override
    public CharSequence getPageTitle(int position) {
        return mainTitlesArray[position];
    }*/

    //数量
    @Override
    public int getCount()
    {
        return listBean.size();
    }

    //判断是否是否为同一张图片（ui），这里返回方法中的两个参数做比较就可以
    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view == object;
    }

    //设置viewpage内部东西的方法，如果viewpage内没有子控件 滑动产生不了动画效果
    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        View view = listBean.get(position);
        container.addView(view);
        return view;
    }

    //因为它默认是看三张图片，第四张图片的时候就会报错，还有就是不要返回父类的作用
    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView((View) object);
    }

    //刷新ViewPager时缓存页面默认是不会刷新的， 只有将PagerAdapter的getItemPosition方法,
    // 返回值改为POSITION_NONE时才会刷新， 但是如果都改为POSITION_NONE的话，那开销有点大
    @Override
    public int getItemPosition(Object object)
    {
        return POSITION_NONE;
    }

}
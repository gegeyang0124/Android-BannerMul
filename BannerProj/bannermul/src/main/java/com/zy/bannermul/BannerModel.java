package com.zy.bannermul;

import android.content.Context;
import android.support.annotation.Nullable;

import com.danikula.videocache.HttpProxyCacheServer;

import java.util.List;

public class BannerModel {

    public static HttpProxyCacheServer proxy;//缓存对象

    public static final int MONE_ONE = 1;//轮播模式1
    public static final int MONE_TWO = 2;//轮播模式2
    public static final int MONE_THREE = 3;//轮播模式3

    public static final float SCREEN_PERCENT = 10;//屏幕总的权重百分比
    public static float screenPercent1 = 5;//屏幕一占屏幕的大小（大于1屏有效）
    public static float screenPercent2 = 5;//屏幕二占屏幕的大小（大于2屏有效）

    public static String isChange = null;//返回数据的指纹。即当数据没有变化的时候不会发生变化，可以帮助前端快速判断数据是否发生变化

    public static String UNIQUE_ID = null;//设备ID
    public static String CodeAuth = null;//授权码
    public static String CodeDevice = null;//后台的设备编码
    public static int mode = 1;//当前轮播模式

    //public List<String> list;//当前轮播列表
    public List<BannerPage> list;//当前轮播列表
    public int imgDelyed = 1000;//图片轮播延时时间
    public Banner banner = null;//轮播UI
    public int index = -1;//当前插播地址

    /**
     * 屏幕一，占屏幕的大小（大于1屏有效） 必传
     * @param screenPer float;//0~1的浮点数
     * **/
    public static void  setScreenPercent1(float screenPer){
        screenPercent1 = SCREEN_PERCENT - screenPer * SCREEN_PERCENT;
    }

    /**
     * 屏幕二，占屏幕的大小（大于2屏有效） 必传
     * @param screenPer float;//0~1的浮点数
     * **/
    public static void  setScreenPercent2(float screenPer){
        screenPercent2 = SCREEN_PERCENT - screenPer * SCREEN_PERCENT;
    }

    /**
     * 创建缓存对象
     * @param context Context;//上下文对象
     * **/
    public static HttpProxyCacheServer newProxy(Context context) {
        if(proxy == null){
            proxy = new HttpProxyCacheServer.Builder(context)
                    .fileNameGenerator(new MyFileNameGenerator())
                    .build();
        }

        return proxy;
    }

    /**
     * 创建音视频缓存，返回路径
     * @param url String;//音视频地址
     * **/
    public static String getProxyUrl(String url) {
        return getProxyUrl(null,url);
    }
    /**
     * 创建音视频缓存，返回路径
     * @param context Context;//上下文对象
     * @param url String;//音视频地址
     * **/
    public static String getProxyUrl(@Nullable Context context, String url) {
        if(context != null)
        {
            newProxy(context);
        }

        if(proxy != null){
            return  proxy.getProxyUrl(url);
        }

        return url;
    }
}

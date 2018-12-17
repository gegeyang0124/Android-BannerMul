package com.zy.bannermul;

public class BannerPage {
    public String url;//图片/视频地址
    public int imgDelyed = 2000;//图片轮播延时时间

    public BannerPage(){}

    /**
     * 构造函数
     * @param url String;//图片/视频地址
     * **/
    public BannerPage(String url)
    {
        this.url = url;
    }

    /**
     * 构造函数
     * @param url String;//图片/视频地址
     * @param imgDelyed int;//图片轮播延时时间
     * **/
    public BannerPage(String url,int imgDelyed)
    {
        this.url = url;
        this.imgDelyed = imgDelyed;
    }
}

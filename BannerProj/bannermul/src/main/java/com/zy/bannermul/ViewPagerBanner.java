package com.zy.bannermul;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ViewPagerBanner extends ViewPager {
    //是否可以进行滑动
    private boolean isSlide = false;

    public ViewPagerBanner(@NonNull Context context) {
        super(context);
    }

    /**
     * //@Nullable ,可以传入空指针
     * //@Nonnull ,不可以传入空指针
     * **/
    public ViewPagerBanner(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSlide(boolean slide) {
        isSlide = slide;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isSlide;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isSlide;
    }

}

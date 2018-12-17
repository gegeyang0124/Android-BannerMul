package com.zy.bannermul;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
//import android.widget.ImageView;

public class MImageView extends AppCompatImageView {
    public MImageView(Context context)
    {
        super(context);
    }

    public MImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public MImageView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        Log.i("widthMeasureSpec",widthMeasureSpec + "");
        Log.i("heightMeasureSpec",heightMeasureSpec + "");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
       /* int width = getDefaultSize(getWidth(), widthMeasureSpec);
        int height = getDefaultSize(getHeight(), heightMeasureSpec);
        setMeasuredDimension(width, height);*/
    }
}

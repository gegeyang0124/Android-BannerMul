package com.zy.bannermul;

import android.net.Uri;

import com.danikula.videocache.file.FileNameGenerator;

/**
 * Created by steven on 2018/5/15.
 */

public class MyFileNameGenerator implements FileNameGenerator
{
    @Override
    public String generate(String url)
    {
        String name = url.substring(url.lastIndexOf("/") + 1, url.length());
        return name;
    }
}

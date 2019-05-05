package com.example.lenovo1.application1;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import android.R.integer;
public class StringTools {
    public static String readStream(InputStream in)throws Exception{
        //将传进来的流信息转换为字符串
        //创建1字节输出流对象
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        //定义读取长度
        int len=0;
        //定义缓存区
        byte buffer[]=new byte[2014];
        //按照缓存区大小循环读取
        while((len=in.read(buffer))!=-1){
            outputStream.write(buffer, 0, len);
        }
        in.close();
        outputStream.close();
        //将字符串数据返回
        String content=new String(outputStream.toByteArray(),"gbk");
        return content;

    }
}

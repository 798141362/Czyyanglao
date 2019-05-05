package com.example.lenovo1.application1;



import java.io.ByteArrayOutputStream;

import java.io.IOException;

import java.io.InputStream;



//创建一个通用类

public class Util {



    //从流中获得文本

    public static String getTextFromStream(InputStream is){



        //创建字节数组

        byte[] b = new byte[1024];



        //创建整型变量len,用于记录文本的长度

        int len = 0;



        //创建字节数组输出流，读取输入流的文本数据时，同步把数据写入数组输出流

        ByteArrayOutputStream bos = new ByteArrayOutputStream();



        try {

            //将读取到的数据写入字节数组输出流

            while((len = is.read(b)) != -1)

            {

                bos.write(b, 0, len);

            }



            //把字节数组输出流里的数据转换成字符串

            String text = new String(bos.toByteArray());



            //返回字符串

            return text;



        } catch (IOException e) {



            e.printStackTrace();

        }



        //当读取出现异常,则返回null

        return null;

    }

}

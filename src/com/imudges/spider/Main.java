package com.imudges.spider;


import java.io.*;
import java.net.*;

public class Main {
    //向网页发出请求获取网页页面代码
    static String sendGet(String url){
        //1.2定义一个字符串储存网页内容         另一种方法直接下载网页到本地
        String html="";
        //1.3定义一个缓冲字符输入流
        BufferedReader br=null;

        try {
            //2.1将url转换成对象
            URL urlObject=new URL(url);
            //初始化一个链接到那个url
            URLConnection connection=urlObject.openConnection();
            //开始连接
            connection.connect();
            //初始化BufferedReader输入流来读取URL的响应
            br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //定义临时储存一行数据的字符串
            String tmpLine;
            while((tmpLine=br.readLine())!=null){
                html+=tmpLine;
            }
        } catch (MalformedURLException e) {
            System.out.println("get请求异常");
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(br!=null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return html;
    }

    //封装的正则函数
    static String RegexString(String targetStr,String parrernStr)

    public static void main(String[] args) {

        //1.1定义即将访问的url
        String url="https://www.baidu.com";
        //1.2发起get请求获取页面代码,用result字符串保存
        String result=sendGet(url);
        //@test 输出测试
        System.out.println(result);
    }
}

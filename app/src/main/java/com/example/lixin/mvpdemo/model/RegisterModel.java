package com.example.lixin.mvpdemo.model;

import android.support.annotation.NonNull;

import com.example.lixin.mvpdemo.model.bean.DataBean;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.Inflater;

/**
 * Created by hua on 2017/9/5.
 */

public class RegisterModel {

    public RegisterModel() {

    }

    public void register(@NonNull final DataCallBack<DataBean> dataCallBack) {

        new Thread(){

            @Override
            public void run() {

                try {
                    URL url = new URL("http://v.juhe.cn/toutiao/index?type=top&key=5b6258c74f4346147b12fe38490a12b2");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);
                    connection.setRequestMethod("GET");

                    if (connection.getResponseCode() == 200){

                        // TODO: 2017/9/5 拿到输入流 把json传出去 在通过gson转换成bean
                        DataBean dataBean = new DataBean("注册成功了");
                        dataCallBack.onGetDataSucced(dataBean);



                    }else {
                        // TODO: 2017/9/5 注册失败 在Activity中提示用户哪里失败
                        String responseMessage = connection.getResponseMessage();
                        dataCallBack.onGetDataFail(responseMessage);

                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }.start();

    }


    public interface DataCallBack<T>{
        void onGetDataSucced(T t);
        void onGetDataFail(String exception);

    }

}

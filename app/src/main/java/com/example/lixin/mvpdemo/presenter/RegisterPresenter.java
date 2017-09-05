package com.example.lixin.mvpdemo.presenter;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.example.lixin.mvpdemo.model.RegisterModel;
import com.example.lixin.mvpdemo.model.bean.DataBean;
import com.example.lixin.mvpdemo.view.IView.IRegisterView;
import com.example.lixin.mvpdemo.view.activity.RegisterActivity;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hua on 2017/9/5.
 */

public class RegisterPresenter {

    //接口 负责回调activity
    private IRegisterView iRegisterView;

    //model
    private final RegisterModel registerModel;

    public RegisterPresenter(@NonNull IRegisterView iRegisterView){
        this.iRegisterView = iRegisterView;
        registerModel = new RegisterModel();
    }
    //去注册
    public void register() {
        registerModel.register(new RegisterModel.DataCallBack<DataBean>() {
            @Override
            public void onGetDataSucced(DataBean dataBean) {
             // TODO: 2017/9/5  注册成功在Activity中跳转到别的界面 (与界面更新有关的操作，放到view层)
                iRegisterView.onRegisterSucced(dataBean);
            }

            @Override
            public void onGetDataFail(String exception) {
                iRegisterView.onRegisterFaild(exception);
            }
        });
    }
}

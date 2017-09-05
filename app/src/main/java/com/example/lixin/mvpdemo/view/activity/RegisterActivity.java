package com.example.lixin.mvpdemo.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lixin.mvpdemo.R;
import com.example.lixin.mvpdemo.model.bean.DataBean;
import com.example.lixin.mvpdemo.presenter.RegisterPresenter;
import com.example.lixin.mvpdemo.view.IView.IRegisterView;

import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterActivity extends AppCompatActivity implements IRegisterView{

    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerPresenter = new RegisterPresenter(this);

    }
    //点击事件
    public void register(View view) {

        registerPresenter.register();

    }

    @Override
    public void onRegisterSucced(DataBean dataBean) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                            }
                        });
    }

    @Override
    public void onRegisterFaild(String exception) {
        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                            }
                        });
    }
}

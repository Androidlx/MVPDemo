package com.example.lixin.mvpdemo.view.IView;

import com.example.lixin.mvpdemo.model.bean.DataBean;

/**
 * Created by hua on 2017/9/5.
 */

public interface IRegisterView {

    void onRegisterSucced(DataBean dataBean);
    void onRegisterFaild(String exception);

}

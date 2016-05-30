package com.cysion.tdframework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cysion.tdframework.utils.ProviderUtils;

/**
 * Created by Administrator on 2016/5/30 0030.
 */
public abstract class TBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        loadData();
        setListener();
        linkOrNot();
    }
    /**
     * 初始化布局及控件
     */
    protected abstract void initView();

    /**
     * 加载本地数据
     */
    protected abstract void loadData();

    /**
     * 给控件设置事件监听
     */
    protected abstract void setListener();

    /**
     * 如果有网络，则获取网络数据
     */
    protected void linkOrNot() {
        if (ProviderUtils.isNetAvailable(this)) {
            getData();
        }
    }
    /**
     * 从网络获取数据
     */
    protected abstract void getData();

    @Override
    protected void onStart() {
        super.onStart();
        tracePage();
    }

    /**
     * 记录当前页面或是子页面的信息
     */
    protected abstract void tracePage();
}

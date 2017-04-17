package com.tearat.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Durian
 * 2017-2017/3/15
 */
public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  =inflater.inflate(getLayoutId(),container,false);
        initView(view, savedInstanceState);
        setOnClick();
        return view ;
    }


    protected abstract void initView(View view, Bundle savedInstanceState);

    protected  abstract  void setOnClick();
    //获取布局文件ID
    protected abstract int getLayoutId();
    //获取宿主Activity
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
         this.mActivity = (BaseActivity) context;

    }
    public void intentJump(Activity context, Class<?> activity, Bundle bundle) {
        Intent intent = new Intent(context, activity);
        if (bundle != null) {
            intent.putExtra("bundle", bundle);
        }
        startActivity(intent);
    }
}

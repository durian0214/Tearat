package com.tearat.my;

import android.os.Bundle;
import android.view.View;

import com.tearat.R;
import com.tearat.base.BaseFragment;

/**
 * Durian
 * 2017-2017/3/15
 */

public class MyFragment extends BaseFragment implements View.OnClickListener {
    public static MyFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("name", name);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onClick(View v) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void setOnClick() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }
}

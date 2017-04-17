package com.tearat.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tearat.R;
import com.tearat.base.BaseFragment;
import com.tearat.home.adapter.HomeAdapter;
import com.tearat.home.bean.HomeItemBean;
import com.tearat.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Durian
 * 2017-2017/3/15
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    RecyclerView rv;
    private HomeAdapter mAdapter;
    public static HomeFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("name",name);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onClick(View v) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        rv = (RecyclerView) view.findViewById(R.id.rv_home);
        rv.setLayoutManager(Utils.getVManager(getActivity()));
        mAdapter = new HomeAdapter(getActivity(),getData(),true);
        rv.setAdapter(mAdapter);
    }
    private List<HomeItemBean> getData(){
        List<HomeItemBean> lists = new ArrayList<>();
        for(int i = 1 ; i <=10;i++){
            HomeItemBean  bean = new HomeItemBean() ;
            bean .setName("name"+i);
            bean.setDetail("detail"+i);
            bean.setPrice((float) (i+0.00));
            lists.add(bean);
        }
        return lists;
    }

    @Override
    protected void setOnClick() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}

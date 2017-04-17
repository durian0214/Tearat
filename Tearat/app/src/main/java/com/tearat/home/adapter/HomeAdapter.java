package com.tearat.home.adapter;

import android.content.Context;

import com.tearat.R;
import com.tearat.base.adapterBase.CommonBaseAdapter;
import com.tearat.base.adapterBase.ViewHolder;
import com.tearat.home.bean.HomeItemBean;

import java.util.List;

/**
 * Durian
 * 2017-2017/4/17
 */

public class HomeAdapter extends CommonBaseAdapter<HomeItemBean>{
    private List lists ;
    private Context mContext;
    public HomeAdapter(Context context, List<HomeItemBean> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, HomeItemBean data) {
        holder.setText(R.id.tv_item_home_name,data.getName());
        holder.setText(R.id.tv_item_home_detail,data.getDetail());
        holder.setText(R.id.tv_item_home_price,String.valueOf(data.getPrice()));
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_home;
    }
}

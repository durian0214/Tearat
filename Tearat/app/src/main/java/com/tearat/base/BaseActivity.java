package com.tearat.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.tearat.R;


/**
 * Durian
 * 2017-2017/3/15
 */
public abstract class BaseActivity extends AppCompatActivity {

    public ActionBar bar;
    public Spinner spCity;
    public TextView tvTitle;
    public ImageView imgRight;
    private ImageView imgBack;
    private EditText edtSeach;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bar = getSupportActionBar();
        setActionBar();
        setContentView(getLayoutId());
        initView();
        setOnclick();
    }

    public void setActionBar() {
        bar.setCustomView(R.layout.bar_fragment);
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        bar.setDisplayHomeAsUpEnabled(false);
        bar.setBackgroundDrawable(ContextCompat.getDrawable(this,R.color.myTitle));
        spCity = (Spinner) bar.getCustomView().findViewById(R.id.sp_bar_fragment);
        tvTitle = (TextView) bar.getCustomView().findViewById(R.id.tv_bar_fragment);
        imgRight = (ImageView) bar.getCustomView().findViewById(R.id.img_bar_right);
        imgBack = (ImageView) bar.getCustomView().findViewById(R.id.img_bar_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrentActivity().finish();
            }
        });
        edtSeach = (EditText) bar.getCustomView().findViewById(R.id.edt_bar_fragment);
        isShowSp(false);
        isShowRight(false);
        isShowSeach(false);
    }

    /**
     * setting title name
     *
     * @param title
     */
    public void setMyTitle(String title) {
        tvTitle.setText(title);
    }

    public void setMyTitle(int title) {
        tvTitle.setText(title);
    }

    /**
     * 是否显示搜索 默认false
     * @param status
     */
    public void isShowSeach(boolean status) {
        if (edtSeach != null) {
            if (status) {
                tvTitle.setVisibility(View.GONE);
                edtSeach.setVisibility(View.VISIBLE);
            } else {
                tvTitle.setVisibility(View.VISIBLE);
                edtSeach.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 是否显示左下拉框 默认false
     *
     * @param isState
     */

    public void isShowSp(boolean isState) {
        if (spCity != null) {
            if (isState) {
                spCity.setVisibility(View.VISIBLE);
            } else {
                spCity.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 是否显示右键 默认false
     *
     * @param isState
     */
    public void isShowRight(boolean isState) {
        if (imgRight != null) {
            if (isState) {
                imgRight.setVisibility(View.VISIBLE);
            } else {
                imgRight.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 设置返回键是否显示 默认true
     *
     * @param isState
     */
    public void isShowBack(boolean isState) {
        if (isState) {
            imgBack.setVisibility(View.VISIBLE);
        } else {
            imgBack.setVisibility(View.GONE);
        }
    }

    protected abstract int getLayoutId();

    public abstract void initView();

    public abstract void setOnclick();

    public abstract <T extends BaseActivity> T getCurrentActivity();

    public final <E extends View> E getId(int id) {
        try {
            return (E) findViewById(id);
        } catch (ClassCastException e) {
            Log.e(getCurrentActivity().getLocalClassName(), "cannot find view id");
            throw e;
        }
    }

    public void intentJump(Activity context, Class<?> activity, Bundle bundle) {
        Intent intent = new Intent(context, activity);
        if (bundle != null) {
            intent.putExtra("bundle", bundle);
        }
        startActivity(intent);
    }


}

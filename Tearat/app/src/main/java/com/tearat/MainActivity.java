package com.tearat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.tearat.base.BaseActivity;
import com.tearat.home.HomeFragment;
import com.tearat.my.MyFragment;

import java.util.ArrayList;

/**
 * Durian
 * 2017-2017/3/15
 */
public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener{
    private ArrayList<Fragment> fragments;
    private static BottomNavigationBar bnb;
    private int[] fragmentName = {R.string.HOME,  R.string.MY};
    private int[] fragmentImg = {R.drawable.home,  R.drawable.my};
    private int[] fragmentColor = {R.color.myTheme,  R.color.myTheme};
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        isShowBack(false);
        isShowSp(true);
        isShowRight(true);
        bnb = getId(R.id.bnb_main);
        bnb.setMode(BottomNavigationBar.MODE_DEFAULT);
        bnb.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bnb.setBarBackgroundColor(R.color.bgWhite);
        for (int i = 0; i < fragmentName.length; i++) {
            bnb.addItem(new BottomNavigationItem(fragmentImg[i], getResources().getString(fragmentName[i])).setActiveColorResource(fragmentColor[i]));
        }
        bnb.setFirstSelectedPosition(0);
        bnb.initialise();
        fragments = getFragments();
        setDefaultFragment();
        bnb.setTabSelectedListener(this);
        imgRight.setBackground(ContextCompat.getDrawable(this, R.drawable.magnifying_glass));
        imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> f = new ArrayList<>();
        f.add(HomeFragment.newInstance("Home"));
        f.add(MyFragment.newInstance("My"));
        return f;
    }

    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fl_main, fragments.get(0));
        transaction.commit();
        setMyTitle(fragmentName[0]);
    }

    @Override
    public void setOnclick() {

    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void onTabSelected(int position) {
        if (position == 2) {
            isShowSp(false);
            isShowRight(false);
        } else {
            isShowSp(true);
            isShowRight(true);
        }
        //选中
        if (fragments != null) {
            if (position < fragments.size()) {
                setMyTitle(fragmentName[position]);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    transaction.show(fragment);
                } else {
                    transaction.add(R.id.fl_main, fragment);
                }
                transaction.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabUnselected(int position) {
//未选中
        setUnSelected(position);
    }
    public void setUnSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                transaction.hide(fragment);
                transaction.commitAllowingStateLoss();
            }
        }
    }
    @Override
    public void onTabReselected(int position) {

    }
}

package com.fyh.guide.guide;


/**
 * Durian
 * 2017-2017/2/15
 */

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.fyh.R;
import com.fyh.base.BaseActivity;
import com.fyh.guide.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseActivity {
    private static final String TAG = GuideActivity.class.getSimpleName();
    private ViewPager vp;
    private GuideAdapter mAdapter;
    private int[] imgs = {R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
    private List<View> lists = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public void initView() {
        bar.hide();
        vp = getId(R.id.vp_guide);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                LogUtil.i("---", "1");
            }

            @Override
            public void onPageSelected(int position) {

//                LogUtil.i("---", "2");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

//                LogUtil.i("---", "3");
            }
        });
        setData();
    }

    public void setData() {
        LayoutInflater layoutInflater = getLayoutInflater();

        for (int i = 0; i < imgs.length; i++) {
            View view = layoutInflater.inflate(R.layout.item_guide, null);
            ImageView img = (ImageView) view.findViewById(R.id.img_item_guide);
            img.setBackground(ContextCompat.getDrawable(this, imgs[i]));
            if (i == imgs.length - 1) {
                ImageView imgIn = (ImageView) view.findViewById(R.id.img_guide_in);
                imgIn.setVisibility(View.VISIBLE);
                imgIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intentJump(getCurrentActivity(), MainActivity.class, null);
                        getCurrentActivity().finish();
                    }
                });
            }
            lists.add(view);
        }
        mAdapter = new GuideAdapter(lists);
        vp.setAdapter(mAdapter);
    }

    @Override
    public void setOnclick() {

    }


    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

}

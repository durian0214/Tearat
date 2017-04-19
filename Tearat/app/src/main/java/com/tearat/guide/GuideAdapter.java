package com.fyh.guide.guide;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

 /**
 * Durian
 * 2017-2017/2/15
 */
public class GuideAdapter extends PagerAdapter {

    //界面列表  
    private List<View> views;

    public GuideAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);


    }
}


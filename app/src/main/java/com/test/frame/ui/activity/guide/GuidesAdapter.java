package com.test.frame.ui.activity.guide;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @文件名: GuidesAdapter
 * @功能描述:
 * @Create by chenzj on 2015/12/21 12:43
 * @email: chenzj@sq580.com
 * @修改记录:
 */
public class GuidesAdapter extends PagerAdapter {

    private List<View> guides = new ArrayList<>();

    public GuidesAdapter(List<View> guides) {
        this.guides = guides;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return guides.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(guides.get(position));
        return guides.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(guides.get(position));
    }
}


//package com.test.frame.ui.activity.guide;
//
//import android.app.Activity;
//import android.content.BroadcastReceiver;
//import android.support.v4.content.LocalBroadcastManager;
//import android.support.v4.view.ViewPager;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.ImageView;
//
//import com.amap.api.location.AMapLocation;
//import com.amap.api.location.AMapLocationClient;
//import com.amap.api.location.AMapLocationClientOption;
//import com.amap.api.location.AMapLocationListener;
//import com.orhanobut.logger.Logger;
//import com.sq580.library.util.PreferencesUtil;
//import com.sq580.user.AppContext;
//import com.sq580.user.AppUtil;
//import com.sq580.user.R;
//import com.sq580.user.common.PreferencesConstants;
//import com.sq580.user.net.HttpUrl;
//import com.sq580.user.ui.activity.main.MainActivity;
//import com.sq580.user.utils.MapUtil;
//import com.viewpagerindicator.CirclePageIndicator;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.OnClick;
//import mehdi.sakout.fancybuttons.FancyButton;
//
//
///**
// * @文件名: GuideActivity
// * @功能描述:
// * @Create by chenzj on 2015/12/21 12:41
// * @email: chenzj@sq580.com
// * @修改记录:
// */
//public class GuideActivity extends Activity implements AMapLocationListener {
//
//    private static final String TAG = "GuideActivity";
//
//    @BindView(R.id.activity_guide_viewpager)
//    ViewPager mViewPager;
//    @BindView(R.id.guide_finish_img)
//    FancyButton mStartButton;
//    @BindView(R.id.activity_guide_indicator)
//    CirclePageIndicator mIndicator;
//
//    private int[] mImages = new int[]{
//            R.drawable.welcome01,
//            R.drawable.welcome02,
//            R.drawable.welcome03,
//            R.drawable.welcome04,
//            R.drawable.welcome};
//
//    @Override
//    protected boolean toggleOverridePendingTransition() {
//        return false;
//    }
//
//    @Override
//    protected int getLayoutId() {
//        return R.layout.activity_guide;
//    }
//
//    @Override
//    protected void initViews() {
//        mStartButton.setVisibility(View.GONE);
//        // 实例化视图控件
//        List<View> views = new ArrayList<>();
//        GuidesAdapter pagerAdapter = new GuidesAdapter(views);
//
//        for (int image : mImages) {
//            ImageView imageView = new ImageView(this);
//            imageView.setImageDrawable(getResources().getDrawable(image));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            views.add(imageView);
//        }
//
//        mViewPager.setAdapter(pagerAdapter); // 设置适配器
//        mIndicator.setViewPager(mViewPager);
//        mIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                if (position == mImages.length - 1) {
//                    mStartButton.setVisibility(View.VISIBLE);
//                } else {
//                    mStartButton.setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//            }
//        });
//
//    }
//
//    @OnClick(R.id.guide_finish_img)
//    void clickStartButton() {
//        PreferencesUtil.putBoolean(getAppContext(), AppUtil.getVersionName(AppContext.getInstance())
//                + PreferencesConstants.NO_FIRST_START, true);
//        readyGoThenKill(MainActivity.class);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
//
//
//
//}
//

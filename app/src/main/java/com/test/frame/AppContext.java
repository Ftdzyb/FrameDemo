package com.test.frame;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.orhanobut.logger.Logger;
import com.sq580.library.encryption.AESJniUtil;
import com.sq580.library.netstatus.NetStateReceiver;
import com.sq580.library.util.PixelUtil;

/**
 * @文件名: AppContext
 * @功能描述: AppContext类.初始化ImageLoad.通知栏.播放器等等
 * @Create by Administrator on 2015-12-4 下午8:03:17
 * @email: chenzj@sq580.com
 * @修改记录:
 */
@SuppressLint("HandlerLeak")
public class AppContext extends Application {

    private static final String TAG = "AppContext";

    public static AppContext mInstance;

    public static boolean isDebug = true;
    public static boolean isHostDebug = true;
    public static boolean isVideoDebug = true;

//    private RefWatcher refWatcher;

    public static AppContext getInstance() {
        return mInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        initDebugOrRelease();
        initHost();
//        refWatcher = initLeakCanary();                      //初始化内存泄露管理
//        initLogger();                                       //初始化日志管理
        NetStateReceiver.registerNetworkStateReceiver(this);//全局网络监听
//        ImageLoadOptions.initUil(getInstance());            //初始化图片加载
//        initBugly();                    //初始化bugly
//        JpushUtil.init();               //初始化jpush
//        TalkingDataUtil.init(this, isDebug);         //初始化talkingdata
        PixelUtil.init(getInstance());  //初始化px2dp.dp2px.sp2px.px2sp
//        ShareManager.INSTANCE.init();   //初始化qq/微信分享
//        SocketUtil.INSTANCE.init();     //初始化Socket管理类
//        RedDotManager.INSTANCE.init();  //初始化红点管理类
//        MediaUtil.INSTANCE.init();
//        CareManager.INSTANCE.init();    //初始化照护.主要用于差异控制版本
        //QavsdkUtil.INSTANCE.init(this);//暂时屏蔽互动直播

        //初始化加密工具类
        try {
            AESJniUtil.init(this);
        } catch (Exception ex) {
            Logger.t(TAG).i("校验签名失败");
        }
    }

    private void initDebugOrRelease() {
//        if (Boolean.parseBoolean(getString(R.string.isDebug))) {
//            isDebug = true;
//            isHostDebug = true;
//            isVideoDebug = false;
//        } else {
//            isDebug = false;
//            isHostDebug = false;
//            isVideoDebug = false;
//        }
    }

    private void initHost() {
//        if (isHostDebug) {
//            String debugHostUrl = PreferencesUtil.getString(this, PreferencesConstants.DEBUG_HOSTURL_KEY, "");
//            if (TextUtils.isEmpty(debugHostUrl)) {
//                HttpUrl.setDebugDefaultHost();
//            } else {
//                HttpUrl.setLocalDebugHost(debugHostUrl);
//            }
//        } else {
//            HttpUrl.setReleaseHostUrl();
//        }
    }

//    private void initBugly() {
//        CrashReport.UserStrategy userStrategy = new CrashReport.UserStrategy(this);
//        userStrategy.setAppChannel(AppUtil.getChanel(this));
//        CrashReport.initCrashReport(this, getString(R.string.buglyId), isDebug, userStrategy);
//    }
//
//    protected RefWatcher initLeakCanary() {
//        return isDebug ? LeakCanary.install(this) : RefWatcher.DISABLED;
//    }
//
//    public static RefWatcher getRefWatcher(Context context) {
//        AppContext application = (AppContext) context.getApplicationContext();
//        return application.refWatcher;
//    }
//
//    private void initLogger() {
//        if (isDebug) {
//            Logger.init("sq580").methodCount(1).methodOffset(0).logLevel(LogLevel.FULL).hideThreadInfo();
//        } else {
//            Logger.init("sq580").methodCount(1).methodOffset(0).logLevel(LogLevel.NONE).hideThreadInfo();
//        }
//    }
//
//    public void disConnect() {
//        JpushUtil.resetJpush();
//        MediaUtil.INSTANCE.pause();
//        TempBean.getInstance().clean();
//        SocketUtil.INSTANCE.stopSocketService();
//        MediaUtil.INSTANCE.pause();
//    }
//
//    public void exitApp() {
//        NetStateReceiver.unRegisterNetworkStateReceiver(this);
//        AppManager.getInstance().clear();
//        SocketUtil.INSTANCE.stopSocketService();
//        System.gc();
//        android.os.Process.killProcess(android.os.Process.myPid());
//        System.exit(1);
//    }

//    public static boolean isLogin() {
//        return !TextUtils.isEmpty(HttpUrl.TOKEN) && !TextUtils.isEmpty(HttpUrl.USER_ID);
//    }
}

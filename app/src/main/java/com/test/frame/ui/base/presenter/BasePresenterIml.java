package com.test.frame.ui.base.presenter;

import com.sq580.library.base.BaseCompatActivity;

import java.lang.ref.WeakReference;

/**
 * @文件名: BasePresenterIml
 * @功能描述:
 * @Create by chenzj on 2016/1/12 22:18
 * @email: chenzj@sq580.com
 * @修改记录:
 */
public class BasePresenterIml implements IBasePresenter {

    private static final String TAG = "BasePresenterIml";

    private WeakReference<BaseCompatActivity> mActivity;

    public BasePresenterIml(BaseCompatActivity mActivity) {
        this.mActivity = new WeakReference<>(mActivity);
    }

    @Override
    public void onResume() {
        final BaseCompatActivity baseCompatActivity = mActivity.get();
        if (null == baseCompatActivity) {
            return;
        }
//        if (!TextUtils.isEmpty(HttpUrl.TOKEN) && !TextUtils.isEmpty(HttpUrl.USER_ID)) {
//            Sq580UserController.INSTANCE.isSignon(baseCompatActivity.mUUID, new LoginStatusIml() {
//                @Override
//                public void loginNormal() {
//                    Logger.t(TAG).i("登录状态正常");
//                    Sq580Controller.INSTANCE.getUserInfo();
//                }
//            });
//        } else {
//            Logger.i("onResume token&userId is null");
//            if (TextUtils.isEmpty(Sq580UserController.INSTANCE.getAccount())) {
//                Logger.t(TAG).i("is logout");
//            } else {
//                //don't do auto Login in this.It will do in initAct
//                //login(getAccount(), getPassWd(), null);
//            }
//        }
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onKeyDown() {
        final BaseCompatActivity baseCompatActivity = mActivity.get();
//        if (null == baseCompatActivity) {
//            return;
//        }
//        if (baseCompatActivity.isShowIngDialog()) {
//            baseCompatActivity.hideDialog();
//        } else {
//            baseCompatActivity.showNoTitleCallback("是否退出程序", "确定", "取消", new CustomButtonCallback() {
//                @Override
//                public void onClick(@NonNull CustomDialog dialog, @NonNull CustomDialogAction which) {
//                    baseCompatActivity.hideDialog();
//                    AppContext.getInstance().exitApp();
//                }
//            });
//        }
    }

    @Override
    public void onFinish() {
//        BaseCompatActivity baseCompatActivity = mActivity.get();
//        if (null == baseCompatActivity) {
//            return;
//        }
//        OkHttpUtils.getInstance().cancelTag(baseCompatActivity.mUUID);
    }

    @Override
    public boolean showErrorMsg(int errorCode, String errorMsg) {
        final BaseCompatActivity baseCompatActivity = mActivity.get();
        if (null == baseCompatActivity) {
            return false;
        }
        try {
            if (null != baseCompatActivity.getToast()) {
                baseCompatActivity.getToast().cancel();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

//        if (errorCode == 2004) {
//            baseCompatActivity.showOnlyConfirmCallback("未登录!", new CustomButtonCallback() {
//                @Override
//                public void onClick(CustomDialog dialog, CustomDialogAction which) {
//
//                    AppContext.getInstance().disConnect();
//                    AppManager.getInstance().clearToTop();
//                    Bundle bundle = new Bundle();
//                    baseCompatActivity.readyGoThenKill(MainActivity.class, bundle);
//                }
//            });
//            return true;
//        }
//        switch (errorCode) {
//            case ErrorCode.SOCKET_EXCEPTION:
//
//                break;
//            case ErrorCode.INTERRUPTED_IOEXCEPTION:
//
//                break;
//            case ErrorCode.OTHER_IOEXCEPTION:
//
//                break;
//            case ErrorCode.RUNTIME_EXCEPTION:
//
//                break;
//            case ErrorCode.EXCHANGE_DATA_ERROR:
//
//                break;
//        }
        return false;
    }
}


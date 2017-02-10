package com.test.frame.ui.base;

import android.view.KeyEvent;

import com.sq580.library.base.BaseCompatActivity;
import com.test.frame.AppContext;
import com.test.frame.common.PermissionConstant;
import com.test.frame.ui.base.presenter.BasePresenterIml;
import com.test.frame.ui.base.presenter.IBasePresenter;

import butterknife.ButterKnife;

public abstract class BaseActivity extends BaseCompatActivity {

    private static final String TAG = "BaseActivity";

    protected IBasePresenter mIBasePresenter;

    protected AppContext getAppContext() {
        return AppContext.getInstance();
    }

    @Override
    protected String[] getPermissions() {
        return PermissionConstant.PERMS;
    }

    @Override
    protected void initSpecialView() {
        super.initSpecialView();
        ButterKnife.bind(this);
        mIBasePresenter = new BasePresenterIml(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (isSuperOnKeyDown()) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                mIBasePresenter.onKeyDown();
                return true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isSuperOnResume()) {
            mIBasePresenter.onResume();
        }
    }

    @Override
    public void finish() {
        super.finish();
        mIBasePresenter.onFinish();
    }

    @Override
    public boolean doNetError(int errorCode, String errorMsg) {
        if (null != mIBasePresenter) {
            return mIBasePresenter.showErrorMsg(errorCode, errorMsg);
        }
        return super.doNetError(errorCode, errorMsg);
    }

    /*
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleSignMes() {

        SignBean mSignBean = new SignBean();
        if (mSignBean.getProcess() == 1) {
            final String content = TextUtils.isEmpty(mSignBean.getContent()) ? "你的签约申请已经被通过"
                    : (mSignBean.getContent().trim().equals("null") ? "你的签约申请已经被通过" : mSignBean.getContent());

            showNoTitleMdDialog("" + content, new MaterialDialog.SingleButtonCallback() {
                @Override
                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                    if (which == DialogAction.POSITIVE || which == DialogAction.NEGATIVE) {
                        dialog.dismiss();
                        readyGoThenKill(SignGuideActivity.class);
                    }
                }
            });
        } else if (mSignBean.getProcess() == 2) {

            final String content = TextUtils.isEmpty(mSignBean.getContent()) ? "你的签约申请被拒绝"
                    : (mSignBean.getContent().trim().equals("null") ? "你的签约申请被拒绝" : mSignBean.getContent());

            showNoTitleMdDialog("" + content, new MaterialDialog.SingleButtonCallback() {
                @Override
                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                    if (which == DialogAction.POSITIVE || which == DialogAction.NEGATIVE) {
                        dialog.dismiss();
                        if (getClass().getName().equals(ToolWebActivity.class.getName())) {
                            finish();
                        }
                    }
                }
            });
        }
    }*/
}

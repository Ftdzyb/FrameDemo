package com.test.frame.ui.base.presenter;

/**
 * @文件名: IBasePresenter
 * @功能描述:
 * @Create by chenzj on 2016/1/12 22:14
 * @email: chenzj@sq580.com
 * @修改记录:
 */
public interface IBasePresenter {

    public void onResume();

    public void onPause();

    public void onDestroy();

    public void onKeyDown();

    public void onFinish();

    public boolean showErrorMsg(int errorCode, String errorMsg);

    public static class DefaultBasePresenter implements IBasePresenter {

        @Override
        public void onResume() {
        }

        @Override
        public void onPause() {
        }

        @Override
        public void onDestroy() {
        }

        @Override
        public void onKeyDown() {
        }

        @Override
        public void onFinish() {
        }

        @Override
        public boolean showErrorMsg(int errorCode, String errorMsg) {
            return false;
        }
    }
}


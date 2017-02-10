package com.test.frame.common;

import android.Manifest;

/**
 * @author chenzj
 * @Title: PerssionConstants
 * @Description: 类的描述 -
 * @date 2016/6/29 17:27
 * @email admin@chenzhongjin.cn
 */
public class PermissionConstant {

    public static final String[] PERMS = {
            //读写sd卡
            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE,
            //手机状态
            Manifest.permission.READ_PHONE_STATE,
            //修改设置
            //Manifest.permission.WRITE_SETTINGS,
            //悬浮窗
            //Manifest.permission.SYSTEM_ALERT_WINDOW,
            //定位权限
            Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,
            //Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
            //录音
            Manifest.permission.RECORD_AUDIO,
            //摄像头
            Manifest.permission.CAMERA,};
}


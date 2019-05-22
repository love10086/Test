package com.gemall.library.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.Random;

/**
 * author : g-emall
 * time   : 2019/1/28
 * desc   : Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    /**
     * 获取一个 Handler 对象
     */
    public static Handler getHandler() {
        return HANDLER;
    }

    @Override
    protected void onCreate(@android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivity();
    }

    protected void initActivity() {
        initLayout();
        initView();
        initData();
    }

    protected void initLayout() {
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }
    }

    // 引入布局
    protected abstract int getLayoutId();

    // 标题栏id
    protected abstract int getTitleBarId();

    // 初始化控件
    protected abstract void initView();

    // 初始化数据
    protected abstract void initData();

    @Override
    public void finish() {
        hideSoftKeyboard();
        super.finish();
    }

    /**
     * 获取一个 Context 对象
     * 部分机型使用该方法会崩溃，暂不使用
     */
//    public Context getContext() {
//        return getBaseContext();
//    }

    /**
     * 获取当前 Activity 对象
     */
    public <A extends BaseActivity> A getActivity() {
        return (A) this;
    }

    /**
     * startActivity 方法初始化
     */
    public void startActivity(Class<? extends Activity> cls) {
        startActivity(new Intent(this, cls));
    }

    public void startActivityFinish(Class<? extends Activity> cls) {
        startActivityFinish(new Intent(this, cls));
    }

    public void startActivityFinish(Intent intent) {
        startActivity(intent);
        finish();
    }

    public void finishResult(int resultCode) {
        finishResult(resultCode, null);
    }

    public void finishResult(int resultCode, Intent data) {
        setResult(resultCode, data);
    }

    /**
     * startActivityForResult 方法优化
     */
    private ActivityCallback mActivityCallback;
    private int mActivityRequestCode;

    public void startActivityForResult(Intent intent, ActivityCallback callback) {
        startActivityForResult(intent, null, callback);
    }

    private void startActivityForResult(Intent intent, @Nullable Bundle options, ActivityCallback callback) {
        if (mActivityCallback == null) {
            mActivityCallback = callback;
            // 随机生成请求码，这个请求码在 0 - 255 之间
            mActivityRequestCode = new Random().nextInt(255);
            startActivityForResult(intent, mActivityRequestCode, options);
        } else {
            // 回调还没有结束，所以不能再次调用此方法，这个方法只适合一对一回调，其他需求请使用原生的方法实现
            throw new IllegalArgumentException("Error, The callback is not over yet");
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (mActivityCallback != null && mActivityRequestCode == requestCode) {
            mActivityCallback.onActivityResult(resultCode, data);
            mActivityCallback = null;
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    /**
     * 防 Activity 多重跳转：https://www.jianshu.com/p/579f1f118161
     */
    @SuppressLint("RestrictedApi")
    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        if (startAcitivitySelfCheck(intent)) {
            hideSoftKeyboard();
            // 查看源码得知 startActivity 最终也会调用 startActivityForResult
            super.startActivityForResult(intent, requestCode, options);
        }
    }

    private String mStartActivityTag;
    private long mStartActivityTime;

    protected boolean startAcitivitySelfCheck(Intent intent) {
        // 默认检查通过
        boolean result = true;
        // 标记对象
        String tag;
        if (intent.getComponent() != null) { // 显式跳转
            tag = intent.getComponent().getClassName();
        } else if (intent.getAction() != null) { // 隐式跳转
            tag = intent.getAction();
        } else { // 其他形式
            return result;
        }

        if (tag.equals(mStartActivityTag) && mStartActivityTime >= SystemClock.uptimeMillis() - 500) {
            // 检查不通过
            result = false;
        }

        mStartActivityTag = tag;
        mStartActivityTime = SystemClock.uptimeMillis();
        return result;
    }

    /**
     * 隐藏软键盘
     */
    private void hideSoftKeyboard() {
        // 隐藏软键盘，避免软键盘引发的内存泄露
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (manager != null) manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    /**
     * 点击软键盘外面的区域关闭软键盘
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            // 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                hideSoftKeyboard();
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideInput(View v, MotionEvent event) {
        if ((v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
        return false;
    }

    /**
     * Activity 回调接口
     */
    public interface ActivityCallback {
        /**
         * 结果回调
         *
         * @param resultCode 结果码
         * @param data       数据
         */
        void onActivityResult(int resultCode, @Nullable Intent data);
    }
}

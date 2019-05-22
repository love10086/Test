package com.example.emall.wpq;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends Activity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        startMqtt();



        ARouter.getInstance().build("/oa/MainActivity").navigation();

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native void startMqtt();
}

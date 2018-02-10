package com.github.lidajun.android.samples.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.lidajun.android.common.utils.llog.LLog;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final Test mTest;

    public MainActivity() {
        mTest = new Test();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            LLog.saveLevel(this,getCacheDir().getAbsolutePath(),"log", LLog.VERBOSE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LLog.e();
        LLog.e("tag","onCreate");
        mTest.get();
    }
}

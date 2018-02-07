package com.github.lidajun.android.common.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Li dajun
 * Date: 2016-03-04
 * Time: 14:34
 */
public class LToast {
    private static Toast sToast;
    private static int GRAVITY = Gravity.CENTER;

    public static void setGRAVITY(int gravity) {
        GRAVITY = gravity;
    }

    @SuppressLint("ShowToast")
    public static Toast getExitToast(@NonNull Context context, @StringRes int strId) {
        context = context.getApplicationContext();
        Toast toast = Toast.makeText(context, strId, Toast.LENGTH_SHORT);
        toast.setGravity(GRAVITY, 0, 0);
        return toast;
    }

    @SuppressLint("ShowToast")
    public static void show(@NonNull Context context, String text, int duration) {
        makeToast(context, duration);
        sToast.setText(text);
        sToast.show();
    }

    @SuppressLint("ShowToast")
    public static void show(@NonNull Context context, int textId, int duration) {
        makeToast(context, duration);
        sToast.setText(textId);
        sToast.show();
    }

    @SuppressLint("ShowToast")
    private static void makeToast(Context context, int duration) {
        if (sToast == null) {
            sToast = Toast.makeText(context.getApplicationContext(), "", duration);
            sToast.setGravity(GRAVITY, 0, 0);
        }
    }

    public static void showLong(@NonNull Context context, int textId) {
        show(context, textId, Toast.LENGTH_LONG);
    }

    public static void showLong(@NonNull Context context, String s) {
        show(context, s, Toast.LENGTH_LONG);
    }

    public static void showShort(@NonNull Context context, int textId) {
        show(context, textId, Toast.LENGTH_SHORT);
    }

    public static void showShort(@NonNull Context context, String s) {
        show(context, s, Toast.LENGTH_SHORT);
    }

    public static void showError(@NonNull Context context, Object o,@StringRes int defStr) {
        if (null != o && o instanceof String) {
            showShort(context, o.toString());
        } else {
            showShort(context, defStr);
        }
    }
}

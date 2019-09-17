package com.willemgeo.szdb.utils;

import android.app.Activity;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2019/9/17.
 */

public class MyActivityManager {
    private static MyActivityManager sInstance = new MyActivityManager();

    private WeakReference<Activity> sCurrentActivityWeakRef;

    private Object activityUpdateLock = new Object();
    private MyActivityManager() {

    }

    public static MyActivityManager getInstance() {
        return sInstance;
    }

    public Activity getCurrentActivity() {
        Activity currentActivity = null;
        synchronized (activityUpdateLock){
            if (sCurrentActivityWeakRef != null) {
                currentActivity = sCurrentActivityWeakRef.get();
            }
        }
        return currentActivity;
    }

    public void setCurrentActivity(Activity activity) {
        synchronized (activityUpdateLock){
            sCurrentActivityWeakRef = new WeakReference<Activity>(activity);
        }

    }
}
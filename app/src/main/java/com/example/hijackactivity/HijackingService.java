package com.example.hijackactivity;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.List;

public class HijackingService extends Service {

    private boolean hasStart = false;

    // 这是一个悲伤的故事……
    HashMap<String, Class<?>> mSadStories = new HashMap<String, Class<?>>();

    // Timer mTimer = new Timer();
    Handler handler = new Handler();

    Runnable mTask = new Runnable() {

        @Override
        public void run() {
            ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> appProcessInfos = activityManager.getRunningAppProcesses();
            // 枚举进程
            Log.w("hijacking", "正在枚举进程");
            for (ActivityManager.RunningAppProcessInfo appProcessInfo : appProcessInfos) {
                // 如果APP在前台，那么——悲伤的故事就要来了
                if (appProcessInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    if (mSadStories.containsKey(appProcessInfo.processName)) {
                        // 进行劫持
                        hijacking(appProcessInfo.processName);
                    } else {
                        Log.w("hijacking", appProcessInfo.processName);
                    }
                }
            }
            handler.postDelayed(mTask, 1000);
        }

        /**
         * 进行劫持
         * @param processName
         */
        private void hijacking(String processName) {
            Log.w("hijacking", "有程序要悲剧了……");
            if (((HijackingApplication) getApplication()).hasProgressBeHijacked(processName) == false) {
                Log.w("hijacking", "悲剧正在发生");
                Intent jackingIsComing = new Intent(getBaseContext(), mSadStories.get(processName));
                jackingIsComing.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplication().startActivity(jackingIsComing);
                ((HijackingApplication) getApplication()).addProgressHijacked(processName);
                Log.w("hijacking", "已经劫持");
            }
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (!hasStart) {
//            mSadStories.put("com.sinaapp.msdxblog.android.lol",  JokeActivity.class);
//            mSadStories.put("com.tencent.mobileqq", QQStoryActivity.class);
//            mSadStories.put("com.eg.android.AlipayGphone", AlipayStoryActivity.class);
            mSadStories.put("com.xx.xx", AlipayStoryActivity.class);
            handler.postDelayed(mTask, 1000);
            hasStart = true;
        }

    }

    @Override
    public boolean stopService(Intent name) {
        hasStart = false;
        Log.w("hijacking", "劫持服务停止");
        ((HijackingApplication) getApplication()).clearProgressHijacked();
        return super.stopService(name);
    }
}

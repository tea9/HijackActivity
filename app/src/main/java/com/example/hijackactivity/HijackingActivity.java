package com.example.hijackactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

public class HijackingActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent2 = new Intent(this, HijackingService.class);
        startService(intent2);
        Log.w("hijacking", "activity启动用来劫持的Service");
    }
}

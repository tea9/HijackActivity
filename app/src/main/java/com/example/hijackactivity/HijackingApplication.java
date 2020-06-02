package com.example.hijackactivity;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class HijackingApplication  extends Application {
    private static List<String> hijackings = new ArrayList();

    public static void addProgressHijacked(String paramString){
        hijackings.add(paramString);
    }

    public static void clearProgressHijacked(){
        hijackings.clear();
    }

    public static boolean hasProgressBeHijacked(String paramString){
        return hijackings.contains(paramString);
    }
}

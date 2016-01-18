package com.performance.gracker.memoryinfotools;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.util.SparseArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Gracker on 2016/1/17.
 */
public class MemoryInfo {
    public static String TAG = "MemoryInfo";
    public static String TOTAL_PSS_BY_PROCESS = "Total PSS by process";
    public static String TOTAL_PSS_BY_OOM_NATIVE = "Total PSS by process";
    public static String TOTAL_PSS_BY_OOM_SYSTEM = "Total PSS by process";
    public static String TOTAL_PSS_BY_OOM_PERSISTENT = "Total PSS by process";
    public static String TOTAL_PSS_BY_OOM_FOREGROUND = "Total PSS by process";
    public static String TOTAL_PSS_BY_OOM_PERCEPTIBLE= "Total PSS by process";
    public static String TOTAL_PSS_BY_OOM_BSERVICES= "Total PSS by process";
    public static String TOTAL_PSS_BY_OOM_ASERVICES= "Total PSS by process";
    public static String TOTAL_PSS_BY_OOM_CACHED= "Total PSS by process";
    public static String TOTAL_PSS_BY_CATEGORY= "Total PSS by process";

    //Total PSS by process
    SparseArray totalPssByProcess ;

    //Total PSS by OOM adjustment
    SparseArray totalPssByOOMAdjustmentNative ;
    SparseArray totalPssByOOMAdjustmentSystem ;
    SparseArray totalPssByOOMAdjustmentPersistent ;
    SparseArray totalPssByOOMAdjustmentForeground ;
    SparseArray totalPssByOOMAdjustmentVisible ;
    SparseArray totalPssByOOMAdjustmentPerceptible ;
    SparseArray totalPssByOOMAdjustmentBServices ;
    SparseArray totalPssByOOMAdjustmentAServices ;
    SparseArray totalPssByOOMAdjustmentCached ;

    //Total PSS by category
    SparseArray totalPssbyCategory ;

    private Context mContext;

    public MemoryInfo(Context context){
        mContext = context;
    }

    public String loadMeminfoFromFile(String fileName){
        AssetManager am = null;
        am = mContext.getResources().getAssets();
        try {
            InputStreamReader inputReader = new InputStreamReader( am.open(fileName) );
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line="";
            String result="";
            int index  = -1 ;
            while((line = bufReader.readLine()) != null){
                if(line.contains("TOTAL_PAA_BY_PROCESS")){
                    index = 0 ;
                    continue;
                }else if(line.contains("TOTAL_PSS_BY_OOM_NATIVE")){
                    index = 1 ;
                    continue;
                }else if(line.contains("TOTAL_PSS_BY_OOM_SYSTEM")){
                    index = 2 ;
                    continue;
                }else if(line.contains("TOTAL_PSS_BY_OOM_PERSISTENT")){
                    index = 3 ;
                    continue;
                }else if(line.contains("TOTAL_PSS_BY_OOM_FOREGROUND")){
                    index = 4 ;
                    continue;
                }else if(line.contains("TOTAL_PSS_BY_OOM_PERCEPTIBLE")){
                    index =5 ;
                    continue;
                }else if(line.contains("TOTAL_PSS_BY_OOM_BSERVICES")){
                    index = 6 ;
                    continue;
                }else if(line.contains("TOTAL_PSS_BY_OOM_ASERVICES")){
                    index = 7 ;
                    continue;
                }else if(line.contains("TOTAL_PSS_BY_OOM_CACHED")){
                    index = 8 ;
                    continue;
                }else if(line.contains("TOTAL_PSS_BY_CATEGORY")){
                    index = 9 ;
                    continue;
                }

                if(index != -1) {
                    parseMemorySize(line, index);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void parseMemorySize(String string , int index ){

    }

    public void parseInfo(String result){
        Log.i(TAG,result);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

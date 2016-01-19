package com.performance.gracker.memoryinfotools;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.util.SparseArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Gracker on 2016/1/17.
 */
public class MemoryInfo {
    private static final String TAG = "MemoryInfo";
    private static final String TOTAL_PSS_BY_PROCESS = "Total PSS by process";
    private static final String TOTAL_PSS_BY_OOM_NATIVE = ": Native";
    private static final String TOTAL_PSS_BY_OOM_SYSTEM = ": System";
    private static final String TOTAL_PSS_BY_OOM_PERSISTENT = ": Persistent";
    private static final String TOTAL_PSS_BY_OOM_FOREGROUND = ": Foreground";
    private static final String TOTAL_PSS_BY_OOM_VISIBLE = ": Visible";
    private static final String TOTAL_PSS_BY_OOM_PERCEPTIBLE = ": Perceptible";
    private static final String TOTAL_PSS_BY_OOM_BSERVICES = ": B Services";
    private static final String TOTAL_PSS_BY_OOM_ASERVICES = ": A Services";
    private static final String TOTAL_PSS_BY_OOM_CACHED = ": Cached";
    private static final String TOTAL_PSS_BY_CATEGORY = "Total PSS by process";

    private static final int INDEX_TOTAL_PSS_BY_PROCESS = 0;
    private static final int INDEX_TOTAL_PSS_BY_OOM_NATIVE = 1;
    private static final int INDEX_TOTAL_PSS_BY_OOM_SYSTEM = 2;
    private static final int INDEX_TOTAL_PSS_BY_OOM_PERSISTENT = 3;
    private static final int INDEX_TOTAL_PSS_BY_OOM_FOREGROUND = 4;
    private static final int INDEX_TOTAL_PSS_BY_OOM_VISIBLE = 5;
    private static final int INDEX_TOTAL_PSS_BY_OOM_PERCEPTIBLE = 6;
    private static final int INDEX_TOTAL_PSS_BY_OOM_BSERVICES = 7;
    private static final int INDEX_TOTAL_PSS_BY_OOM_ASERVICES = 8;
    private static final int INDEX_TOTAL_PSS_BY_OOM_CACHED = 9;
    private static final int INDEX_TOTAL_PSS_BY_CATEGORY = 10;

    //Total PSS by process
    SparseArray totalPssByProcess;

    //Total PSS by OOM adjustment
    SparseArray totalPssByOOMAdjustmentNative;
    SparseArray totalPssByOOMAdjustmentSystem;
    SparseArray totalPssByOOMAdjustmentPersistent;
    SparseArray totalPssByOOMAdjustmentForeground;
    SparseArray totalPssByOOMAdjustmentVisible;
    SparseArray totalPssByOOMAdjustmentPerceptible;
    SparseArray totalPssByOOMAdjustmentBServices;
    SparseArray totalPssByOOMAdjustmentAServices;
    SparseArray totalPssByOOMAdjustmentCached;

    //Total PSS by category
    SparseArray totalPssbyCategory;

    private Context mContext;

    public MemoryInfo(Context context) {
        mContext = context;
    }

    public String loadMeminfoFromFile(String fileName) {
        AssetManager am = null;
        am = mContext.getResources().getAssets();
        try {
            InputStreamReader inputReader = new InputStreamReader(am.open(fileName));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line = "";
            String result = "";
            int index = -1;
            while ((line = bufReader.readLine()) != null) {
                if (line.contains(TOTAL_PSS_BY_PROCESS)) {
                    index = 0;
                    continue;
                } else if (line.contains(TOTAL_PSS_BY_OOM_NATIVE)) {
                    index = 1;
                    continue;
                } else if (line.contains(TOTAL_PSS_BY_OOM_SYSTEM)) {
                    index = 2;
                    continue;
                } else if (line.contains(TOTAL_PSS_BY_OOM_PERSISTENT)) {
                    index = 3;
                    continue;
                } else if (line.contains(TOTAL_PSS_BY_OOM_FOREGROUND)) {
                    index = 4;
                    continue;
                } else if (line.contains(TOTAL_PSS_BY_OOM_VISIBLE)) {
                    index = 5;
                    continue;
                } else if (line.contains(TOTAL_PSS_BY_OOM_PERCEPTIBLE)) {
                    index = 6;
                    continue;
                } else if (line.contains(TOTAL_PSS_BY_OOM_BSERVICES)) {
                    index = 7;
                    continue;
                } else if (line.contains(TOTAL_PSS_BY_OOM_ASERVICES)) {
                    index = 8;
                    continue;
                } else if (line.contains(TOTAL_PSS_BY_OOM_CACHED)) {
                    index = 9;
                    continue;
                } else if (line.contains(TOTAL_PSS_BY_CATEGORY)) {
                    index = 10;
                    continue;
                } else if(line.contains("Total RAM")){
                    index = 11 ;
                }

                if (index != -1) {
                    parseMemorySize(line, index);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void parseMemorySize(String string, int index) {
        //string : 104694 kB: system (pid 1213)
        String key = string.substring(0, string.indexOf("kB"));
        String value = string.substring(string.indexOf("kB") + 4, string.length());
        Log.i(TAG, "key = " + key + " value =" + value);
        switch (index) {
            case INDEX_TOTAL_PSS_BY_PROCESS:
                break;
            case INDEX_TOTAL_PSS_BY_OOM_NATIVE:
                break;
            case INDEX_TOTAL_PSS_BY_OOM_SYSTEM:
                break;
            case INDEX_TOTAL_PSS_BY_OOM_PERSISTENT:
                break;
            case INDEX_TOTAL_PSS_BY_OOM_FOREGROUND:
                break;
            case INDEX_TOTAL_PSS_BY_OOM_VISIBLE:
                break;
            case INDEX_TOTAL_PSS_BY_OOM_PERCEPTIBLE:
                break;
            case INDEX_TOTAL_PSS_BY_OOM_BSERVICES:
                break;
            case INDEX_TOTAL_PSS_BY_OOM_ASERVICES:
                break;
            case INDEX_TOTAL_PSS_BY_OOM_CACHED:
                break;
            case INDEX_TOTAL_PSS_BY_CATEGORY:
                break;
            default:
                break;
        }
    }

    public void parseInfo(String result) {
        Log.i(TAG, result);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

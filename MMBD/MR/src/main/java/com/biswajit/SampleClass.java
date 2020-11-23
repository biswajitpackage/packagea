package com.biswajit;

import android.util.Log;

import com.biswajit.mr.network_setup.NetWorkSetUp;
import com.biswajit.mr.network_setup.StaticContent;
import com.biswajit.mr.recycleview.RecycleviewB;

import org.json.JSONException;
import org.json.JSONObject;

public class SampleClass {
    public SampleClass() {
        StaticContent.modelname="modelFile";
        StaticContent.packagename="com.exno.mytesting";
        Log.d("bd_m_w","Sample Class");
        String json_s="{\n" +
                "\t\t\"name\": \"AAA1\",\n" +
                "\t  \t\"email\": \"AAA1\"\n" +
                "\t}";
        String layout_s="{\n" +
                "\t\"parent\": \"RelativeLayout\",\n" +
                "\t\"name\": \"t\",\n" +
                "\t\"email\": \"t\"\n" +
                "}";

        RecycleviewB recycleviewB=new RecycleviewB();

        JSONObject jsonObject1=new JSONObject();
        try {
            jsonObject1.put("api","shop-keyword-brand");
            jsonObject1.put("method","GET");
            jsonObject1.put("method_with","GET");
            jsonObject1.put("model", StaticContent.modelname);
            jsonObject1.put("email","Field");
            jsonObject1.put("category_id","Field");
            jsonObject1.put("name","Field");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        StaticContent.hm.put("getServerData",jsonObject1);
        try {
            new NetWorkSetUp().createNetworkInterfaceFolderFile(false);
        } catch (JSONException e) {
            e.printStackTrace();
        }




        try {
            recycleviewB.MainMethod("rv_1","MainActivity",StaticContent.modelname,"adapterName","xmlfilename",
                    "com.exno.myapplication","h",json_s,layout_s);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

package com.biswajit.mr.recycleview;

import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LayoutDesign {
    String adapterModelFile="";
    List<String>tagName=new ArrayList<String>();
    public void parentset(String string) {


        adapterModelFile+= "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<"+string+" xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:id=\"@+id/main_contant_id\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"wrap_content\"\n" +
                "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                "    android:layout_marginTop=\"12dp\"\n" +
                "    android:layout_margin=\"2dp\">\n" ;

        tagName.add("</"+string+">");
    }

    public void endTag() {
        Collections.reverse(tagName);
        for (String tag_name:tagName)
            adapterModelFile+=tag_name;
    }

    public void printAll() {
        Log.d("bd_m_w",adapterModelFile);
    }

    public void printTag(String key) {

        adapterModelFile+="\n<TextView\n" +
                "    android:layout_height=\"wrap_content\"\n" +
                "android:layout_width=\"wrap_content\"\n"+
                "    android:text=\"\"\n" +
                "    android:id=\"@+id/"+key+"_id\"/>\n";



    }
    public void printTagEditText(String key) {
        adapterModelFile+="\n<EditText\n" +
                "    android:layout_height=\"wrap_content\"\n" +
                "android:layout_width=\"wrap_content\"\n"+
                "    android:text=\"\"\n" +
                "    android:id=\"@+id/"+key+"_id\"/>\n";


    }
    public void printTagImageView(String key) {
        adapterModelFile+="\n<ImageView\n" +
                "            android:id=\"@+id/"+key+"\"\n" +
                "            android:layout_width=\"wrap_content\"\n" +
                "            android:layout_height=\"wrap_content\"\n" +
                "            android:layout_margin=\"5dp\"\n" +
                "            android:src=\"@drawable/ic_launcher\" />\n";


    }


}

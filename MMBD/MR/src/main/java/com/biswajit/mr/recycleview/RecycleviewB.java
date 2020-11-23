package com.biswajit.mr.recycleview;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.biswajit.mr.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecycleviewB {
    static int i=0,j=0;
    String package_name="";
    String recycleview_xml_id="";
    String modelName="";
    String MainActivity="";
    String recycleViewType="";
    String JsonForModel="";
    String layout="";
    String xmlFileName;
    public void MainMethod(String main_id,String MainActivity,String modelName,String adapterName,String xmlFileName,String package_name,String recycleViewType,String JsonForModel,String layout) throws JSONException {
        this.package_name=package_name;
        this.recycleview_xml_id=main_id;
        this.modelName=modelName;
        this.MainActivity=MainActivity;
        this.recycleViewType=recycleViewType;
        this.JsonForModel=JsonForModel;
        this.xmlFileName= xmlFileName;
        this.layout=layout;
        String file_name="1) "+MainActivity+".xml TAG\n"+
        "2) "+MainActivity+".java TAG\n"+
        "3) "+adapterName+".java TAG\n"+
        "4) "+modelName+".java TAG\n" +
        "5) "+xmlFileName+".xml TAG\n"        ;
        Log.d("bd_m_w",file_name);
        Log.d("bd_m_w","*************************");
        createMainRecycleViewProperty(main_id);

        createMainRecycleViewAdapter(adapterName);
        createMainRecycleViewAdapterFile(adapterName);
        //createMainRecycleViewAdapterModelFile(modelName);

        createMainRecycleViewAdapterModelFileCondition(modelName);
        createMainRecycleViewXmlFile(xmlFileName);
    }

    private void createMainRecycleViewAdapterModelFileCondition(String main_id) throws JSONException {
        i=0;
        j=0;
        Map<String,JSONObject> objectData=new HashMap<String,JSONObject>();
        objectData.clear();
        JSONObject jsonObject = null;
        JSONObject object=null;
        Iterator<String> innerKeys = null;
        Log.d("bd_m_w","4) "+main_id+".java in Model File");
        Log.d("bd_m_w","-------------------");
        String adapterModelFile="package "+package_name+";\n" +
                "\n" +
                "public class "+main_id+" {\n" ;
        try {
            jsonObject= new JSONObject(JsonForModel);
            Iterator<String> keys = jsonObject.keys();
            while(keys.hasNext()) {
                String key = keys.next();
                if(jsonObject.get(key) instanceof Boolean) {
                    adapterModelFile+="public boolean "+key+" = false;\n";
                }
                if(jsonObject.get(key) instanceof Integer) {
                    adapterModelFile+="public int "+key+";\n";
                }
                if(jsonObject.get(key) instanceof String) {
                    adapterModelFile+="public String "+key+"=\"\";\n";
                }
                if(jsonObject.get(key) instanceof Double) {
                    adapterModelFile+="public Double "+key+";\n";
                }
                if(jsonObject.get(key) instanceof Long) {
                    adapterModelFile+="public Long "+key+";\n";
                }
                if(jsonObject.get(key) instanceof JSONObject) {
                    i++;
                    String file_name=""+main_id+"SubModel_object_"+i+"SubModel";
                    adapterModelFile+="public "+file_name+" "+key+";\n";
                    object= (JSONObject)jsonObject.get(key);
                    objectData.put(file_name,object);
                }
                    if(jsonObject.get(key) instanceof JSONArray) {
                        j++;
                        String file_name=""+main_id+"SubModel_array_"+j+"SubModel";
                        adapterModelFile+="public List<"+main_id+""+file_name+"> "+key+";\n";
                        JSONArray array = (JSONArray) jsonObject.get(key);
                        object= (JSONObject) array.get(0);
                        objectData.put(file_name,object);
                        //innerKeys= object.keys();
                    /*while(innerKeys.hasNext())
                    {
                        String innerKey = innerKeys.next();
                        //Log.d("bd_m_w","*************************  :::innerKey::: "+innerKey);

                    }*/
                }
            }
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        adapterModelFile+="}\n";
        adapterModelFile+="------------------------------------------------------";
        Log.d("bd_m_w",adapterModelFile);
        for(Map.Entry m:objectData.entrySet())
        {
            createMainRecycleViewAdapterModelFile(""+m.getKey()+"SubModel", (JSONObject) m.getValue());
        }
        }


    public void createMainRecycleViewProperty(String main_id){

        Log.d("bd_m_w","1) MainActivity.xml TAG");
        Log.d("bd_m_w","-------------------");
        String xmlMail="<androidx.recyclerview.widget.RecyclerView\n" +
                "                android:layout_width=\"match_parent\"\n" +
                "                android:layout_height=\"wrap_content\"\n" +
                "                android:id=\"@+id/"+main_id+"\" />";
        Log.d("bd_m_w",xmlMail);
    }
    public void createMainRecycleViewAdapter(String adapter_name){

        Log.d("bd_m_w","2) "+adapter_name+" in activity");
        Log.d("bd_m_w","-------------------");
        String AdapterMail="1) RecyclerView "+recycleview_xml_id+";\n"
                +"2)  List<"+modelName+"> "+modelName+"_array_list=new ArrayList<"+modelName+">();\n" +
                "   "+modelName+"      "+modelName+"_object= new "+modelName+"();\n" +
                "        "+modelName+"_object.name=\"Test Name\";\n" +
                "        "+modelName+"_object.email=\"abc@email\";\n" +
                "        "+modelName+"_array_list.add("+modelName+"_object);\n" +
                "\n" +
                "   "+modelName+"      "+modelName+"_object2= new "+modelName+"();\n" +
                "        "+modelName+"_object.name=\"Test Name\";\n" +
                "        "+modelName+"_object.email=\"abc@email\";\n" +
                "        "+modelName+"_array_list.add("+modelName+"_object);\n" +
                "\n 3)" +
                "        "+recycleview_xml_id+"=findViewById(R.id."+recycleview_xml_id+");\n" +
                "        "+adapter_name+" "+adapter_name+"_adapter = new "+adapter_name+"("+modelName+"_array_list,"+MainActivity+".this);\n" +
                "        "+recycleview_xml_id+".setHasFixedSize(true);\n" ;
        //if (recycleViewType.trim().equals("grid")) {
        if (recycleViewType.contains("grid")){
            recycleViewType = recycleViewType.replaceAll("grid", "");

            AdapterMail += "        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(" + MainActivity + ".this, "+recycleViewType+");\n";
        }
        if (recycleViewType.contains("v")){
            //recycleViewType = recycleViewType.replaceAll("grid", "");

            AdapterMail += "        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(" + MainActivity + ".this);\n";
        }
        if (recycleViewType.contains("h")){
            //recycleViewType = recycleViewType.replaceAll("grid", "");

            AdapterMail += "RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(" + MainActivity + ".this, LinearLayoutManager.HORIZONTAL, false);\n";

        }

                        AdapterMail+=  "        "+recycleview_xml_id+".setLayoutManager(mLayoutManager);\n" +
                "        "+recycleview_xml_id+".setAdapter("+adapter_name+"_adapter);"
                ;
        Log.d("bd_m_w",AdapterMail);
    }
    private void createMainRecycleViewAdapterFile(String main_id) throws JSONException {
        Log.d("bd_m_w","3) "+main_id+".java in Adapter File");
        Log.d("bd_m_w","-------------------");
        String adapterFile="package "+package_name+";\n" +
                "\n" +
                "import android.content.Context;\n" +
                "import android.content.Intent;\n" +
                "import android.util.Log;\n" +
                "import android.view.LayoutInflater;\n" +
                "import android.view.View;\n" +
                "import android.view.ViewGroup;\n" +
                "import android.widget.Button;\n" +
                "import android.widget.ImageView;\n" +
                "import android.widget.LinearLayout;\n" +
                "import android.widget.RelativeLayout;\n" +
                "import android.widget.TextView;\n" +
                "\n" +
                "import androidx.annotation.NonNull;\n" +
                "import androidx.core.content.ContextCompat;\n" +
                "import androidx.recyclerview.widget.RecyclerView;\n" +
                "import java.util.List;\n" +
                "public class "+main_id+" extends  RecyclerView.Adapter<"+main_id+".ViewHolder> {\n" +
                "    private List<"+modelName+"> "+modelName+"item;\n" +
                "    public Context context;\n" +
                "    \n" +
                "\n" +
                "    public "+main_id+"(List<"+modelName+"> "+modelName+"item, Context context)\n" +
                "     {\n" +
                "        this."+modelName+"item="+modelName+"item;\n" +
                "        this.context=context;\n" +
                "        \n" +
                "     }\n" +
                "\n" +
                "\n" +
                "    @NonNull\n" +
                "    @Override\n" +
                "    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)\n" +
                "    {\n" +
                "        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());\n" +
                "        View listItem= layoutInflater.inflate(R.layout."+xmlFileName+", parent, false);\n" +
                "        ViewHolder viewHolder = new ViewHolder(listItem);\n" +
                "        return viewHolder;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                   " public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {\n" ;
        JSONObject jsonObject_layout= new JSONObject(layout);
        Iterator<String> keys = jsonObject_layout.keys();
        while(keys.hasNext())
        {
            String key = keys.next();

            if (!(key.equals("parent"))){
                adapterFile+="holder."+key+"_id.setText("+modelName+"item.get(position).name);\n" ;
               // layoutDesign.parentset(jsonObject_layout.getString(key));
            }

        }
            /*adapterFile+="holder.t1.setText("+modelName+"item.get(position).name);\n" +
                "        holder.t2.setText("+modelName+"item.get(position).email);\n" ;*/
                adapterFile+="    }\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "    @Override\n" +
                "    public int getItemCount()\n" +
                "    {\n" +
                "\n" +
                "        return "+modelName+"item.size();\n" +
                "    }\n" +
                "\n" +
                "    public static class ViewHolder extends RecyclerView.ViewHolder\n" +
                "    {\n" +
                "\n" ;
        JSONObject jsonObject_layout2= new JSONObject(layout);
        Iterator<String> keys2 = jsonObject_layout2.keys();
        LayoutDesign layoutDesign1=new LayoutDesign();
        while(keys2.hasNext()) {
            String key = keys2.next();
            if (!(key.equals("parent")))
            {

                //setTagXml(jsonObject_layout2,key,layoutDesign1);
                //adapterFile+="        public TextView t1,t2;\n" ;
                //layoutDesign.parentset(jsonObject_layout2.getString(key));
                if (jsonObject_layout2.getString(key).equals("t")){
                    //Log.d("bd_m_w","public TextView "+key+"_id;");
                    adapterFile+="public TextView "+key+"_id;\n";
                }
                if (jsonObject_layout2.getString(key).equals("e")){
                    //Log.d("bd_m_w","public EditText "+key+"_id;");
                    adapterFile+="public EditText "+key+"_id;\n";
                }
                if (jsonObject_layout2.getString(key).equals("i"))
                {
                    adapterFile+="public ImageView "+key+"_id;\n";
                    //Log.d("bd_m_w","public ImageView "+key+"_id;");
                }
            }
            else {
                adapterFile+=" public "+jsonObject_layout2.getString(key)+" main_contant_id;\n" ;
            }
        }

        adapterFile+=   "\n" +
                        "        public ViewHolder(View itemView) {\n" +
                        "            super(itemView);\n" ;
                        JSONObject jsonObject_layout3= new JSONObject(layout);
                        Iterator<String> keys3 = jsonObject_layout.keys();
        while(keys3.hasNext())
        {
            String key3 = keys3.next();
            if (key3.equals("parent"))
                adapterFile+=  "this.main_contant_id=itemView.findViewById(R.id.main_contant_id);\n" ;
                else
            adapterFile+=  "this."+key3+"_id=itemView.findViewById(R.id."+key3+"_id);\n" ;

        }
                adapterFile+=  "\n" +
                "            \n" +
                "        }\n" +
                "    }\n" +
                "    int StringToInt(String n){\n" +
                "\n" +
                "        try\n" +
                "        {\n" +
                "            return Integer.parseInt(n);\n" +
                "        }catch (Exception e)\n" +
                "        {\n" +
                "            return  0;\n" +
                "        }\n" +
                "\n" +
                "    }\n" +
                "}\n";
        Log.d("bd_m_w",adapterFile);
    }
    private void createMainRecycleViewAdapterModelFile(String main_id, JSONObject object) throws JSONException {
        Log.d("bd_m_w","4) "+main_id+".java in Model File");
        Log.d("bd_m_w","-------------------");
        Map<String,JSONObject> objectData2=new HashMap<String,JSONObject>();
        objectData2.clear();
        String adapterModelFile="package "+package_name+";\n" +
                "\n" +
                "public class "+main_id+" {\n" ;
                Iterator<String> innerKeys   = object.keys();
                    while(innerKeys.hasNext())
                    {
                        String key = innerKeys.next();
                        //Log.d("bd_m_w","****************KOL*********  :::innerKey::: "+innerKey);
                        if(object.get(key) instanceof Boolean) {
                            adapterModelFile+="public boolean "+key+" = false;\n";
                        }
                        if(object.get(key) instanceof Integer) {
                            adapterModelFile+="public int "+key+";\n";
                        }
                        if(object.get(key) instanceof String) {
                            adapterModelFile+="public String "+key+"=\"\";\n";
                        }
                        if(object.get(key) instanceof Double) {
                            adapterModelFile+="public Double "+key+";\n";
                        }
                        if(object.get(key) instanceof Long) {
                            adapterModelFile+="public Long "+key+";\n";
                        }
                        try {
                            if (object.get(key) instanceof JSONObject) {
                                i++;
                                String file_name = "" + main_id + "NextSubModel_object_" + i + "SubModel";
                                adapterModelFile += "public " + file_name + " " + key + ";\n";
                                object = (JSONObject) object.get(key);
                                objectData2.put(file_name, object);
                            }
                        }catch (Exception e){}
                        try {
                        if(object.get(key) instanceof JSONArray) {
                            j++;
                            String file_name=""+main_id+"NextSubModel_array_"+j+"SubModel";
                            adapterModelFile+="public List<"+main_id+""+file_name+"> "+key+";\n";
                            JSONArray array = (JSONArray) object.get(key);
                            object= (JSONObject) array.get(0);
                            objectData2.put(file_name,object);
                            //innerKeys= object.keys();
                    /*while(innerKeys.hasNext())
                    {
                        String innerKey = innerKeys.next();
                        //Log.d("bd_m_w","*************************  :::innerKey::: "+innerKey);

                    }*/
                        }
                    }catch (Exception e){}
                }
                adapterModelFile+="}\n";
        Log.d("bd_m_w",adapterModelFile);

        for(Map.Entry m:objectData2.entrySet())
        {
            createMainRecycleViewAdapterModelFile(""+m.getKey()+"", (JSONObject) m.getValue());
        }
    }

    private void createMainRecycleViewXmlFile(String main_id) throws JSONException {
        LayoutDesign layoutDesign=new LayoutDesign();
        Log.d("bd_m_w","6) "+main_id+" in Model File");
        Log.d("bd_m_w","-------------------");
        JSONObject jsonObject_layout= new JSONObject(layout);
        Iterator<String> keys = jsonObject_layout.keys();
        while(keys.hasNext())
        {
            String key = keys.next();

            if (key.equals("parent")){

                layoutDesign.parentset(jsonObject_layout.getString(key));
            }
            setTagXml(jsonObject_layout,key,layoutDesign);
            }
        layoutDesign.endTag();
        layoutDesign.printAll();

        String adapterModelFile="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:id=\"@+id/relativeLayout\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"wrap_content\"\n" +
                "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                "    android:layout_marginTop=\"12dp\"\n" +
                "    android:layout_margin=\"2dp\"\n" +
                "\n" +
                "    >\n" +
                "<TextView\n" +
                "    android:layout_height=\"wrap_content\"\n" +
                "    android:text=\"\"\n" +
                "    android:id=\"@+id/t1\"/>\n" +
                "    <TextView\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"wrap_content\"\n" +
                "    android:text=\"\"\n" +
                "    android:layout_below=\"@+id/t1\"\n" +
                "    android:id=\"@+id/t2\"/>\n" +
                "\n" +
                "</RelativeLayout>";
        //Log.d("bd_m_w",adapterModelFile);
    }
void setTagXml(JSONObject jsonObject_layout, String key, LayoutDesign layoutDesign) throws JSONException {

    if (jsonObject_layout.getString(key).equals("t")){
        layoutDesign.printTag(key);
    }
    if (jsonObject_layout.getString(key).equals("e")){
        layoutDesign.printTagEditText(key);
    }
    if (jsonObject_layout.getString(key).equals("i"))
    {
        layoutDesign.printTagImageView(key);
    }
}
}

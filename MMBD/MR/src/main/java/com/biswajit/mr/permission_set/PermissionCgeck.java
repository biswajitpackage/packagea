package com.biswajit.mr.permission_set;

import android.Manifest;
import android.util.Log;

import androidx.core.content.ContextCompat;

import java.util.List;

public class PermissionCgeck {
    String packageName;
    public PermissionCgeck(String packageName) {
        this.packageName=packageName;
    }

    public void PermissionCgeckWithPlashScreen(List<String> allPermossion,String MainFileName,String main_layout){
        String allPermission="";
        Log.d("bd_m_w","///////////////////////////////////////\n");
        Log.d("bd_m_w","Permission With PlashScreen\n");
        Log.d("bd_m_w","///////////////////////////////////////\n");
        allPermission+="activity_splash.xml\n";
        allPermission+="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\"\n" +
                "    >\n" +
                "    <ImageView\n" +
                "        android:background=\"@drawable/background\"\n" +
                "        android:layout_height=\"match_parent\"\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        />\n" +
                "    <ImageView\n" +
                "        android:src=\"@drawable/logo\"\n" +
                "        android:layout_height=\"250dp\"\n" +
                "        android:layout_width=\"250dp\"\n" +
                "        android:layout_centerInParent=\"true\"/>\n" +
                "\n" +
                "</RelativeLayout>\n";
        allPermission+=""+MainFileName+".java\n";
        allPermission+="package "+packageName+";\n" +
                "\n" +
                "import androidx.appcompat.app.AlertDialog;\n" +
                "import androidx.appcompat.app.AppCompatActivity;\n" +
                "import androidx.core.app.ActivityCompat;\n" +
                "import androidx.core.content.ContextCompat;\n" +
                "\n" +
                "import android.Manifest;\n" +
                "import android.content.DialogInterface;\n" +
                "import android.content.Intent;\n" +
                "import android.content.pm.PackageManager;\n" +
                "import android.os.Build;\n" +
                "import android.os.Bundle;\n" +
                "import android.os.Handler;\n" +
                "import android.util.Log;\n" +
                "import android.widget.PopupMenu;\n" +
                "import android.widget.Toast;\n" +
                "\n" +

                "\n" +
                "public class "+MainFileName+" extends AppCompatActivity {\n" +
                "    private static int SPLASH_SCREEN_TIME_OUT=2000;\n" +
                "    private static final int MY_PERMISSIONS_REQUEST_CODE = 123;\n" +
                "    //Prefs prefs;\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout."+main_layout+");\n" +
                "        //prefs = new Prefs("+MainFileName+".this);\n" +
                "        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){\n" +
                "            checkPermission();\n" +
                "        }\n" +
                "        else\n" +
                "            {\n" +
                "             navigationMethod();\n" +
                "            }\n" +
                "\n" +
                "    }\n" +
                "    void navigationMethod(){\n" +
                "        new Handler().postDelayed(new Runnable() {\n" +
                "            @Override\n" +
                "            public void run() {\n" +
                "                navigation();\n" +
                "            }\n" +
                "        }, SPLASH_SCREEN_TIME_OUT);\n" +
                "    }\n" +
                "    void navigation(){\n" +
                "        Intent i=null;\n" +
                "        if (prefs.getData(\"Token\").equals(\"\"))\n" +
                "        i=new Intent("+MainFileName+".this, ActivityLogin.class);\n" +
                "        else\n" +
                "        i=new Intent("+MainFileName+".this, HomeActivity.class);\n" +
                "        startActivity(i);\n" +
                "        finish();\n" +
                "    }\n" +
                "    //checkPermission\n" +
                "    protected void checkPermission(){\n" +
                "        if(";
                String temp="";
                for(String s:allPermossion){
                    temp+="ContextCompat.checkSelfPermission("+MainFileName+".this,Manifest.permission."+s+") + \n";
                }
                StringBuffer sb= new StringBuffer(temp);
                sb.deleteCharAt(sb.lastIndexOf("+"));
                //allPermission+= temp.replaceAll(" +$", "");;
                allPermission+=sb.toString();
                allPermission+="\n" +
                "                != PackageManager.PERMISSION_GRANTED){\n" +
                "\n" ;
                temp="if(";
                for(String s:allPermossion){
                    temp+="ActivityCompat.shouldShowRequestPermissionRationale("+MainFileName+".this,Manifest.permission."+s+") || \n";
                }
                StringBuffer sb2= new StringBuffer(temp);
                sb2.deleteCharAt(sb2.lastIndexOf("||"));
                StringBuffer sb3= new StringBuffer(sb2.toString());
                sb3.deleteCharAt(sb3.lastIndexOf("|"));
                /*allPermission+="// Do something, when permissions not granted\n" +
                "            if(ActivityCompat.shouldShowRequestPermissionRationale(\n" +
                "                    "+MainFileName+".this,Manifest.permission.CAMERA) || ActivityCompat.shouldShowRequestPermissionRationale(\n" +
                "                    "+MainFileName+".this,Manifest.permission.ACCESS_FINE_LOCATION)\n" +
                "                    || ActivityCompat.shouldShowRequestPermissionRationale(\n" +
                "                    "+MainFileName+".this,Manifest.permission.ACCESS_COARSE_LOCATION)|| ActivityCompat.shouldShowRequestPermissionRationale(\n" +
                "                    "+MainFileName+".this,Manifest.permission.READ_EXTERNAL_STORAGE)|| ActivityCompat.shouldShowRequestPermissionRationale(\n" +
                "                    "+MainFileName+".this,Manifest.permission.WRITE_EXTERNAL_STORAGE))" ;*/
                allPermission+=sb3.toString();
                allPermission+=       "){\n" +
                "                // If we should give explanation of requested permissions\n" +
                "\n/*" ;
        Log.d("bd_m_w",allPermission);
                allPermission= "*/// Show an alert dialog here with request explanation\n" +
                "                AlertDialog.Builder builder = new AlertDialog.Builder("+MainFileName+".this);\n" +
                "                builder.setMessage(\"" ;
        temp="";
        /*for(String s:allPermossion){
            temp+="ContextCompat.checkSelfPermission("+MainFileName+".this,Manifest.permission."+s+") , \n";
        }*/
        if (allPermossion.size()>0)
            if (allPermossion.size()==1) {
                temp = allPermossion.get(0)+" permission is";

            }
            else
            {
                for(int i=0;i<allPermossion.size()-1;i++){
                    temp+=allPermossion.get(i)+" , ";
                }
                temp+=" and "+allPermossion.get(allPermossion.size()-1)+" permissions are ";
            }
        StringBuffer sb7= new StringBuffer(temp);
        sb7.deleteCharAt(sb7.lastIndexOf(","));
        allPermission+=sb7.toString();
            allPermission+="   required to do the task.\");\n" +
                "                builder.setTitle(\"Please grant those permissions\");\n" +
                "                builder.setPositiveButton(\"OK\", new DialogInterface.OnClickListener() {\n" +
                "                    @Override\n" +
                "                    public void onClick(DialogInterface dialogInterface, int i) {\n" +
                "                        ActivityCompat.requestPermissions(\n" +
                "                                "+MainFileName+".this,\n" +
                "                                new String[]\n" +
                "                                        {\n" ;
        allPermission+=

                temp="";
                for(String s:allPermossion){
                temp+="Manifest.permission."+s+", \n";
                }
                StringBuffer sb4= new StringBuffer(temp);
                sb4.deleteCharAt(sb4.lastIndexOf(","));
                /*"                                                Manifest.permission.CAMERA,\n" +
                "                                                Manifest.permission.ACCESS_FINE_LOCATION,\n" +
                "                                                Manifest.permission.ACCESS_COARSE_LOCATION,\n" +
                "                                                Manifest.permission.READ_EXTERNAL_STORAGE,\n" +
                "                                                Manifest.permission.WRITE_EXTERNAL_STORAGE\n" ;
                allPermission+="                                        },\n" +*/
                allPermission+=temp;
                allPermission+="                 }" +
                ",MY_PERMISSIONS_REQUEST_CODE\n" +
                "                        );\n" +
                "                    }\n" +
                "                });\n" +
                "                builder.setNeutralButton(\"Cancel\",new DialogInterface.OnClickListener() {\n" +
                "                    public void onClick(DialogInterface dlg, int sumthin) {\n" +
                "                        startActivity(new Intent("+MainFileName+".this,"+MainFileName+".class));\n" +
                "                    }\n" +
                "                });\n" +
                "\n" +
                "                AlertDialog dialog = builder.create();\n" +
                "                dialog.show();\n" +
                "            }else{\n" +
                "                // Directly request for required permissions, without explanation\n" +
                "                ActivityCompat.requestPermissions(\n" +
                "                        "+MainFileName+".this,\n" ;
                allPermission+="                          new String[]{\n" ;
        temp="";
        for(String s:allPermossion){
            temp+="Manifest.permission."+s+", \n";
        }
        StringBuffer sb5= new StringBuffer(temp);
        sb5.deleteCharAt(sb5.lastIndexOf(","));
        allPermission+=sb5;

               /* "                                Manifest.permission.CAMERA,\n" +
                "                                Manifest.permission.ACCESS_FINE_LOCATION,\n" +
                "                                Manifest.permission.ACCESS_COARSE_LOCATION,\n" +
                "                                Manifest.permission.READ_EXTERNAL_STORAGE,\n" +
                "                                Manifest.permission.WRITE_EXTERNAL_STORAGE\n" ;*/
                allPermission+="                        },\n" +
                "                        MY_PERMISSIONS_REQUEST_CODE\n" +
                "                );\n" +
                "            }\n" +
                "        }else {\n" +
                "            navigation();\n" +
                "        }\n" +
                "    }\n" +
                "    @Override\n" +
                "    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){\n" +
                "        switch (requestCode){\n" +
                "            case MY_PERMISSIONS_REQUEST_CODE:{\n" +
                "                // When request is cancelled, the results array are empty\n" +
                "\n" +
                "                if(\n" +
                "                        (grantResults.length >0) &&\n" +
                "                                (" ;

        temp="";
        int i=0;
        for(String s:allPermossion){
        temp+="grantResults["+i+"] + \n";
        i++;
        }
        StringBuffer sb6= new StringBuffer(temp);
        sb6.deleteCharAt(sb6.lastIndexOf("+"));
        allPermission+=sb6;
        allPermission+="== PackageManager.PERMISSION_GRANTED\n" +
                "                                )\n" +
                "                ){\n" +
                "                    navigation();\n" +
                "                }else {\n" +
                "                        startActivity(new Intent("+MainFileName+".this,"+MainFileName+".class));\n" +
                "                      }\n" +
                "\n" +
                "                return;\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}\n\n";

        Log.d("bd_m_w",allPermission+"///////////////////////////////////////");

    }
}

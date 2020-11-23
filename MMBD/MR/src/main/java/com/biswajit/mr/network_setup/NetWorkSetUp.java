package com.biswajit.mr.network_setup;

import android.app.Activity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;

public class NetWorkSetUp {
    String PackageName=StaticContent.packagename;
    String ModelName=StaticContent.modelname;
    String functionName="";
    JSONObject jsondata=null;
    public NetWorkSetUp() {

        Log.d("bd_m_w","///////////////////////////////////////\n");
        Log.d("bd_m_w","Newwork\n");
        Log.d("bd_m_w","///////////////////////////////////////\n");
        Log.d("bd_m_w","Create Folder\n");
        Log.d("bd_m_w","Folder Fragments\n");
        Log.d("bd_m_w","Folder Models\n");
        Log.d("bd_m_w","Folder Network\n");
        Log.d("bd_m_w","Folder Utilities\n");
        Log.d("bd_m_w","----------------------------------------\n");
        callDependency();
        createUtilitiesFile();
        createNetworkFolderFile();
        //createNetworkInterfaceFolderFile(true);

    }

    private void callDependency() {
        Log.d("bd_m_w","///////////////////////////////////////\n");
        Log.d("bd_m_w","Dependency\n");
        Log.d("bd_m_w","///////////////////////////////////////\n");
        String dep="implementation 'androidx.appcompat:appcompat:1.2.0'\n" +
                "    implementation 'com.google.android.material:material:1.2.1'\n" +
                "    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'\n" +
                "    testImplementation 'junit:junit:4.+'\n" +
                "    androidTestImplementation 'androidx.test.ext:junit:1.1.2'\n" +
                "    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'\n" +
                "\n" +
                "    //gif holder\n" +
                "    implementation 'pl.droidsonroids.gif:android-gif-drawable:1.2.16'\n" +
                "\n" +
                "    // Retrofit\n" +
                "    implementation 'com.squareup.retrofit2:retrofit:2.3.0'\n" +
                "    implementation 'com.squareup.retrofit2:converter-gson:2.2.0'\n" +
                "    implementation 'com.squareup.okhttp:okhttp:2.4.0'\n" +
                "    implementation 'com.google.code.gson:gson:2.6.2'\n" +
                "    implementation 'androidx.legacy:legacy-support-v4:1.0.0'\n" +
                "\n" +
                "    testImplementation 'junit:junit:4.12'\n" +
                "    androidTestImplementation 'androidx.test.ext:junit:1.1.2'\n" +
                "    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'\n" +
                "    implementation 'com.google.android.material:material:1.0.0'\n" +
                "\n" +
                "    implementation 'com.github.smarteist:autoimageslider:1.3.9'\n" +
                "    implementation 'com.github.smarteist:autoimageslider:1.3.9-appcompat'\n" +
                "\n" +
                "    implementation 'com.github.bumptech.glide:glide:4.9.0'\n" +
                "    annotationProcessor 'com.github.bumptech.glide:compiler:4.9.0'\n" +
                "    implementation 'androidx.cardview:cardview:1.0.0'\n" +
                "    //androidTestImplementation 'androidx.test:runner:1.1.1'\n" +
                "\n" +
                "    implementation 'com.github.varunest:sparkbutton:1.0.6'\n" +
                "    implementation 'com.rishabhharit.roundedimageview:RoundedImageView:0.8.4'\n" +
                "    implementation 'com.makeramen:roundedimageview:2.3.0'\n" +
                "    implementation 'de.hdodenhof:circleimageview:3.1.0'\n" +
                "\n" +
                "    implementation(\"com.squareup.okhttp3:logging-interceptor:4.9.0\")\n"+
                "\n\n\n\n\n"+"google()\n" +
                "        jcenter()\n" +
                "        google()\n" +
                "        jcenter()\n" +
                "        mavenCentral()\n" +
                "        maven { url \"https://jitpack.io\" }";
        Log.d("bd_m_w",dep+"\n");

    }

    public void createNetworkInterfaceFolderFile(Boolean isFile) throws JSONException {
        Log.d("bd_m_w","Network File\n");
        Log.d("bd_m_w","----------------------------------------\n");
        Log.d("bd_m_w","ApiInterface.java\n");

        if (isFile){
        createSampleInterface();
        }
        else {

            for (Map.Entry<String, JSONObject> me : StaticContent.hm.entrySet()) {
                String apiMethod="";
                JSONObject jsonObject=new JSONObject(String.valueOf(me.getValue()));
                Iterator<String> keys = jsonObject. keys();
                Iterator<String> keys2=keys;
                Iterator<String> keys3=keys;
                functionName=me.getKey();
                jsondata=me.getValue();

                /*while(keys. hasNext())
                {
                    String key = keys. next();
                    apiMethod+="@"+jsonObject.getString("method")+"(\""+jsonObject.getString("api")+"\")\n";
                    apiMethod+="Call<";
                    apiMethod+=StaticContent.modelname+">"+me.getKey()+"(";
                    *//*if (!(key.equals("api") || key.equals("method") || key.equals("method_with") || key.equals("model"))){
                        apiMethod+="@"+jsonObject.getString(key)+"(\""+key+"\") String "+key+",\n";
                    }*//*

                }

                while(keys3. hasNext())
                {
                String key3 = keys3. next();
                    apiMethod+=keys3+"\n";
                if (!(key3.equals("api") || key3.equals("method") || key3.equals("method_with") || key3.equals("model"))){
                apiMethod+="@"+jsonObject.getString(key3)+"(\""+key3+"\") String "+key3+",\n";
                }

                }
                apiMethod+=");";*/



                apiMethod+="\n" ;
                while(keys2. hasNext()) {
                    String key2 = keys2. next();
                    if (!(key2.equals("api") || key2.equals("method") || key2.equals("method_with") || key2.equals("model"))){
                        if (jsonObject.getString(key2).equals("Field")) {
                            apiMethod+="@FormUrlEncoded\n";
                            break;
                        }
                    }
                }
                apiMethod+=""+"@"+jsonObject.getString("method")+"(\""+jsonObject.getString("api")+"\")\n" +
                        "    Call<"+StaticContent.modelname+"> "+me.getKey()+"(" +
                        "" ;
                while(keys. hasNext()) {
                    String key = keys.next();
                    if (!(key.equals("api") || key.equals("method") || key.equals("method_with") || key.equals("model"))){
                        apiMethod+="@"+jsonObject.getString(key)+"(\""+key+"\") String "+key+",\n" ;
                    }
                }

                apiMethod+=");";
                /*if (!(me.getKey().equals("api") || me.getKey().equals("method") || me.getKey().equals("method_with") || me.getKey().equals("model"))){
                    apiMethod+=me.getKey();
                }
                if (me.getValue().getString("method").equals("g"))
                    apiMethod+="@GET(\""+me.getKey();
                //Log.d("bd_m_w","@GET(\""+me.getKey());
                if (me.getValue().getString("method_with").equals("g"))
                    apiMethod+="@GET(\""+me.getKey()+"/{id}";
                    //Log.d("bd_m_w","@GET(\""+me.getKey()+"/{id}");
                apiMethod+="\")";*/

                //System.out.print(me.getKey() + ":");
                //System.out.println(me.getValue());
                /*if (!(me.getKey().equals("api") || me.getKey().equals("method") || me.getKey().equals("method_with") || me.getKey().equals("model")))
                {
                    if (me.getValue().equals("f")) {
                            Log.d("bd_m_w","@FormUrlEncoded\n");
                    }
                }
                if ((me.getKey().equals("api") || me.getKey().equals("method") || me.getKey().equals("method_with") || me.getKey().equals("model")))
                {
                    if (me.getKey().equals("api")) {

                    }
                    if (me.getKey().equals("api")) {

                        Log.d("bd_m_w","@"+me.getValue()+"(\"categories\")\n");
                    }
                    //777777777777777
                }
                if (!(me.getKey().equals("api") || me.getKey().equals("method") || me.getKey().equals("method_with") || me.getKey().equals("model")))
                {

                }

                else {

                }*/
                Log.d("bd_m_w",apiMethod);
            }
            callServerCall();
        }
    }

    private void callServerCall() {

        Log.d("bd_m_w","MainActivity\n");
        Log.d("bd_m_w","----------------------------------------\n");
        Log.d("bd_m_w","MainActivity tag server call\n");
        String apiCall="\n";
        apiCall+="ApiManager manager = new ApiManager();\n" +
                "    Loader loader;\n" +
                "    Prefs prefs;\n" +
                "\n\n\n"+"" +
                "loader = new Loader();\n" +
                "        prefs = new Prefs(ActivityRegister.this);\n"
        ;
        apiCall+="private void callServerFor"+functionName+"(String f_name, String l_name, String u_gend, String u_email, String u_mob, String type, String u_pass, String s) {\n" +
                "        loader.showDialog(ActivityRegister.this);\n" +
                "        manager.service."+functionName+"(f_Name, l_Name, u_Gend, u_Email, u_Mob, type, u_Pass, s).enqueue(new Callback<"+StaticContent.modelname+">() {\n" +
                "            @Override\n" +
                "            public void onResponse(Call<"+StaticContent.modelname+"> call, Response<"+StaticContent.modelname+"> response) {\n" +
                "                if (response.isSuccessful()){\n" +
                "                    loader.hideDialog();\n" +
                "                    if (response.body().success == true){\n" +
                "                        \n" +
                "\n" +
                "                    }else{\n" +
                "                        Toast.makeText(ActivityRegister.this, \"Login failed\", Toast.LENGTH_SHORT).show();\n" +
                "                    }\n" +
                "                }else {\n" +
                "                    loader.hideDialog();\n" +
                "                    Toast.makeText(ActivityRegister.this, \"No response from the server! Please Try again!\", Toast.LENGTH_SHORT).show();\n" +
                "                }\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onFailure(Call<"+StaticContent.modelname+"> call, Throwable t)\n" +
                "            {\n" +
                "                loader.hideDialog();\n" +
                "                Toast.makeText(ActivityRegister.this, \"Network error! Please check internet connection and try again...\", Toast.LENGTH_SHORT).show();\n" +
                "\n" +
                "            }\n" +
                "        });\n" +
                "    }";
        Log.d("bd_m_w",apiCall+"\n");
    }

    private void createSampleInterface() {
        String sampleInterface="package "+PackageName+".Network;\n" +
                "\n" +
                "\n" +
                "\n" +
                "import okhttp3.MultipartBody;\n" +
                "import retrofit2.Call;\n" +
                "import retrofit2.http.DELETE;\n" +
                "import retrofit2.http.Field;\n" +
                "import retrofit2.http.FormUrlEncoded;\n" +
                "import retrofit2.http.GET;\n" +
                "import retrofit2.http.Multipart;\n" +
                "import retrofit2.http.POST;\n" +
                "import retrofit2.http.Part;\n" +
                "import retrofit2.http.Path;\n" +
                "\n" +
                "public interface ApiInterface\n" +
                "{\n" +
                "\n" +
                "\n" +
                "    @GET(\"categories\")\n" +
                "    Call<Category_model> getCategory();\n" +
                "    @GET(\"categories/{id}\")\n" +
                "    Call<ProductModel> getProduct(@Path(\"id\") String id);\n" +
                "    @FormUrlEncoded\n" +
                "    @POST(\"shop\")\n" +
                "    Call<ProductModel> getSearchProduct(@Field(\"keyword\") String keyword,\n" +
                "                                         @Field(\"category_id\") String category_id,\n" +
                "                                         @Field(\"sort_by\") String sort_by,\n" +
                "                                         @Field(\"min_price\") String min_price,\n" +
                "                                         @Field(\"max_price\") String max_price,\n" +
                "                                         @Field(\"limit\") String limit,\n" +
                "                                         @Field(\"page\") String page);\n" +
                "\n" +
                "\n" +
                "\n" +
                "    @FormUrlEncoded\n" +
                "    @POST(\"page\")\n" +
                "    Call<PageModel> getPage(@Field(\"page_id\") String keyword);\n" +
                "\n" +
                "\n" +
                "    /*@GET(\"index.php/{id}\")\n" +
                "    Call<ProductModel> getProduct(@Path(\"id\") String id);*/\n" +
                "\n" +
                "    @POST(\"wishlist/add/{id}\")\n" +
                "    Call<FabModel> wishlistAdd(@Path(\"id\") String id);\n" +
                "    @DELETE(\"wishlist/del/{id}\")\n" +
                "    Call<FabModel> wishlistDel(@Path(\"id\") String id);\n" +
                "    /*@FormUrlEncoded\n" +
                "    @POST(\"add-to-cart/{id}\")\n" +
                "    Call<AddToCartModel> addToCart(@Field(\"id\") String id);*/\n" +
                "\n" +
                "    @POST(\"add-to-cart/{id}\")\n" +
                "    Call<AddToCartModel> addToCart(@Path(\"id\") String id);\n" +
                "    @POST(\"incr-from-cart/{id}\")\n" +
                "    Call<AddToCartModel> incrToCart(@Path(\"id\") String id);\n" +
                "    @POST(\"decr-from-cart/{id}\")\n" +
                "    Call<AddToCartModel> decrToCart(@Path(\"id\") String id);\n" +
                "    @DELETE(\"remove-from-cart/{id}\")\n" +
                "    Call<AddToCartModel> removeFromCart(@Path(\"id\") String id);\n" +
                "\n" +
                "\n" +
                "    /*@POST(\"index.php/{id}\")\n" +
                "    Call<AddToCartModel> addToCart(@Path(\"id\") String id);*/\n" +
                "\n" +
                "\n" +
                "    @GET(\"wishlist\")\n" +
                "    Call<FavModel> getWishlist();\n" +
                "\n" +
                "    @GET(\"main-banners\")\n" +
                "    Call<Banner_model> getBanner();\n" +
                "    @GET(\"offer-banners\")\n" +
                "    Call<Offer_model> getOffer();\n" +
                "\n" +
                "    @FormUrlEncoded\n" +
                "    @POST(\"login\")\n" +
                "    Call<LoginModel> getLogin(@Field(\"email\") String email,\n" +
                "                              @Field(\"password\") String password);\n" +
                "    @FormUrlEncoded\n" +
                "    @POST(\"shop-keyword-brand\")\n" +
                "    Call<BrandModel> getBrand(@Field(\"keywords\") String keywords,\n" +
                "                              @Field(\"category_id\") String category_id);\n" +
                "\n" +
                "\n" +
                "    @FormUrlEncoded\n" +
                "    @POST(\"register\")\n" +
                "    Call<RegisterModel> getRegister(@Field(\"first_name\") String first_name,\n" +
                "                                    @Field(\"last_name\") String last_name,\n" +
                "                                    @Field(\"gender\") String gender,\n" +
                "                                    @Field(\"email\") String email,\n" +
                "                                    @Field(\"phone\") String phone,\n" +
                "                                    @Field(\"reg_type\") String reg_type,\n" +
                "                                    @Field(\"password\") String password,\n" +
                "                                    @Field(\"phone_verified\") String phone_verified);\n" +
                "\n" +
                "    @GET(\"profile-details\")\n" +
                "    Call<ProfileModel> getProfile();\n" +
                "    @GET(\"order-list\")\n" +
                "    Call<OrderDetailsModel> getOrderDetails();\n" +
                "\n" +
                "\n" +
                "    @FormUrlEncoded\n" +
                "    @POST(\"update-pass\")\n" +
                "    Call<ChangePasswordModel> updatePass(@Field(\"password\") String password);\n" +
                "\n" +
                "    @FormUrlEncoded\n" +
                "    @POST(\"update-profile\")\n" +
                "    Call<UpdateProfileModel> getUpdatedProfile(@Field(\"first_name\") String first_name,\n" +
                "                                               @Field(\"last_name\") String last_name,\n" +
                "                                               @Field(\"gender\") String gender,\n" +
                "                                               @Field(\"email\") String email,\n" +
                "                                               @Field(\"phone\") String phone);\n" +
                "    @Multipart\n" +
                "    @POST(\"upload-image\")\n" +
                "    Call<UpdateProfileImgModel> UpdatePrfImage(@Part MultipartBody.Part profile_img);\n" +
                "\n" +
                "    @GET(\"carts\")\n" +
                "    Call<CartListModel> getCartItems();\n" +
                "\n" +
                "    @GET(\"address\")\n" +
                "    Call<AddressListModel> getAddressList();\n" +
                "\n" +
                "    @FormUrlEncoded\n" +
                "    @POST(\"address/add\")\n" +
                "    Call<AddAddressModel> saveAddress(@Field(\"entry_firstname\") String entry_firstname,\n" +
                "                                      @Field(\"entry_lastname\") String entry_lastname,\n" +
                "                                      @Field(\"entry_street_address\") String entry_street_address,\n" +
                "                                      @Field(\"entry_postcode\") String entry_postcode,\n" +
                "                                      @Field(\"entry_city\") String entry_city,\n" +
                "                                      @Field(\"entry_state\") String entry_state,\n" +
                "                                      @Field(\"entry_country_id\") String entry_country_id,\n" +
                "                                      @Field(\"entry_phone\") String entry_phone,\n" +
                "                                      @Field(\"entry_landmark\") String entry_landmark,\n" +
                "                                      @Field(\"user_id\") String user_id);\n" +
                "\n" +
                "    @FormUrlEncoded\n" +
                "    @POST(\"address/update\")\n" +
                "    Call<UpdateAddressModel> updateAddress(@Field(\"entry_firstname\") String entry_firstname,\n" +
                "                                           @Field(\"entry_lastname\") String entry_lastname,\n" +
                "                                           @Field(\"entry_street_address\") String entry_street_address,\n" +
                "                                           @Field(\"entry_postcode\") String entry_postcode,\n" +
                "                                           @Field(\"entry_city\") String entry_city,\n" +
                "                                           @Field(\"entry_state\") String entry_state,\n" +
                "                                           @Field(\"entry_phone\") String entry_phone,\n" +
                "                                           @Field(\"entry_landmark\") String entry_landmark);\n" +
                "\n" +
                "\n" +
                "    @DELETE(\"address/del/id\")\n" +
                "    Call<DeleteAddressModel> deleteAddress(@Path(\"id\") String id);\n" +
                "\n" +
                "    @Multipart\n" +
                "    @POST(\"upload-order-image\")\n" +
                "    Call<UpdateProfileImgModel> UploadOrderImage(@Part MultipartBody.Part image);\n" +
                "\n" +
                "    @FormUrlEncoded\n" +
                "    @POST(\"upload-order-text\")\n" +
                "    Call<TextOrderModel> uploadTextOrder(@Field(\"text\") String text);\n" +
                "\n" +
                "    @FormUrlEncoded\n" +
                "    @POST(\"order-add\")\n" +
                "    Call<PlaceOrderModel> placeOrder(@Field(\"billing_address_id\") String billing_address_id,\n" +
                "                                     @Field(\"shifting_address_id\") String shifting_address_id,\n" +
                "                                     @Field(\"shipping_method\") String shipping_method,\n" +
                "                                     @Field(\"payment_method\") String payment_method,\n" +
                "                                     @Field(\"transaction_id\") String transaction_id);\n" +
                "\n" +
                "    @FormUrlEncoded\n" +
                "    @POST(\"shop-keyword-category\")\n" +
                "    Call<SearchByCatModel> searchByCategory(@Field(\"keyword\") String keyword);\n" +
                "}\n";
        Log.d("bd_m_w",sampleInterface+"\n");
    }

    private void createNetworkFolderFile() {
        Log.d("bd_m_w","Network File\n");
        Log.d("bd_m_w","----------------------------------------\n");
        Log.d("bd_m_w","Constants.java\n");
        String Constants="package "+PackageName+".Network;\n" +
                "\n" +
                "public class Constants {\n" +
                "    public static String BASE_URL = \"https://rentapg.com/hh-api/api/\";\n" +
                "    public static String IMAGE_URL = \"https://rentapg.com/hh-api/\";\n" +
                "\n" +
                "   // public static String BASE_URL = \"http://192.168.42.214/hh/\";\n" +
                "}\n";
        Log.d("bd_m_w",Constants+"\n");
        Log.d("bd_m_w","----------------------------------------\n");
        Log.d("bd_m_w","ApiManager.java\n");
        String Apimanager="package "+PackageName+".Network;\n" +
                "\n" +
                "import android.util.Log;\n" +
                "\n" +
                "import com.exnovation.helpershand.Utilities.App;\n" +
                "import com.google.gson.Gson;\n" +
                "import com.google.gson.GsonBuilder;\n" +
                "\n" +
                "import java.io.IOException;\n" +
                "import java.util.concurrent.TimeUnit;\n" +
                "\n" +
                "import okhttp3.Interceptor;\n" +
                "import okhttp3.MediaType;\n" +
                "import okhttp3.OkHttpClient;\n" +
                "import okhttp3.Request;\n" +
                "import okhttp3.Response;\n" +
                "import okhttp3.logging.HttpLoggingInterceptor;\n" +
                "import retrofit2.Retrofit;\n" +
                "import retrofit2.converter.gson.GsonConverterFactory;\n" +
                "\n" +
                "public class ApiManager {\n" +
                "    public static final MediaType JSON = MediaType.parse(\"application/json; charset=utf-8\");\n" +
                "    public ApiInterface service;\n" +
                "\n" +
                "\n" +
                "    public ApiManager()\n" +
                "    {\n" +
                "\n" +
                "        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();\n" +
                "        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);\n" +
                "\n" +
                "\n" +
                "        OkHttpClient client= new OkHttpClient.Builder()\n" +
                "                .readTimeout(120, TimeUnit.SECONDS)\n" +
                "                .writeTimeout(120, TimeUnit.SECONDS)\n" +
                "                .connectTimeout(120, TimeUnit.SECONDS)\n" +
                "                .addInterceptor(httpLoggingInterceptor)\n" +
                "                .addInterceptor(new Interceptor() {\n" +
                "                    @Override\n" +
                "                    public Response intercept(Chain chain) throws IOException {\n" +
                "                        Request original = chain.request();\n" +
                "\n" +
                "                        Request request = original.newBuilder()\n" +
                "                                .header(\"Content-Type\", \"application/json\")\n" +
                "                                .header(\"Authorization\", \"Bearer \" + App.token)\n" +
                "                                .method(original.method(), original.body())\n" +
                "                                .build();\n" +
                "\n" +
                "                        return chain.proceed(request);\n" +
                "                    }\n" +
                "                })\n" +
                "                .build();\n" +
                "\n" +
                "        /*OkHttpClient client = new OkHttpClient.Builder()\n" +
                "                .addInterceptor(new BasicInterceptor(\"admin\", \"1234\"))\n" +
                "                .build();*/\n" +
                "        Gson gson = new GsonBuilder()\n" +
                "                .setLenient()\n" +
                "                .create();\n" +
                "        Retrofit retrofit = new Retrofit.Builder()\n" +
                "                .baseUrl(Constants.BASE_URL)\n" +
                "                .addConverterFactory(GsonConverterFactory.create(gson))\n" +
                "\n" +
                "                .client(client)\n" +
                "                .build();\n" +
                "\n" +
                "        service = retrofit.create(ApiInterface.class);\n" +
                "    }\n" +
                "}\n";
        Log.d("bd_m_w",Apimanager+"\n");
    }

    private void createUtilitiesFile() {
        Log.d("bd_m_w","Utilities File\n");
        Log.d("bd_m_w","----------------------------------------\n");
        Log.d("bd_m_w","App.java\n");
        String print_code="package  "+PackageName+".Utilities;\n" +
                "\n" +
                "\n" +
                "public class App {\n" +
                "    public static String token=\"\";\n" +
                "    \n" +
                "}\n";
        Log.d("bd_m_w",print_code+"\n");
        Log.d("bd_m_w","----------------------------------------\n");
        Log.d("bd_m_w","Prefs.java\n");
        Log.d("bd_m_w","----------------------------------------\n");
        String pref_string="package "+PackageName+".Utilities;\n" +
                "\n" +
                "import android.content.Context;\n" +
                "import android.content.SharedPreferences;\n" +
                "\n" +
                "public class Prefs {\n" +
                "    Context context;\n" +
                "\n" +
                "    public Prefs(Context context) {\n" +
                "        this.context = context;\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    public void saveData(String key,String val){\n" +
                "        SharedPreferences preferences=context.getSharedPreferences(\"MYDATA\",Context.MODE_PRIVATE);\n" +
                "        SharedPreferences.Editor editor=preferences.edit();\n" +
                "        editor.putString(key,val);\n" +
                "        editor.apply();\n" +
                "        editor.commit();\n" +
                "    }\n" +
                "    public String getData(String key){\n" +
                "        SharedPreferences preferences=context.getSharedPreferences(\"MYDATA\",Context.MODE_PRIVATE);\n" +
                "        return preferences.getString(key, \"\");\n" +
                "    }\n" +
                "\n" +
                "    public void clearAllData() {\n" +
                "        SharedPreferences sharedPreferences = context.getSharedPreferences(\"MYDATA\", Context.MODE_PRIVATE);\n" +
                "        sharedPreferences.edit().clear().commit();\n" +
                "    }\n" +
                "}\n";
        Log.d("bd_m_w",pref_string+"\n");
    }
}

package com.example.yt.myapplication.until.newUntil;


import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

@SuppressWarnings("all")
public class HttpUtil {
    public static String php = "http://localhost:63343/untitled/.idea/Jiemi.php?_ijt=4i6eahkkuod33o9529bgc9mou4&name=";
    public static String host = "http://192.168.1.203:8080/answer/";
    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
    private static Gson gson = new Gson();
    public static   Request.Builder Builder(String api){
        Request.Builder url = new Request.Builder().url(api);
        return url;
    }
    public static Call GetbuildCall(String url,boolean isserver){
        if(isserver){
          return   okHttpClient.newCall(Builder(host+"/"+url).get().build());
        }
        else {
            return   okHttpClient.newCall(Builder(url).get().build());
        }
    }
    public static Call PostbuildCall(String url,RequestBody requestBody,boolean isserver){
        if(isserver){
            return   okHttpClient.newCall(Builder(host+"/"+url).post(requestBody).build());
        }
        else {
            return  okHttpClient.newCall(Builder(url).post(requestBody).build());
        }
    }
    public static RequestBody buildRequestBody(String json)throws Exception{
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"),json);
    }
    public static <T>void asyPostRequset(String api,String json,Class<T> cls,boolean isserver,NetworkListning<T> networkListning){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Call call = null;
                try {
                    call = PostbuildCall(api,buildRequestBody(json),isserver);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            networkListning.resultFail(e.getMessage());
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String string = response.body().string();
                            networkListning.resultSuccess(gson.fromJson(string,cls));
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    networkListning.resultFail(e.getMessage());
                }
            }
        }).start();

    }

    public static <T>T asyPostRequsetNothread(String api,String json,Class<T> cls,boolean isserver,NetworkListning<T> networkListning) throws Exception {
        Call call = PostbuildCall(api, buildRequestBody(json), isserver);
        Response execute = call.execute();
        return gson.fromJson(execute.body().string(),cls);


    }
    public static <T>T asyPostRequsetNothread(String api,Class<T> cls,boolean isserver,String[] key,Object... objects) throws Exception {

        Call call = PostbuildCall(api, buildRequestBody(buildJSON(key,objects).toString()), isserver);
        Response execute = call.execute();
        return gson.fromJson(execute.body().string(),cls);


    }
    public static <T>T asyPostRequsetNothread(String api,Class<T> cls,boolean isserver,String json) throws Exception {

        Call call = PostbuildCall(api, buildRequestBody(json), isserver);
        Response execute = call.execute();
        return gson.fromJson(execute.body().string(),cls);


    }


    public static JSONObject buildJSON(String[] keys, Object... values) throws JSONException {
        JSONObject jsonObject =new JSONObject();

        for (int i = 0; i < keys.length; i++) {
            jsonObject.put(keys[i], values[i]);
        }

        return jsonObject;
    }

    public static <T>void asyGetRequset(String api,Class<T> cls,boolean isserver,NetworkListning<T> networkListning){
       new Thread(new Runnable() {
           @Override
           public void run() {
               Call call = null;
               try {
                   call = GetbuildCall(api,isserver);
                   call.enqueue(new Callback() {
                       @Override
                       public void onFailure(Call call, IOException e) {
                           networkListning.resultFail(e.getMessage());
                       }

                       @Override
                       public void onResponse(Call call, Response response) throws IOException {
                           String string = response.body().string();
                           System.out.println(string);
                           networkListning.resultSuccess(gson.fromJson(string,cls));
                           networkListning.toString(string);
                       }
                   });
               } catch (Exception e) {
                   e.printStackTrace();
                   networkListning.resultFail(e.getMessage());
               }
           }
       }).start();

    }

    public static <T>void asyGetRequsetString(String api,boolean isserver,NetworkListning networkListning) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Call call = null;
                try {
                    call = GetbuildCall(api,isserver);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            networkListning.resultFail(e.getMessage());
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String string = response.body().string();
                            networkListning.toString(string);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    networkListning.resultFail(e.getMessage());
                }

            }
        }).start();
    }


    public static <T>void asyPostRequset(String api,boolean isserver,NetworkListning<T> networkListning){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Call call = null;
                try {
                    call = PostbuildCall(api,buildRequestBody(""),isserver);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            networkListning.resultFail(e.getMessage());
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String unicodeToString = response.body().string();
                            networkListning.toString(unicodeToString);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    networkListning.resultFail(e.getMessage());
                }
            }
        }).start();

    }
}

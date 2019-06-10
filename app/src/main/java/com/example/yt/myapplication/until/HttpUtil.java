package com.example.yt.myapplication.until;





import com.solidfire.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@SuppressWarnings("all")
public class HttpUtil {


    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
    private static Gson gson = new Gson();
    public static   Request.Builder Builder(String api){
        Request.Builder url = new Request.Builder().url(api);
        return url;
    }
    public static Call GetbuildCall(String url){

            return   okHttpClient.newCall(Builder(url).get().build());

    }
    public static Call PostbuildCall(String url, RequestBody requestBody){

            return  okHttpClient.newCall(Builder(url).post(requestBody).build());

    }
    public static RequestBody buildRequestBody(String json)throws Exception{
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"),json);
    }



    public static JSONObject buildJSON(String[] keys, Object... values) throws JSONException {
        JSONObject jsonObject =new JSONObject();

        for (int i = 0; i < keys.length; i++) {
            jsonObject.put(keys[i], values[i]);
        }

        return jsonObject;
    }

    public static <T>void asyGetRequset(final String api, final NetworkListning networkListning){
       new Thread(new Runnable() {
           @Override
           public void run() {
               Call call = null;
               try {
                   call = GetbuildCall(api);
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


}

package fish.cool.coolfish.utils;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ch on 2017/11/17.
 */

public class JsonUtils {
    public static  String toJson(Object bean){
        return new Gson().toJson(bean);
    }

    public  static  <T> T toBean(String json,Class<T> cls){
        return  new Gson().fromJson(json,cls);

    }

    public static String getString(String json,String key){
        try {
            return new JSONObject(json).optString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static  <T> List<T> toList(String json,Class<T[]> cls){
        // 有一个类专门用来操作数组，Arrays
        // Arrays.asList(数组) 得到的集合，长度不能更改（add、remove）
        return Arrays.asList(new Gson().fromJson(json, cls));
    }


}

package fish.cool.coolfish.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ch on 2017/11/17.
 */

public class JsonUtils {
    public static String toJson(Object bean) {
        return new Gson().toJson(bean);
    }

    public static <T> T toBean(String json, Class<T> cls) {
        return new Gson().fromJson(json, cls);

    }

    public static String getString(String json, String key) {
        try {
            return new JSONObject(json).optString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> toList(String json, Class<T[]> cls) {
        // 有一个类专门用来操作数组，Arrays
        // Arrays.asList(数组) 得到的集合，长度不能更改（add、remove）
        return Arrays.asList(new Gson().fromJson(json, cls));
    }

    public static <T> List<T> toListByjp(String json, Class<T> cls) {
        JsonArray jsa = new JsonParser().parse(json).getAsJsonArray();
        List<T> list = new ArrayList<>();
        for (JsonElement je : jsa) {
            T t = (T) new Gson().fromJson(je, cls);
            list.add(t);
        }
        return list;
    }
}

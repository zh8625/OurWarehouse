package fish.cool.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mr.Yu on 2017/11/23.
 */

public class SpUtil {

    public static void save(Context ctx, String key, String value) {
        // name:文件名； mode：Context.MODE_PRIVATE
        SharedPreferences sp = ctx.getSharedPreferences("SaveDemo", Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    public static String get(Context ctx, String key, String defValue) {
        SharedPreferences sp = ctx.getSharedPreferences("SaveDemo", Context.MODE_PRIVATE);
        return sp.getString(key, defValue); // default:默认
    }

}

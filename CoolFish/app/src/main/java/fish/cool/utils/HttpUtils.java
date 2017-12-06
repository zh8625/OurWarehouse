package fish.cool.utils;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.Map;


/**
 * Created by ch on 2017/11/16.
 */

public class HttpUtils {
    public static  void get(String url, StringCallback callback){
        OkGo.<String>get(url).execute(callback);

    }
    public static  void  post(String url, Map<String ,String> params,StringCallback callback){
        OkGo.<String>get(url)
                .params(params)
                .execute(callback);

    }


}

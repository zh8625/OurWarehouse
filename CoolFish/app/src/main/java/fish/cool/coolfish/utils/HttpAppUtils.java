package fish.cool.coolfish.utils;

import com.lzy.okgo.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ch on 2017/11/16.
 */

public class HttpAppUtils {
    private static String baseUrl="http://192.168.191.1:8080/Demo1/";
    //注册
    public static void regUser(String username, String password, String uage, StringCallback callback){
        String url=baseUrl+"userregAndroidAction";
        Map<String,String> params=new HashMap<>();
        params.put("username",username);
        params.put("password",password);
        params.put("uage",uage);

        HttpUtils.post(url,params,callback);
    }

    //登录
    public static  void  loginUser(String username,String password,StringCallback callback ){
        String url=baseUrl+"userloginAndroidAction";
        Map<String,String> params=new HashMap<>();
        params.put("username",username);
        params.put("password" ,password);

        HttpUtils.post(url,params,callback);
    }


}

package fish.cool.coolfish.utils;

import com.lzy.okgo.callback.StringCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ch on 2017/11/16.
 */

public class HttpAppUtils {
    public static int uid=-1;

    private static String baseUrl="http://www.zhaichuankun.cn/CoolFishServer/";
    //注册
    public static void regUser(String username, String password,String usex, String uage, StringCallback callback){
        String url=baseUrl+"chatreg";
        Map<String,String> params=new HashMap<>();
        params.put("username",username);
        params.put("password",password);
        params.put("usex",usex);
        params.put("uage",uage);

        HttpUtils.post(url,params,callback);
    }

    //登录
    public static  void  loginUser(String username,String password,StringCallback callback ){
        String url=baseUrl+"chatlogin";
        Map<String,String> params=new HashMap<>();
        params.put("username",username);
        params.put("password" ,password);

        HttpUtils.post(url,params,callback);
    }
    //搜索好友
    public static void searchUser(String username,StringCallback callback ){
        String url = baseUrl + "chatsearch";

        Map<String,String> params=new HashMap<>();
        params.put("username",username);
        HttpUtils.post(url,params,callback);

    }
    //添加好友
    public static void addFriend(int touid,StringCallback callback){
        String url = baseUrl + "chataddFriend";

        Map<String,String> params=new HashMap<>();
        params.put("uid",String.valueOf(uid));
        params.put("touid",String.valueOf(touid));

        HttpUtils.post(url,params,callback);
    }
    //发送消息
    public static void sendMessage(int touid,String message,StringCallback callback){
        String url = baseUrl + "chatsend";

        Map<String,String> params=new HashMap<>();
        params.put("uid",String.valueOf(uid));
        params.put("touid",String.valueOf(touid));
        params.put("msg",message);

        HttpUtils.post(url,params,callback);
    }
    //接收消息
    public static void receiverMessage(StringCallback callback){
        String url = baseUrl + "chatreceive";
        Map<String,String> params=new HashMap<>();
        params.put("uid",String.valueOf(uid));
        HttpUtils.post(url,params,callback);
    }
    //获取好友
    public static void friendlist(StringCallback callback){
        String url = baseUrl + "chatfriendList";
        Map<String,String> params=new HashMap<>();
        params.put("uid",String.valueOf(uid));
        HttpUtils.post(url,params,callback);
    }


}

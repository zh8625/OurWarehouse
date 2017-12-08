package fish.cool;

import android.app.Application;

import com.lzy.okgo.OkGo;

import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.OkHttpClient;


/**
 * Created by ch on 2017/11/16.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //全局的读取超时时间
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        //全局的写入超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        //全局的连接超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);

        OkGo.getInstance().init(this)                       //必须调用初始化
                .setOkHttpClient(builder.build());
        //realm
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                // .directory(dir)
                .name("CoolFish.realm")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(config);
        //


    }


}

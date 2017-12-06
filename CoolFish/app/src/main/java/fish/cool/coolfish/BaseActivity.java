package fish.cool.coolfish;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ch on 2017/11/24.
 *
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected SharedPreferences sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp=getSharedPreferences("onlineMarkDemo1",MODE_PRIVATE);
    }
    //获取
    protected String getSPString(String key,String defValue){

        return sp.getString(key,defValue);
    }
    //输出
    protected void putSPString(String key,String value){

        sp.edit().putString(key,value).commit();
    }
    //删除remove
    protected void removeSPString(String key){
        sp.edit().remove(key).commit();
    }
}

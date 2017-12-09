package fish.cool;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import fish.cool.coolfish.bean.User;
import fish.cool.coolfish.utils.HttpAppUtils;
import fish.cool.coolfish.utils.JsonUtils;

/**
 * Created by ch on 2017/11/24.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected SharedPreferences sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getSharedPreferences("coolfish", MODE_PRIVATE);
    }

    //获取
    protected String getSPString(String key, String defValue) {

        return sp.getString(key, defValue);
    }

    //输出
    protected void putSPString(String key, String value) {

        sp.edit().putString(key, value).commit();
    }

    //删除remove
    protected void removeSPString(String key) {
        sp.edit().remove(key).commit();
    }

    //获取当前登录用户的uid
    public void putUidToHttpAppUtils() {
        String s = getSPString("SP_USER", "");
        if (!s.equals("")) {
             HttpAppUtils.uid= JsonUtils.toBean(s, User.class).getUid();
        }
        HttpAppUtils.uid = -1;

    }


    private long lastback = 0;

    //屏蔽返回键
    public void onBackPressed() {
        //我们当前线程已经创建了多长时间（获取当前时间）
        long back = SystemClock.currentThreadTimeMillis();//current当前的，Thread线程
        if (lastback == 0 || back - lastback > 2 * 1000) {
            //如果是第一次按返回
            Toast.makeText(this, "再点击一次退出", Toast.LENGTH_SHORT).show();
            //记录
            lastback = back;
        } else {
            //如果是第二次点击返回
            super.onBackPressed();
        }
    }

}

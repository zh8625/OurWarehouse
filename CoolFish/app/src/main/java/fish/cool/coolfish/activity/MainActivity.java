package fish.cool.coolfish.activity;

import android.os.Bundle;

import fish.cool.BaseActivity;
import fish.cool.coolfish.R;
import fish.cool.coolfish.frag.MainDrawerFragment;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 动态加载
        MainDrawerFragment mainDrawerFragment = new MainDrawerFragment();
        // 开启事务（用Fragment的管理器开启）
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_drawer, mainDrawerFragment)
                .commit();
    }
    public void removeSP(String key){
       removeSPString(key);
    }
    public String getSP(String key){
        return  getSPString(key,"{}");
    }
}

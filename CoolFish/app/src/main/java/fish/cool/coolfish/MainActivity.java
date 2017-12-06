package fish.cool.coolfish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fish.cool.frag.MainDrawerFragment;


public class MainActivity extends AppCompatActivity {

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
}

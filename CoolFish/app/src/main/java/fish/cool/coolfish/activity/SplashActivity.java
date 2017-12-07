package fish.cool.coolfish.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.Toast;

import fish.cool.BaseActivity;
import fish.cool.coolfish.R;

/**
 * Created by ch on 2017/11/14.
 */

public class SplashActivity extends BaseActivity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                //                //判断是否已经登录，没有登录的话，打开登录页面
                if ("{}".equals(getSPString("SP_USER", "{}"))) {
                    //没有登录
                    Intent login1 = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(login1);
                }
                finish();
            }

        }, 2 * 1000);

    }


}







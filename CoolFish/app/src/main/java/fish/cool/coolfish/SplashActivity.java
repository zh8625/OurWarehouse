package fish.cool.coolfish;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.Toast;

/**
 * Created by ch on 2017/11/14.
 */

public class SplashActivity extends BaseActivity {

    Handler handler=new Handler();
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

        },2*1000);

    }


    private long lastback=0;
    //屏蔽返回键
    public  void onBackPressed(){
        //我们当前线程已经创建了多长时间（获取当前时间）
        long back= SystemClock.currentThreadTimeMillis();//current当前的，Thread线程
        if(lastback==0 || back-lastback>2*1000){
            //如果是第一次按返回
            Toast.makeText(this,"再点击一次退出",Toast.LENGTH_SHORT).show();
            //记录
            lastback=back;
        }else {
            //如果是第二次点击返回
            super.onBackPressed();
        }
    }


    }







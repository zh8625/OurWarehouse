package fish.cool.coolfish.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import fish.cool.BaseActivity;
import fish.cool.coolfish.bean.ResponseJson;
import fish.cool.coolfish.R;
import fish.cool.coolfish.service.GetMessageToRealmService;
import fish.cool.coolfish.utils.HttpAppUtils;
import fish.cool.coolfish.utils.JsonUtils;


public class LoginActivity extends BaseActivity implements View.OnClickListener{
    private TextView tv_cancel,tv_reg;
    private EditText et_username,et_password;
    private Button login;
    private ProgressDialog pd;//进度弹窗

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        tv_cancel=findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(this);
        login=findViewById(R.id.login);
        login.setOnClickListener(this);
        tv_reg=findViewById(R.id.tv_reg);
        tv_reg.setOnClickListener(this);

        //实例化并设置弹窗
        pd=new ProgressDialog(LoginActivity.this);
        //点击其他区域不能取消弹窗
        pd.setCancelable(false);
        //弹窗消息
        pd.setMessage("正在登录尬聊，请稍等......");
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_cancel:
                Intent cancel=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(cancel);
                break;
            case R.id.login:
                loginUser();
                break;
            case R.id.tv_reg:
                toReg();
                break;
        }
    }

    //跳转到注册页面
    private void toReg() {
        Intent intent=new Intent(LoginActivity.this,RegActivity.class);
        startActivity(intent);
    }

    private void loginUser() {
        //获取登录页面中输入的用户名和密码，并去掉空格 --trim（）去空格
        final String username=et_username.getText().toString().trim();
        final String password=et_password.getText().toString().trim();
        HttpAppUtils.loginUser(username, password, new StringCallback() {
            @Override
            public void onStart(Request<String, ? extends Request> request) {
                //打开弹窗
                pd.show();
            }

            @Override
            public void onSuccess(Response<String> response) {

                String json=response.body();
                ResponseJson responseJson= JsonUtils.toBean(json, ResponseJson.class);
                String jsonData=JsonUtils.getString(json,"data");

                if (responseJson.getCode()==0){
                    //启动service
                    Intent in =new Intent(LoginActivity.this, GetMessageToRealmService.class);
                    startService(in);
                    //
                    putSPString("SP_USER",jsonData);
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    LoginActivity.this.finish();
                    //把当前用户的uid放入HttpAppUtils的uid
                    putUidToHttpAppUtils();

                }else if (responseJson.getCode()==-1){
                    Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Response<String> response) {
                Toast.makeText(LoginActivity.this, "网络异常，请检查网络", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                //关闭弹窗
                pd.dismiss();
            }
        });
    }
}

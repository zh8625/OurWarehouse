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
import fish.cool.coolfish.R;
import fish.cool.coolfish.bean.ResponseJson;
import fish.cool.coolfish.utils.HttpAppUtils;
import fish.cool.coolfish.utils.JsonUtils;


public class RegActivity extends BaseActivity implements View.OnClickListener{
    private EditText et_username,et_password,ed_agePwd,et_uage;
    private Button reg;
    private TextView tv_back;
    private ProgressDialog pd;//进度弹窗

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        init();
    }

    private void init() {
        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        ed_agePwd=findViewById(R.id.ed_agePwd);
        et_uage=findViewById(R.id.et_uage);

        tv_back = findViewById(R.id.tv_back);
        tv_back.setOnClickListener(this);

        reg=findViewById(R.id.reg);
        reg.setOnClickListener(this);

        pd=new ProgressDialog(RegActivity.this);//实例化并设置弹窗
        pd.setCancelable(false);//点击其他区域不能取消弹窗
        pd.setMessage("正在注册，请稍等......");//弹窗信息


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reg:
                regUser();
                break;
            case R.id.tv_back:
                RegActivity.this.finish();
                break;
        }
    }

    private void regUser() {
        String username=et_username.getText().toString().trim();//获取输入的用户名的信息，并去掉空格  trim去掉获取的空格部分
        String password=et_password.getText().toString().trim();
        String agePwd=ed_agePwd.getText().toString().trim();
        String uage=et_uage.getText().toString().trim();

        if (username.equals("") || password.equals("") || agePwd.equals("") ||et_uage.equals("")){
            Toast.makeText(this, "填入信息不完整，请重新填写", Toast.LENGTH_SHORT).show();
        }else if (!password.equals(agePwd)){
            Toast.makeText(this, "两次输入的密码不相同", Toast.LENGTH_SHORT).show();
        }else {

            HttpAppUtils.regUser(username, password, uage, new StringCallback() {
                @Override
                public void onStart(Request<String, ? extends Request> request) {
                    //打开弹窗
                    pd.show();
                }

                @Override
                public void onSuccess(Response<String> response) {
                    String json = response.body();
                    ResponseJson rj = JsonUtils.toBean(json, ResponseJson.class);
                    if (rj.getCode() == -1) {
                        Toast.makeText(RegActivity.this, "注册失败，请重新注册", Toast.LENGTH_SHORT).show();
                    } else if (rj.getCode() == 1) {
                        Intent intent = new Intent(RegActivity.this, LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(RegActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onError(Response<String> response) {
                    Toast.makeText(RegActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFinish() {
                    //关闭弹窗
                    pd.dismiss();
                }


            });
        }
    }
}

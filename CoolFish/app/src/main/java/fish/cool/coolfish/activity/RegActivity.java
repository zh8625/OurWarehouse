package fish.cool.coolfish.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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


public class RegActivity extends BaseActivity implements View.OnClickListener {
    private EditText ed_username_reg, ed_password_reg, ed_equPassword_reg, ed_uage_reg;
    private RadioGroup rg_sex_reg;
    private Button bt_reg;
    private TextView tv_back;
    private ProgressDialog pd;//进度弹窗
    //数据
    private String username, password, equPassword, uage, usex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        init();
    }

    private void init() {
        //用户名
        ed_username_reg = findViewById(R.id.ed_username_reg);
        //密码
        ed_password_reg = findViewById(R.id.ed_password_reg);
        //确认密码
        ed_equPassword_reg = findViewById(R.id.ed_equPassword_reg);
        //年龄
        ed_uage_reg = findViewById(R.id.ed_uage_reg);
        //性别
        rg_sex_reg = findViewById(R.id.rg_sex_reg);
        rg_sex_reg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRb = (RadioButton) group.getChildAt(checkedId);
                usex = checkedRb.getText().toString();
            }
        });
        //返回
        tv_back = findViewById(R.id.tv_back_reg);
        tv_back.setOnClickListener(this);
        //注册按钮
        bt_reg = findViewById(R.id.bt_reg);
        bt_reg.setOnClickListener(this);

        pd = new ProgressDialog(RegActivity.this);//实例化并设置弹窗
        pd.setCancelable(false);//点击其他区域不能取消弹窗
        pd.setMessage("正在注册，请稍等......");//弹窗信息


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_reg:
                regUser();
                break;
            case R.id.tv_back_reg:
                RegActivity.this.finish();
                break;
        }
    }

    private void regUser() {
        //获取数据
        username = ed_username_reg.getText().toString().trim();
        password = ed_password_reg.getText().toString().trim();
        equPassword = ed_equPassword_reg.getText().toString().trim();
        uage = ed_uage_reg.getText().toString().trim();
        //
        if (username.equals("") || password.equals("") || equPassword.equals("") || uage.equals("")) {
            Toast.makeText(this, "填入信息不完整，请重新填写", Toast.LENGTH_SHORT).show();
        } else if (!password.equals(equPassword)) {
            Toast.makeText(this, "两次输入的密码不相同", Toast.LENGTH_SHORT).show();
        } else {

            HttpAppUtils.regUser(username, password, usex, uage, new StringCallback() {
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
                    } else if (rj.getCode() == 0) {
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

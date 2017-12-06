package fish.cool.coolfish;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import fish.cool.bean.ResponseJson;
import fish.cool.utils.HttpAppUtils;
import fish.cool.utils.JsonUtils;


public class RegActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView user_agreement;
    private EditText et_username,et_password,ed_agePwd,et_uage;
    private RadioGroup man,woman;
    private Button reg,back;
    private ProgressDialog pd;//进度弹窗
    private String agree = "尊敬的用户欢迎您注册成为本网站会员。请用户仔细阅读以下全部内容。如用户不同意本服务条款任意内容，请不要注册或使用本网站服务。如用户通过本网站注册程序，即表示用户与本网站已达成协议，自愿接受本服务条款的所有内容。此后，用户不得以未阅读本服务条款内容作任何形式的抗辩。\n" +
            "一、本站服务条款的确认和接纳\n" +
            "本网站涉及的各项服务的所有权和运作权归本网站所有。本网站所提供的服务必须按照其发布的服务条款和操作规则严格执行。本服务条款的效力范围及于本网站的一切产品和服务，用户在享受本网站的任何服务时，应当受本服务条款的约束。\n" +
            "二、服务简介\n" +
            "本网站运用自己的操作系统通过国际互联网络为用户提供各项服务。用户必须: 1. 提供设备，如个人电脑、手机或其他上网设备。 2. 个人上网和支付与此服务有关的费用。\n" +
            "三、用户在不得在本网站上发布下列违法信息\n" +
            "1. 反对宪法所确定的基本原则的； 2. 危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的； 3. 损害国家荣誉和利益的； 4. 煽动民族仇恨、民族歧视，破坏民族团结的； 5. 破坏国家宗教政策，宣扬邪教和封建迷信的； 6. 散布谣言，扰乱社会秩序，破坏社会稳定的； 7. 散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的； 8. 侮辱或者诽谤他人，侵害他人合法权益的； 9. 含有法律、行政法规禁止的其他内容的。\n" +
            "四、有关个人资料\n" +
            "用户同意: 1. 提供及时、详尽及准确的个人资料。 2. 同意接收来自本网站的信息。 3. 不断更新注册资料，符合及时、详尽准确的要求。所有原始键入的资料将引用为注册资料。 4. 本网站不公开用户的姓名、地址、电子邮箱和笔名。除以下情况外: a) 用户授权本站透露这些信息。 b) 相应的法律及程序要求本站提供用户的个人资料。\n" +
            "五、服务条款的修改\n" +
            "本网站有权在必要时修改服务条款，一旦条款及服务内容产生变动，本网站将会在重要页面上提示修改内容。如果不同意所改动的内容，用户可以主动取消获得的本网站信息服务。如果用户继续享用本网站信息服务，则视为接受服务条款的变动。\n" +
            "六、用户隐私制度\n" +
            "尊重用户个人隐私是本网站的一项基本政策。所以，本网站一定不会在未经合法用户授权时公开、编辑或透露其注册资料及保存在本网站中的非公开内容，除非有法律许可要求或本网站在诚信的基础上认为透露这些信息在以下四种情况是必要的: 1. 遵守有关法律规定，遵从本网站合法服务程序。 2. 保持维护本网站的商标所有权。 3. 在紧急情况下竭力维护用户个人和社会大众的隐私安全。 4. 符合其他相关的要求。\n" +
            "七、用户的帐号、密码和安全性\n" +
            "用户一旦注册成功，将获得一个密码和用户名。用户需谨慎合理的保存、使用用户名和密码。如果你不保管好自己的帐号和密码安全，将负全部责任。另外，每个用户都要对其帐户中的所有活动和事件负全责。你可随时根据指示改变你的密码。用户若发现任何非法使用用户帐号或存在安全漏洞的情况，请立即通告本网站。 八、 拒绝提供担保 用户明确同意信息服务的使用由用户个人承担风险。本网站不担保服务不会受中断，对服务的及时性，安全性，出错发生都不作担保，但会在能力范围内，避免出错。\n" +
            "九、有限责任\n" +
            "如因不可抗力或其它本站无法控制的原因使本站销售系统崩溃或无法正常使用导致网上交易无法完成或丢失有关的信息、记录等本站会尽可能合理地协助处理善后事宜，并努力使客户免受经济损失，同时会尽量避免这种损害的发生。\n" +
            "十、用户信息的储存和限制\n" +
            "本站有判定用户的行为是否符合国家法律法规规定及本站服务条款权利，如果用户违背本网站服务条款的规定，本网站有权中断对其提供服务的权利。\n" +
            "十一、用户管理\n" +
            "用户单独承担发布内容的责任。用户对服务的使用是根据所有适用于本站的国家法律、地方法律和国际法律标准的。用户必须遵循: 1. 使用网络服务不作非法用途。 2. 不干扰或混乱网络服务。 3. 遵守所有使用网络服务的网络协议、规定、程序和惯例。 用户须承诺不传输任何非法的、骚扰性的、中伤他人的、辱骂性的、恐性的、伤害性的、庸俗的，淫秽等信息资料。另外，用户也不能传输何教唆他人构成犯罪行为的资料；不能传输助长国内不利条件和涉及国家安全的资料；不能传输任何不符合当地法规、国家法律和国际法律的资料。未经许可而非法进入其它电脑系统是禁止的。 若用户的行为不符合以上提到的服务条款，本站将作出独立判断立即取消用户服务帐号。用户需对自己在网上的行为承担法律责任。用户若在本站上散布和传播反动、色情或其它违反国家法律的信息，本站的系统记录有可能作为用户违反法律的证据。\n" +
            "十二、通告\n" +
            "所有发给用户的通告都可通过重要页面的公告或电子邮件或常规的信件传送。服务条款的修改、服务变更、或其它重要事件的通告都会以此形式进行。\n" +
            "十三、信息内容的所有权\n" +
            "本网站定义的信息内容包括: 文字、软件、声音、相片、录象、图表；在广告中全部内容；本网站为用户提供的其它信息。所有这些内容受版权、商标、标签和其它财产所有权法律的保护。所以，用户只能在本网站和广告商授权下才能使用这些内容，而不能擅自复制、再造这些内容、或创造与内容有关的派生产品。本站所有的文章版权归原文作者和本站共同所有，任何人需要转载本站的文章，必须征得原文作者或本站授权。\n" +
            "十四、法律\n" +
            "本协议的订立、执行和解释及争议的解决均应适用中华人民共和国的法律。用户和本网站一致同意服从本网站所在地有管辖权的法院管辖。如发生本网站服务条款与中华人民共和国法律相抵触时，则这些条款将完全按法律规定重新解释，而其它条款则依旧保持对用户的约束力。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        init();
    }

    private void init() {
        user_agreement=findViewById(R.id.user_agreement);
        user_agreement.setText(agree);
        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        ed_agePwd=findViewById(R.id.ed_agePwd);
        et_uage=findViewById(R.id.et_uage);

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
            case R.id.back:
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

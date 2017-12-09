package fish.cool.coolfish.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import fish.cool.BaseActivity;
import fish.cool.coolfish.R;
import fish.cool.coolfish.adapter.RecyclerMessageAdapter;
import fish.cool.coolfish.bean.MsgRealm;
import fish.cool.coolfish.bean.ResponseJson;
import fish.cool.coolfish.receiver.MessageReceiver;
import fish.cool.coolfish.utils.HttpAppUtils;
import fish.cool.coolfish.utils.JsonUtils;
import fish.cool.coolfish.utils.RealmUtil;

/**
 * 聊天记录的那个页面
 * Created by ch on 2017/12/8.
 */

public class ChatActivity extends BaseActivity {
    private TextView tv_friendname_chat;
    private RecyclerView rv_message_list;
    private EditText ed_message;
    private Button bt_send_message;
    //data
    private String friendname;
    private int frienduid;
    //
    private String message;
    //消息list
    private List<MsgRealm> list = new ArrayList<>();
    private RecyclerMessageAdapter adapter;
    //
    private MessageReceiver receiver = new MessageReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        init();
    }

    private void init() {
        tv_friendname_chat = findViewById(R.id.tv_friendname_chat);
        //设置与之聊天的用户名
        Intent in = getIntent();
        friendname = in.getStringExtra("friendname");
        frienduid = in.getIntExtra("frienduid", 0);
        tv_friendname_chat.setText(friendname);
        //
        rv_message_list = findViewById(R.id.rv_message_list);
        adapter = new RecyclerMessageAdapter(list);
        rv_message_list.setAdapter(adapter);
        //
        ed_message = findViewById(R.id.ed_message);
        bt_send_message = findViewById(R.id.bt_send_message);
        bt_send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = ed_message.getText().toString().trim();
                HttpAppUtils.sendMessage( frienduid, message, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String json = response.body();
                        ResponseJson responseJson = JsonUtils.toBean(json, ResponseJson.class);
                        String jsonData = JsonUtils.getString(json, "data");
                        if (responseJson.getCode() == 0) {
                            //将发送的信息添加到list并更新adapter
                            list.add(new MsgRealm(message, MsgRealm.TYPE_SENT));
                            adapter.notifyDataSetChanged();
                        } else if (responseJson.getCode() == -1) {
                            Toast.makeText(ChatActivity.this, "发送失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        receiver.setRefm(new MessageReceiver.refreshMessage() {
            @Override
            public void refreshMsg() {
                //通过广播让activity更新数据
                list = RealmUtil.receiveMessageFromRealm(list);
                adapter.notifyDataSetChanged();
            }
        });

    }
}
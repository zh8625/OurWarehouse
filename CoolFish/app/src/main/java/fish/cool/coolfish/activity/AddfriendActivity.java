package fish.cool.coolfish.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fish.cool.BaseActivity;
import fish.cool.coolfish.R;
import fish.cool.coolfish.bean.FriendRealm;
import fish.cool.coolfish.bean.ResponseJson;
import fish.cool.coolfish.bean.User;
import fish.cool.coolfish.utils.HttpAppUtils;
import fish.cool.coolfish.utils.JsonUtils;
import fish.cool.coolfish.utils.RealmUtil;

public class AddfriendActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_back_add;
    private SearchView sv_search_add;
    private TextView tv_goodFriend_add;
    //查询到的用户信息
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfriend);
        //返回
        tv_back_add = findViewById(R.id.tv_back_add);
        tv_back_add.setOnClickListener(this);
        //搜索search
        sv_search_add = findViewById(R.id.sv_search_add);
        sv_search_add.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //当点击搜索时
                HttpAppUtils.searchUser(query, new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String json = response.body();
                        ResponseJson responseJson = JsonUtils.toBean(json, ResponseJson.class);
                        String jsonData = JsonUtils.getString(json, "data");

                        if (responseJson.getCode() == 0) {
                            user = JsonUtils.toBean(jsonData, User.class);
                            tv_goodFriend_add.setText(user.getUsername());

                        } else if (responseJson.getCode() == -1) {
                            tv_goodFriend_add.setText("未找到用户");
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        Toast.makeText(AddfriendActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
                    }
                });

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //当内容改变时
                return false;
            }
        });
        tv_goodFriend_add = findViewById(R.id.tv_goodFriend_add);
        tv_goodFriend_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back_add:
                AddfriendActivity.this.finish();
                break;
            case R.id.tv_goodFriend_add:
                toAddFrirnd();
                break;

        }
    }

    private void toAddFrirnd() {
        if(user!=null && HttpAppUtils.uid!= -1){
            HttpAppUtils.addFriend( user.getUid(), new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    String json=response.body();
                    ResponseJson responseJson= JsonUtils.toBean(json, ResponseJson.class);
                    String jsonData=JsonUtils.getString(json,"data");
                    if(responseJson.getCode() == 0){
                        Toast.makeText(AddfriendActivity.this, "添加好友成功", Toast.LENGTH_SHORT).show();
                        friendList();

                    }
                }
            });
        }

    }

    private void friendList() {
        HttpAppUtils.friendlist(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String json=response.body();
                ResponseJson responseJson= JsonUtils.toBean(json, ResponseJson.class);
                String jsonData=JsonUtils.getString(json,"data");
                if(responseJson.getCode() == 0){
                    List<FriendRealm> list = new ArrayList<>();
                    //
                    List<User>  lu= JsonUtils.toListByjp(jsonData,User.class);
                    for (User u:lu){
                        FriendRealm fr = new FriendRealm();
                        fr.setFid(u.getUid());
                        fr.setFicon(u.getUicon());
                        fr.setFname(u.getUsername());
                        list.add(fr);
                    }
                    RealmUtil.friendlistToRealm(list);
                }
            }
        });

    }
}

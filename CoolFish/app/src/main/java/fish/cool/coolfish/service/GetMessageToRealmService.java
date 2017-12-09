package fish.cool.coolfish.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import fish.cool.coolfish.bean.ChatRecord;
import fish.cool.coolfish.bean.MsgRealm;
import fish.cool.coolfish.bean.ResponseJson;
import fish.cool.coolfish.utils.HttpAppUtils;
import fish.cool.coolfish.utils.JsonUtils;
import fish.cool.coolfish.utils.RealmUtil;

/**
 * Created by Water on 2017/12/8.
 */

public class GetMessageToRealmService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private boolean flag;

    @Override
    public void onCreate() {
        super.onCreate();
        flag = true;
        new Thread() {
            @Override
            public void run() {
                while (flag) {
                    HttpAppUtils.receiverMessage(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String json = response.body();
                            ResponseJson responseJson = JsonUtils.toBean(json, ResponseJson.class);
                            String jsonData = JsonUtils.getString(json, "data");

                            if (responseJson.getCode() == 0) {
                                List<ChatRecord> list = JsonUtils.toListByjp(jsonData, ChatRecord.class);
                                List<MsgRealm> lm = new ArrayList<>();
                                for (ChatRecord cr : list) {
                                    MsgRealm m = new MsgRealm();
                                    m.setContent(cr.getMessage());
                                    m.setType(MsgRealm.TYPE_RECRIVED);
                                    lm.add(m);

                                }
                                RealmUtil.receiveMessageToRealm(lm);
                            }
                        }
                    });
                    try {
                        Thread.sleep(3*1000);
                    } catch (InterruptedException e) {

                    }

                }
            }
        }.start();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        flag = false;
    }
}
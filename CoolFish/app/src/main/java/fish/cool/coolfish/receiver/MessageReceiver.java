package fish.cool.coolfish.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Water on 2017/12/9.
 */

public class MessageReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //通过接口回调刷新接收到的信息
        refm.refreshMsg();
    }

    private refreshMessage refm;

    public void setRefm(refreshMessage refm) {
        this.refm = refm;
    }

    public interface refreshMessage{

        void refreshMsg();

    }

}

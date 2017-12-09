package fish.cool.coolfish.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Water on 2017/12/9.
 */

public class FriendlistReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //收到广播刷新好友列表
        rfl.refreshList();
    }
    private refreshFriendlist rfl;
    public void setRfl(refreshFriendlist rfl) {
        this.rfl = rfl;
    }

    public interface refreshFriendlist {
        void refreshList();
    }

}

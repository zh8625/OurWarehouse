package fish.cool.coolfish.utils;

import java.util.ArrayList;
import java.util.List;

import fish.cool.coolfish.bean.FriendRealm;
import fish.cool.coolfish.bean.MsgRealm;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Water on 2017/12/9.
 */

public class RealmUtil {

    public static List<MsgRealm> receiveMessageFromRealm(List<MsgRealm> list) {
        //查询到消息，然后删除
        Realm realm = Realm.getDefaultInstance();
        RealmResults<MsgRealm> rrs = realm.where(MsgRealm.class).findAll();
        List<MsgRealm> lmsg = realm.copyFromRealm(rrs);
        list.addAll(lmsg);
        //删除
        if (lmsg.size() != 0) {
            //开启事务
            realm.beginTransaction();
            for (MsgRealm m : lmsg) {
                //根据lmsg中的数据查找到对应数据库中的obj
                MsgRealm m1 = realm.where(MsgRealm.class).equalTo("mid", m.getMid()).findFirst();
                //不为空,删除
                if (m1 != null) {
                    m1.deleteFromRealm();
                }
            }
            //提交事务
            realm.commitTransaction();
        }
        realm.close();
        return list;
    }

    public static void receiveMessageToRealm(final List<MsgRealm> list) {
        //把消息存入数据库
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (MsgRealm mr : list) {
                    mr.setMid(getId());
                    realm.insert(mr);
                }
            }
        });
    }

    public static List<FriendRealm> friendlistFromRealm() {
        List<FriendRealm> list = new ArrayList<>();
        Realm realm = Realm.getDefaultInstance();
        RealmResults<FriendRealm> rf = realm.where(FriendRealm.class).findAll();
        list = realm.copyFromRealm(rf);
        return list;
    }

    public static void friendlistToRealm(List<FriendRealm> list) {
        //更新好友列表
        //先清空数据
        Realm realm = Realm.getDefaultInstance();
        RealmResults<FriendRealm> rf = realm.where(FriendRealm.class).findAll();
        List<FriendRealm> lf = realm.copyFromRealm(rf);
        for (FriendRealm fr : lf) {
            FriendRealm f = realm.where(FriendRealm.class).equalTo("fid", fr.getFid()).findFirst();
            f.deleteFromRealm();

        }
        //
        for (FriendRealm f : list) {
            f.setFid(getId());
            realm.insert(f);
        }
        //
    }

    //给Msg设置一个不一样的主键
    private static int i = 0;

    private static int getId() {
        if (i > 999999) {
            i = 0;
        }
        return i++;
    }

}

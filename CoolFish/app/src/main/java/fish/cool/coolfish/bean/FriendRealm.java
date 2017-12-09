package fish.cool.coolfish.bean;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Water on 2017/12/9.
 */

public class FriendRealm extends RealmObject {
    @PrimaryKey
    private int fid;

    private String ficon;

    private String fname;

    public FriendRealm() {
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFicon() {
        return ficon;
    }

    public void setFicon(String ficon) {
        this.ficon = ficon;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}

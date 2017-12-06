package fish.cool.bean;

/**
 * Created by ch on 2017/11/20.
 */

public class ResponseJson {
    private int code;
    private String msg;
    private String data;

    public ResponseJson() {
    }

    public ResponseJson(int code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

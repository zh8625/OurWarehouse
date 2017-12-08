package fish.cool.coolfish.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import fish.cool.coolfish.bean.User;

/**
 * Created by Water on 2017/12/8.
 */

public class ListFriendAdapter extends BaseAdapter {
    private List list;

    public ListFriendAdapter(List<User> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        return null;
    }
}

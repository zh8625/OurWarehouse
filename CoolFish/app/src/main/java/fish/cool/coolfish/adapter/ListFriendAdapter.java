package fish.cool.coolfish.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fish.cool.coolfish.R;
import fish.cool.coolfish.bean.FriendRealm;
import fish.cool.coolfish.bean.User;

/**
 * Created by Water on 2017/12/8.
 */

public class ListFriendAdapter extends BaseAdapter {
    private List<FriendRealm> list;

    public ListFriendAdapter(List<FriendRealm> list) {
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
        View view;
        ViewHolder vh;
        //先判断view是否存在，不存在的话，创建view
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_main_friend, parent, false);
            vh = new ViewHolder();
            vh.iv_icon_friendlist = view.findViewById(R.id.iv_icon_friendlist);
            vh.tv_name_friendlist = view.findViewById(R.id.tv_name_friendlist);
            view.setTag(vh);
        } else {
            view = convertView;
            vh = (ViewHolder) convertView.getTag();
        }
        FriendRealm fr = list.get(position);
        vh.iv_icon_friendlist.setImageResource(Integer.valueOf(fr.getFicon()));
        vh.tv_name_friendlist.setText(fr.getFname());

        return view;
    }

    class ViewHolder{
        ImageView iv_icon_friendlist;
        TextView tv_name_friendlist;
    }
}

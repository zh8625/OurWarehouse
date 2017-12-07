package fish.cool.coolfish.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fish.cool.coolfish.bean.User;
import fish.cool.coolfish.R;


/**
 * Created by Mr.Yu on 2017/12/6.
 */

public class ContactAdapter extends BaseAdapter {
    private List<User> list;

    public ContactAdapter(List<User> list) {
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
        //创建View,Holder
        View view;
        Holder holder;
        //先判断view是否存在，不存在的话，创建view
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message, parent, false);
            holder = new Holder();
            holder.iv_icon_message = view.findViewById(R.id.iv_icon_message);
            holder.tv_name_message = view.findViewById(R.id.tv_name_message);
            holder.tv_lastMessage_message = view.findViewById(R.id.tv_lastMessage_message);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (Holder) convertView.getTag();
        }
        //User u = list.get(position);
        //holder.iv_icon_message.setImageResource(Integer.valueOf(u.getUicon()));
        //holder.tv_name_message.setText(u.getUsername());
        //holder.tv_lastMessage_message.setText();

        return view;
    }

    class Holder {
        ImageView iv_icon_message;
        TextView tv_name_message, tv_lastMessage_message;

    }
}



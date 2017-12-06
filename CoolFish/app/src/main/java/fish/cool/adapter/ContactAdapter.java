package fish.cool.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fish.cool.bean.User;
import fish.cool.coolfish.R;


/**
 * Created by Mr.Yu on 2017/12/6.
 */

public class ContactAdapter extends BaseAdapter{
    private List<User> list;

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
                    .inflate(R.layout.item_count, parent, false);
            holder = new Holder();
            holder.tv_name=view.findViewById(R.id.tv_name);
            holder.iv_ph=view.findViewById(R.id.iv_ph);
            view.setTag(holder);
        }else{
            view=convertView;
            holder= (Holder) convertView.getTag();
        }
        User u=list.get(position);
        holder.tv_name.setText(u.getUsername());

        return view;
    }
        class  Holder{
            TextView tv_name;
            ImageView iv_ph;
        }
    }



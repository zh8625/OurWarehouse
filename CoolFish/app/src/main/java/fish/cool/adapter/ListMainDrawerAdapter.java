package fish.cool.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fish.cool.coolfish.R;


/**
 * Created by Cong on 17/11/29.
 */

public class ListMainDrawerAdapter extends BaseAdapter {

    private List<String> list;

    public ListMainDrawerAdapter(List<String> list) {
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
        // 声明View ViewHolder
        View view;
        ViewHolder vh;
        // 给view、vh赋值——创建、复用，// 将view和vh捆绑一起
        if (convertView == null) {
            // 创建
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_main_drawer, parent, false);
            vh = new ViewHolder();
            vh.iv = view.findViewById(R.id.iv);
            vh.tv = view.findViewById(R.id.tv);

            view.setTag(vh);
        } else {
            // 复用
            view = convertView;
            vh = (ViewHolder) convertView.getTag();
        }

        // 填充数据并返回结果
        String s = list.get(position);
//        vh.iv
        vh.tv.setText(s);
        return view;
    }

    private class ViewHolder {
        ImageView iv;
        TextView tv;
    }

}

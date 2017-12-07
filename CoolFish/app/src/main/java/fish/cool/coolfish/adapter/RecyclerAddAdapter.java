package fish.cool.coolfish.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fish.cool.coolfish.R;

/**
 * Created by Water on 2017/12/7.
 */

public class RecyclerAddAdapter extends RecyclerView.Adapter<RecyclerAddAdapter.ViewHolder> {
    private List<Object> list;

    public RecyclerAddAdapter(List<Object> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_add, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_additem;
        private TextView tv_title_additem, tv_content_additem;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_additem = itemView.findViewById(R.id.iv_additem);
            tv_title_additem = itemView.findViewById(R.id.tv_title_additem);
            tv_content_additem = itemView.findViewById(R.id.tv_content_additem);


        }

        //
        private int position;

        public void setData(int position) {
            this.position = position;
            //iv_additem.setImageResource(list.get(position));
            //tv_title_additem.setText(list.get(position));
            //tv_content_additem.setText(list.get(position));

        }
    }
}

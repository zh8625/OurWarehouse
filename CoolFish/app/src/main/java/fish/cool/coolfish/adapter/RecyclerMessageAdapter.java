package fish.cool.coolfish.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import fish.cool.coolfish.R;
import fish.cool.coolfish.bean.MsgRealm;

/**
 * Created by Water on 2017/12/8.
 */

public class RecyclerMessageAdapter extends RecyclerView.Adapter<RecyclerMessageAdapter.ViewHolder> {

    private List<MsgRealm> list;

    public RecyclerMessageAdapter(List<MsgRealm> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat_message, parent, false);
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

        private LinearLayout lin_left_message, lin_right_message;
        private TextView tv_left_message, tv_right_message;

        public ViewHolder(View itemView) {
            super(itemView);
            lin_left_message = itemView.findViewById(R.id.lin_left_message);
            lin_right_message = itemView.findViewById(R.id.lin_right_message);
            tv_left_message = itemView.findViewById(R.id.tv_left_message);
            tv_right_message = itemView.findViewById(R.id.tv_right_message);
        }

        public void setData(int position) {
            MsgRealm msg = list.get(position);

            if (msg.getType() == MsgRealm.TYPE_SENT) {
                lin_left_message.setVisibility(View.GONE);
                lin_right_message.setVisibility(View.VISIBLE);
                tv_right_message.setText(msg.getContent());
            } else {
                lin_right_message.setVisibility(View.GONE);
                lin_left_message.setVisibility(View.VISIBLE);
                tv_left_message.setText(msg.getContent());
            }
        }
    }
}

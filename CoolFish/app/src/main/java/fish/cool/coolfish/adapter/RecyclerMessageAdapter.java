package fish.cool.coolfish.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fish.cool.coolfish.R;
import fish.cool.coolfish.bean.MessageTransfer;
import fish.cool.coolfish.bean.Msg;

/**
 * Created by Water on 2017/12/8.
 */

public class RecyclerMessageAdapter extends RecyclerView.Adapter<RecyclerMessageAdapter.ViewHolder> {
    private List<Msg> list;

    public RecyclerMessageAdapter(List<Msg> list) {
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
        holder.setData();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setData() {

        }
    }
}

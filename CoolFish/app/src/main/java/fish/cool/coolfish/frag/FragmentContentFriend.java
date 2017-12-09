package fish.cool.coolfish.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import fish.cool.coolfish.R;
import fish.cool.coolfish.activity.AddfriendActivity;
import fish.cool.coolfish.adapter.ListFriendAdapter;
import fish.cool.coolfish.bean.FriendRealm;
import fish.cool.coolfish.bean.User;
import fish.cool.coolfish.receiver.FriendlistReceiver;
import fish.cool.coolfish.utils.RealmUtil;


/**
 * Created by ch on 2017/11/29.
 */

public class FragmentContentFriend extends Fragment {
    private ListView lv_friend;
    private TextView tv_toadd_friend;
    //好友列表相关
    private ListFriendAdapter adapter;
    private List<FriendRealm> list;
    //
    private FriendlistReceiver receiver = new FriendlistReceiver();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        LinearLayout view = (LinearLayout) LayoutInflater.from(container.getContext())
                .inflate(R.layout.frag_main_content_friend, container, false);
        tv_toadd_friend = view.findViewById(R.id.tv_toadd_friend);
        tv_toadd_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(container.getContext(), AddfriendActivity.class);
                startActivity(in);
            }
        });
        //好友列表

        lv_friend = view.findViewById(R.id.lv_friend);
        adapter = new ListFriendAdapter(list);
        lv_friend.setAdapter(adapter);
        //
        receiver.setRfl(new FriendlistReceiver.refreshFriendlist() {
            @Override
            public void refreshList() {
                list = RealmUtil.friendlistFromRealm();
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}

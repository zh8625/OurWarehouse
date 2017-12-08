package fish.cool.coolfish.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import fish.cool.coolfish.adapter.ContactAdapter;
import fish.cool.coolfish.R;


/**
 * 聊天记录的那个页面
 * Created by ch on 2017/11/29.
 */

public class FragmentContentChat extends Fragment{

    private ListView lv;
    private List list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        lv= (ListView) inflater.inflate(R.layout.frag_main_content_chat,container,false);

        ContactAdapter adapter=new ContactAdapter(list);
        lv.setAdapter(adapter);
        return lv ;
    }
}

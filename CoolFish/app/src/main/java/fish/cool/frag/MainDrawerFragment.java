package fish.cool.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fish.cool.adapter.ListMainDrawerAdapter;
import fish.cool.coolfish.R;


/**
 * Created by ch on 2017/11/29.
 */

public class MainDrawerFragment extends Fragment {
    private ListView lv_drawer;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.frag_main_drawer,container,false);
        lv_drawer=view.findViewById(R.id.lv_drawer);

        list=new ArrayList<>();

        list.add("我的相册");
        list.add("我的收藏");
        list.add("我的文件");
        list.add("设置");
        list.add("登录");
        list.add("注册");


        ListMainDrawerAdapter adapter=new ListMainDrawerAdapter(list);
        lv_drawer.setAdapter(adapter);
        return view;
    }
}

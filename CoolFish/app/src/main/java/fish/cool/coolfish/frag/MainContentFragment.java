package fish.cool.coolfish.frag;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fish.cool.coolfish.R;


/**
 * Created by ch on 2017/11/29.
 */

public class MainContentFragment extends Fragment  {
    private TabLayout tl_main_content;

    private String TAG = getClass().getSimpleName();
    private List<Fragment> frags;

    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.frag_main_content, container, false);
        //
        tl_main_content=view.findViewById(R.id.tl_main_content);

        //给两个标签
        tl_main_content.addTab(tl_main_content.newTab().setText("聊天"));
        tl_main_content.addTab(tl_main_content.newTab().setText("联系人"));

        frags = new ArrayList<>();
        frags.add(new FragmentContentChat());
        frags.add(new FragmentContentFriend());

        tl_main_content.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //动态加载fragment
                //fragment的管理器，开启事务，在activity中getSupportFragmentManager，在fragment中getChildFragmentManager)
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fl_main_content, frags.get(tab.getPosition()))
                        .commit();
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        // 动态加载fragment
        // fragment的管理器，开启事务(在activity中getSupportFragmentManager，在fragment中getChildFragmentManager)
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fl_main_content, frags.get(0))
                .commit();
        return view;
    }


}

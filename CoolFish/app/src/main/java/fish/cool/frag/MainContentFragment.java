package fish.cool.frag;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fish.cool.coolfish.AddActivity;
import fish.cool.coolfish.R;


/**
 * Created by ch on 2017/11/29.
 */

public class MainContentFragment extends Fragment implements View.OnClickListener {
    private Toolbar tb;
    private DrawerLayout dl;
    private TabLayout tl;
    private ImageView img_Drader;
    private TextView add;

    private String TAG=getClass().getSimpleName();
    private List<Fragment> frags;
    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.frag_main_content,container,false);
      tl=view.findViewById(R.id.tl);
        dl=view.findViewById(R.id.dl);
        tb=view.findViewById(R.id.tb);
        img_Drader=view.findViewById(R.id.img_Drader);
        add=view.findViewById(R.id.add);

        img_Drader.setOnClickListener(this);
        add.setOnClickListener(this);




      //给tl三个标签
        tl.addTab(tl.newTab().setText("聊天"));
        tl.addTab(tl.newTab().setText("联系人"));

        frags=new ArrayList<>();
        frags.add(new FragmentContent1());
        frags.add(new FragmentContent2());


        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d(TAG, "onTabSelected: " + tab.getPosition());
                //动态加载fragment
                //fragment的管理器，开启事务，在activity中getSupportFragmentManager，在fragment中getChildFragmentManager)
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fl,frags.get(tab.getPosition()))
                        .commit();
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.d(TAG, "onTabUnselected: " + tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {// 再一次
                Log.d(TAG, "onTabReselected: " + tab.getPosition());
            }
        });


        // 动态加载fragment
        // fragment的管理器，开启事务(在activity中getSupportFragmentManager，在fragment中getChildFragmentManager)
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fl, frags.get(0))
                .commit();


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_Drader:
                Intent drawer=new Intent(getContext(), MainDrawerFragment.class);
                startActivity(drawer);
                break;

            case R.id.add:
                Intent add=new Intent(getContext(), AddActivity.class);
                startActivity(add);
                break;
        }
    }
}

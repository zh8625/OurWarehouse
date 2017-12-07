package fish.cool.coolfish.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fish.cool.coolfish.R;
import fish.cool.coolfish.activity.LoginActivity;
import fish.cool.coolfish.activity.MainActivity;
import fish.cool.coolfish.bean.User;
import fish.cool.coolfish.utils.JsonUtils;


/**
 * Created by ch on 2017/11/29.
 */

public class MainDrawerFragment extends Fragment {
    private ImageView iv_user;
    private TextView tv_username,tv_age,tv_sex,tv_unlogin;

    //
    private ViewGroup  container;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        this.container = container;
        View view=inflater.inflate(R.layout.frag_main_drawer,container,false);
        iv_user=view.findViewById(R.id.iv_user);
        tv_username=view.findViewById(R.id.tv_username);
        tv_age=view.findViewById(R.id.tv_age);
        tv_sex=view.findViewById(R.id.tv_sex);
        //
        tv_unlogin = view.findViewById(R.id.tv_unlogin);
        tv_unlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)container.getContext()).removeSP("SP_USER");
                Intent in = new Intent(container.getContext(), LoginActivity.class);
                startActivity(in);
                ((MainActivity) container.getContext()).finish();
            }
        });
        //
        String u =  ((MainActivity)container.getContext()).getSP("SP_USER");
        User user = JsonUtils.toBean(u,User.class);
        iv_user.setImageResource(Integer.valueOf(user.getUicon()));
        tv_username.setText(user.getUsername());
        tv_age.setText(user.getUage());
        tv_sex.setText(user.getUsex());


        return view;
    }
}

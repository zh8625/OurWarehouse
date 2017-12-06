package fish.cool.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fish.cool.coolfish.R;


/**
 * Created by ch on 2017/11/29.
 */

public class FragmentContent1 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        TextView view= (TextView) inflater.inflate(R.layout.frag_main_content_1,container,false);
        String s=getClass().getSimpleName();
        view.setText(s);
        return view ;
    }
}

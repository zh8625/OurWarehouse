package fish.cool.coolfish.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fish.cool.BaseActivity;
import fish.cool.coolfish.R;
import fish.cool.coolfish.adapter.RecyclerAddAdapter;

public class AddActivity extends BaseActivity implements View.OnClickListener {

    private TextView back;
    private RecyclerView rv_goodFriend_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        back=findViewById(R.id.back);
        back.setOnClickListener(this);
        //recyclerview陌生人
        rv_goodFriend_add = findViewById(R.id.rv_goodFriend_add);
        rv_goodFriend_add.setLayoutManager(new LinearLayoutManager(AddActivity.this));
        List list = new ArrayList<>();
        RecyclerAddAdapter adapter = new RecyclerAddAdapter(list);
        rv_goodFriend_add.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:

                AddActivity.this.finish();
                break;

        }
    }
}

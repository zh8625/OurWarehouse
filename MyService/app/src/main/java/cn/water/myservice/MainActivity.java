package cn.water.myservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == bt){
            Intent in =new Intent(MainActivity.this,ToastService.class);
            startService(in);
        }

    }
}

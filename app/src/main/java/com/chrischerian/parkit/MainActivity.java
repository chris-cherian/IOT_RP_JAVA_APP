package com.chrischerian.parkit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chrischerian.parkit.Screens.ListActivity;
import com.chrischerian.parkit.Singleton.SingletonClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar pb = findViewById(R.id.progress_bar);
        final Button bt = (Button) findViewById(R.id.bt);
        final TextView status_tv = findViewById(R.id.status_tv);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }
        });

        SingletonClient.getInstance();

        SingletonClient.getInstance().getConnectionStatus().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    pb.setVisibility(View.GONE);
                    bt.setVisibility(View.VISIBLE);
                    status_tv.setVisibility(View.GONE);

                }
            }
        });


    }
}

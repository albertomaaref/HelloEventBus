package com.example.alim.helloeventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,SlaveActivity.class);
                startActivity(i);
            }
        });
    }

    @Subscribe
    public void sonoA(ClasseA classeA){
        Log.i("ALI",""+classeA.getNumero());
    }

    @Subscribe
    public void sonoB(ClasseB classeB){
        Log.i("ALI",classeB.getLettera());
    }



}

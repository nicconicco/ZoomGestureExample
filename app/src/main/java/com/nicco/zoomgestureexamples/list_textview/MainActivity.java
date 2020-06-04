package com.nicco.zoomgestureexamples.list_textview;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.nicco.zoomgestureexamples.R;

interface OnClick {
    void onClick();
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int dimension = 10;

        PinchRecyclerView pinchRecyclerView = (PinchRecyclerView) findViewById(R.id.list);
        pinchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleAdapter simpleAdapter = new SimpleAdapter(dimension * dimension, new OnClick() {
            @Override
            public void onClick() {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        pinchRecyclerView.setAdapter(simpleAdapter);
    }
}

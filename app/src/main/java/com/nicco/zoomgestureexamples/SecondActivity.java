package com.nicco.zoomgestureexamples;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        int dimension = 10;

        PinchRecyclerView pinchRecyclerView = findViewById(R.id.pinch_recycler_view);
        pinchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleAdapter simpleAdapter = new SimpleAdapter(dimension * dimension, new OnClick() {
            @Override
            public void onClick() {
            }
        });
        pinchRecyclerView.setAdapter(simpleAdapter);
    }
}

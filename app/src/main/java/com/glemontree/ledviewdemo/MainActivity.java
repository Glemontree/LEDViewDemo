package com.glemontree.ledviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private LEDView ledView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ledView = (LEDView) findViewById(R.id.ledview);
    }

    public void start(View view) {
        ledView.start();
    }

    public void end(View view) {
        ledView.stop();
    }
}

package com.example.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    boolean isExpand = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        LinearLayout parentLayout = findViewById(R.id.parentLayout);
        List<PieChartModel> items = new ArrayList<>();
        items.add(new PieChartModel("Citrix",8f, Color.RED));
        items.add(new PieChartModel("MS MCP",29f, Color.YELLOW));
        items.add(new PieChartModel("Cisco",32f, Color.GREEN));
        items.add(new PieChartModel("Palo Alto",5f, Color.GRAY));
        items.add(new PieChartModel("Azure",9f, Color.MAGENTA));
        items.add(new PieChartModel("O365",10f, Color.BLUE));
        items.add(new PieChartModel("VMWare",15f, Color.BLACK));
        PieChartAdapter test = new PieChartAdapter(getApplicationContext(),items);
        parentLayout.addView(test);
    }
}

package com.example.myapplication;

import android.graphics.Color;

public class PieChartModel {

    private String name;
    private float points;
    private int color;

    public PieChartModel(String name, float points, int color){
        this.name = name;
        this.points = points;
        this.color = color;
    }

    public String getName(){
        return this.name;
    }

    public float getPoints(){
        return this.points;
    }

    public int getColor(){
        return this.color;
    }
}

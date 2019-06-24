package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class PieChartAdapter extends CardView {
    private PieChartView pieChartView;
    private List<PieChartModel> items;
    private View rootView;

    public PieChartAdapter(Context context, List<PieChartModel> items) {
        super(context);
        this.items =items;
        rootView = LayoutInflater.from(context).inflate(R.layout.cardview_pie_graph,this);
        pieChartView = rootView.findViewById(R.id.pieView);
        initialize();
    }

    private void initialize(){
        List<SliceValue> pieData = parseSliceValue(items);
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabelsOutside(true).setValueLabelTextSize(8);
        pieChartData.setHasLabels(true).setValueLabelTextSize(8);
        pieChartData.setValueLabelsTextColor(Color.BLACK);
        pieChartData.setValueLabelBackgroundEnabled(false);
        pieChartData.setHasCenterCircle(true).setCenterCircleScale(.8f).setCenterText1(""+String.format("%.0f",getTotalPoints())).setCenterText1FontSize(24);
        pieChartView.setPieChartData(pieChartData);
        LinearLayout addDetails = rootView.findViewById(R.id.details);
        if(items.size()!=0){
            for(PieChartModel current:items){
                TextView addData = new TextView(getContext());
                addData.setTextSize(18);
                addData.setText(""+current.getColor());
                addData.append(":"+current.getName());
                addData.append(" "+current.getPoints());
                addDetails.addView(addData);
            }
        }

    }

    private List<SliceValue> parseSliceValue(List<PieChartModel> items){
        List<SliceValue> pieData = new ArrayList<>();
        if(items.size()!=0){
            for(PieChartModel current:items){
                pieData.add(new SliceValue(current.getPoints(), current.getColor()).setLabel(""+String.format("%.2f", (current.getPoints()/getTotalPoints())*100)+"%"));
            }
        }
        return pieData;
    }

    private float getTotalPoints(){
        float total = 0;
        if(items.size()!=0){
            for (PieChartModel current:items) {
                total += current.getPoints();
            }
        }
        return total;
    }

}

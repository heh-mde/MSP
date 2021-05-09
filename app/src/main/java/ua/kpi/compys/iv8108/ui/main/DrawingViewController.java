package ua.kpi.compys.iv8108.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

import ua.kpi.compys.iv8108.R;

import static android.view.View.INVISIBLE;

public class DrawingViewController extends Fragment {
    private LineChart lineChart;
    private PieChart pieChart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Switch graphSwitch = view.findViewById(R.id.graphSwitch);
        graphSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    pieChart.setVisibility(View.VISIBLE);
                    lineChart.setVisibility(INVISIBLE);
                } else {
                    lineChart.setVisibility(View.VISIBLE);
                    pieChart.setVisibility(INVISIBLE);
                }
            }
        });
        initialiseLineFragment();
        initialisePieFragment();
    }

    private void initialiseLineFragment() {
        lineChart = getView().findViewById(R.id.graphPlot);
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis yAxisLeft = lineChart.getAxisLeft();
        yAxisLeft.setDrawAxisLine(false);
        yAxisLeft.setDrawGridLines(false);
        yAxisLeft.setDrawZeroLine(true);

        YAxis yAxisRight = lineChart.getAxisRight();
        yAxisRight.setEnabled(false);

        ArrayList<Entry> dataSet = new ArrayList<>();
        for (float x = -4; x < 4; x += 0.01f) {
            dataSet.add(new Entry(x, (float) Math.log(x)));
        }
        ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
        iLineDataSets.add(new LineDataSet(dataSet, ""));
        LineData lineData = new LineData(iLineDataSets);

        Description desc = new Description();
        desc.setText("");
        lineChart.setDescription(desc);
        lineChart.setData(lineData);
        lineChart.invalidate();
    }

    private void initialisePieFragment() {
        ArrayList<PieEntry> dataSet;
        dataSet = new ArrayList<>();
        dataSet.add(new PieEntry(10, 10));
        dataSet.add(new PieEntry(20, 20));
        dataSet.add(new PieEntry(25, 25));
        dataSet.add(new PieEntry(5, 5));
        dataSet.add(new PieEntry(40, 40));


        ArrayList<Integer> colors;
        colors = new ArrayList<>();
        colors.add(Color.parseColor("#FFFF00"));
        colors.add(Color.parseColor("#008000"));
        colors.add(Color.parseColor("#0000FF"));
        colors.add(Color.parseColor("#FF0000"));
        colors.add(Color.parseColor("#00FFFF"));

        PieDataSet pieDataSet = new PieDataSet(dataSet,"");
        pieDataSet.setColors(colors);
        PieData pieData = new PieData(pieDataSet);
        pieData.setDrawValues(false);

        pieChart = getView().findViewById(R.id.diagramPlot);
        pieChart.setData(pieData);
        pieChart.invalidate();

        pieChart.getDescription().setEnabled(false);
        pieChart.animate();
        pieChart.setVisibility(INVISIBLE);
    }
}

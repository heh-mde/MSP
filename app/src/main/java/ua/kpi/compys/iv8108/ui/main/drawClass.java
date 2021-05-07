package ua.kpi.compys.iv8108.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import java.util.Objects;
import static android.view.View.INVISIBLE;
import ua.kpi.compys.iv8108.R;

public class drawClass extends Fragment {
    private LineChart lineChart;
    private PieChart pieChart;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Switch Switch = view.findViewById(R.id.graphSwitch);
        Switch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                pieChart.setVisibility(View.VISIBLE);
                lineChart.setVisibility(INVISIBLE);
            } else {
                lineChart.setVisibility(View.VISIBLE);
                pieChart.setVisibility(INVISIBLE);
            }
        });
        initialiseLineFragment();
        initialisePieFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_second, container, false);
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
        pieChart = Objects.requireNonNull(getView()).findViewById(R.id.diagramPlot);
        pieChart.setData(pieData);
        pieChart.invalidate();
        pieChart.getDescription().setEnabled(false);
        pieChart.animate();
        pieChart.setVisibility(INVISIBLE);
    }

    private void initialiseLineFragment() {
        lineChart = Objects.requireNonNull(getView()).findViewById(R.id.graphPlot);
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        YAxis yAxisRight = lineChart.getAxisRight();
        yAxisRight.setEnabled(false);
        YAxis yAxisLeft = lineChart.getAxisLeft();
        yAxisLeft.setDrawAxisLine(true);
        yAxisLeft.setDrawGridLines(false);
        yAxisLeft.setDrawZeroLine(true);
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (float x = -4; x < 4; x += 0.01f) {
            dataSet.add(new Entry(x, (float) Math.log(x)));
        }
        ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
        iLineDataSets.add(new LineDataSet(dataSet, " "));
        LineData lineData = new LineData(iLineDataSets);
        Description desc = new Description();
        desc.setText("Circle Diagram: variant 3");
        lineChart.setDescription(desc);
        lineChart.setData(lineData);
        lineChart.invalidate();
    }
}

package ua.kpi.compys.iv8108;
import ua.kpi.compys.iv8108.ui.main.sectionClass;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sectionClass sectionsPagerAdapter = new sectionClass(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        Objects.requireNonNull(tabs.getTabAt(0)).setIcon(R.drawable.ic_action_home);
        tabs.getTabAt(1).setIcon(R.drawable.ic_dashboard_black_24dp);
    }
}
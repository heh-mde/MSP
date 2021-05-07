package ua.kpi.compys.iv8108.ui.main;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import ua.kpi.compys.iv8108.R;

public class sectionClass extends FragmentPagerAdapter {
    @Nullable
    @Override
    public CharSequence getPageTitle(int a) {
        return mContext.getResources().getString(TAB_TITLES[a]);
    }
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.screen_1, R.string.screen_2};
    private final Context mContext;
    public sectionClass(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }
    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public Fragment getItem(int a) {
        switch (a) {
            case 0:
                return new contrClass();
            case 1:
                return new drawClass();
            default:
                return holderClass.newInstance(a + 1);
        }
    }

}
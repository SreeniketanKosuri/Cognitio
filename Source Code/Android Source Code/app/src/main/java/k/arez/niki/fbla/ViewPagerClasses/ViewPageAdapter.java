package k.arez.niki.fbla.ViewPagerClasses;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import k.arez.niki.fbla.Fragments.MainFragment;
import k.arez.niki.fbla.Fragments.AttributionFragment;
import k.arez.niki.fbla.Fragments.TriviaFragment;

public class ViewPageAdapter extends FragmentPagerAdapter {
    public ViewPageAdapter(FragmentManager fm) {
        super(fm);
    }
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AttributionFragment();
            case 1:
                return new MainFragment();
            case 2:
                return new TriviaFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

package zeta.example.com.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 2016/10/26 0026.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<String> tabinfos;
    private List<Fragment> mFragments;

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> tabinfos){
        super(fm);
        this.mFragments = fragments;
        this.tabinfos = tabinfos;
//        Log.e("lifeprocess","***************MyFragmentPagerAdapter");

    }

    @Override
    public CharSequence getPageTitle(int position) {
//        Log.e("lifeprocess","***************getPageTitle");

        return tabinfos.get(position%tabinfos.size());

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = mFragments.get(position);
//        tagPosition.getPosition(position);
//        Log.e("lifeprocess","***************getItem");
        return fragment;
    }

    @Override
    public int getCount() {
//        Log.e("lifeprocess","***************getCount");
        return mFragments.size();
    }


}

package com.example.usuario.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

class ViewPagerAdapter extends FragmentPagerAdapter {
    private int pageCount = 5;
    private ArrayList<String> titles;

    public ViewPagerAdapter(FragmentManager supporFragmentManager, int pageCount, ArrayList<String> titles) {
        super(supporFragmentManager);
        this.pageCount = pageCount;
        this.titles = titles;
    }
    public ViewPagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        CustomFragment customFragment = null;
        Bundle arguments = new Bundle();
        switch (position) {
            case 0:
                arguments.putString(CustomFragment.KEY_MESSAGE, "Fragment1");
                customFragment = CustomFragment.newInstance(arguments);
                break;
            case 1:
                arguments.putString(CustomFragment.KEY_MESSAGE, "Fragment2");
                customFragment = CustomFragment.newInstance(arguments);
                break;
            case 2:
                arguments.putString(CustomFragment.KEY_MESSAGE, "Fragment3");
                customFragment = CustomFragment.newInstance(arguments);
                break;
            case 3:
                arguments.putString(CustomFragment.KEY_MESSAGE, "Fragment4");
                customFragment = CustomFragment.newInstance(arguments);
                break;
            case 4:
                arguments.putString(CustomFragment.KEY_MESSAGE, "Fragment5");
                customFragment = CustomFragment.newInstance(arguments);
                break;
        }
        return customFragment;
    }

    @Override
    public int getCount() {
        return pageCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);//return titles.get(position);
    }

}

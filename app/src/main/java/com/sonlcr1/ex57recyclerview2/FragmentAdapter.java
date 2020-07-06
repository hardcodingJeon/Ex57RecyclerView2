package com.sonlcr1.ex57recyclerview2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

    Fragment[] fragment = new Fragment[2];

    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragment[0] = new com.sonlcr1.ex57recyclerview2.Fragment();
        fragment[1] = new Fragment2();

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragment[position];
    }

    @Override
    public int getCount() {
        return fragment.length;
    }
}

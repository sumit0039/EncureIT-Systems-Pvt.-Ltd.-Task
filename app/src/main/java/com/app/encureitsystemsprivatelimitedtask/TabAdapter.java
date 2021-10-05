package com.app.encureitsystemsprivatelimitedtask;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabAdapter extends FragmentStateAdapter {
    int mNumOfTabs;

    public TabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, int NoOfTabs) {
        super(fragmentManager, lifecycle);
        this.mNumOfTabs = NoOfTabs;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                Tab1 tab1 = new Tab1();
                return tab1;
            case 1:
                Tab2 tab2 = new Tab2();
                return tab2;
            default:
                return null;
        }

    }
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Tab1";
        }else if(position==1){
            return "Tab2";
        }
        return "";
    }


    @Override
    public int getItemCount() {
        return mNumOfTabs;
    }
}

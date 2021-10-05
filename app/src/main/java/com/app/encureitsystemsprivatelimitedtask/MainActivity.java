package com.app.encureitsystemsprivatelimitedtask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.app.encureitsystemsprivatelimitedtask.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    public static ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        settingTab();
    }

    private void settingTab() {

        binding.tabOrder.addTab(binding.tabOrder.newTab().setText("Recent Orders"));
        binding.tabOrder.addTab(binding.tabOrder.newTab().setText("Privacy Policy"));
        binding.tabOrder.setTabGravity(TabLayout.GRAVITY_FILL);
        TabAdapter tabAdapter = new TabAdapter(MainActivity.this.getSupportFragmentManager(), getLifecycle(), binding.tabOrder.getTabCount());
        binding.viewPagerOrder.setAdapter(tabAdapter);

        new TabLayoutMediator(binding.tabOrder, binding.viewPagerOrder, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TabAdapter vi = (TabAdapter) binding.viewPagerOrder.getAdapter();
                if (vi != null) {
                    tab.setText(vi.getPageTitle(position));

                }
            }
        }).attach();
    }
}
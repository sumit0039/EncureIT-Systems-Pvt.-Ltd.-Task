package com.app.encureitsystemsprivatelimitedtask;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.encureitsystemsprivatelimitedtask.Preference.SharedPreferenceConfig;
import com.app.encureitsystemsprivatelimitedtask.Preference.UserSharedpreference;
import com.app.encureitsystemsprivatelimitedtask.databinding.FragmentTab2Binding;


public class Tab2 extends Fragment {
    private FragmentTab2Binding binding;
    private View root;
    private UserSharedpreference userSharedpreference;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_tab2, container, false);
        root = binding.getRoot();
        userSharedpreference = new UserSharedpreference(getActivity());

        binding.universityName.setText(userSharedpreference.getStringData(SharedPreferenceConfig.NAME));
        binding.universityCountry.setText(userSharedpreference.getStringData(SharedPreferenceConfig.COUNTRY));
        binding.universityAlphaTwoCode.setText(userSharedpreference.getStringData(SharedPreferenceConfig.ALPHA_TO_CODE));

        return root;

    }
}
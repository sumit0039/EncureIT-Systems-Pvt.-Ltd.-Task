package com.app.encureitsystemsprivatelimitedtask;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.encureitsystemsprivatelimitedtask.Listener.AppListener;
import com.app.encureitsystemsprivatelimitedtask.Network.ApiController;
import com.app.encureitsystemsprivatelimitedtask.Preference.SharedPreferenceConfig;
import com.app.encureitsystemsprivatelimitedtask.Preference.UserSharedpreference;
import com.app.encureitsystemsprivatelimitedtask.databinding.FragmentTab1Binding;


import java.util.List;


public class Tab1 extends Fragment implements UniversitiesAdapter.GetName{
    private FragmentTab1Binding binding;
    private View root;
    private ApiController apiController;
    private UserSharedpreference userSharedpreference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_tab1, container, false);
        root = binding.getRoot();
        userSharedpreference = new UserSharedpreference(getActivity());

        apiController = new ApiController(getActivity());
        getList();
        return root;
    }

    private void getList(){
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setCountyName("India");
        apiController.getList(taskRequest, new AppListener.OnListListener() {
            @Override
            public void onSuccess(List<TaskResponse> taskResponse) {
                Log.d("gsvdhcgvds", "onSuccess: "+ "success");
                binding.rv.setHasFixedSize(true);
                binding.rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                binding.rv.setAdapter(new UniversitiesAdapter(getActivity(),taskResponse,Tab1.this));
            }

            @Override
            public void onFailure(String message) {
                Log.d("gsvdhcgvds", "onSuccess: "+ message);
            }
        });
    }


    @Override
    public void getName(String name, String country, String alpha_two_code, Object state_province) {
        userSharedpreference.saveStringData(SharedPreferenceConfig.NAME,name);
        userSharedpreference.saveStringData(SharedPreferenceConfig.COUNTRY,country);
        userSharedpreference.saveStringData(SharedPreferenceConfig.ALPHA_TO_CODE,alpha_two_code);
        MainActivity.binding.viewPagerOrder.setCurrentItem(1);
    }
}
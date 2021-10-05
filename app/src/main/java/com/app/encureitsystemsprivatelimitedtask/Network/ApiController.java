package com.app.encureitsystemsprivatelimitedtask.Network;

import android.app.ActivityManager;
import android.content.Context;


import com.app.encureitsystemsprivatelimitedtask.Interface.ApiService;
import com.app.encureitsystemsprivatelimitedtask.Listener.AppListener;
import com.app.encureitsystemsprivatelimitedtask.Preference.UserSharedpreference;
import com.app.encureitsystemsprivatelimitedtask.TaskRequest;
import com.app.encureitsystemsprivatelimitedtask.TaskResponse;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ApiController {
    private Context context;
    private ApiService apiService;
    private UserSharedpreference userSharedpreference;

    public ApiController(Context context) {
        this.context = context;
        apiService = RetrofitClient.getInterface();
        userSharedpreference = UserSharedpreference.getInstance(context);
    }

    public void getList(TaskRequest taskRequest,final AppListener.OnListListener onListListener){
        RequestBody CountryName = RequestBody.create(okhttp3.MultipartBody.FORM, taskRequest.getCountyName());
        apiService.getList(CountryName)
                .enqueue(new Callback<List<TaskResponse>>() {
                    @Override
                    public void onResponse(Call<List<TaskResponse>> call, Response<List<TaskResponse>> response) {
                        if (response.isSuccessful()){
                            onListListener.onSuccess(response.body());
                        }else {
                            onListListener.onFailure("something went wrong");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<TaskResponse>> call, Throwable t) {
                     onListListener.onFailure(t.getMessage());
                    }
                });

    }

}

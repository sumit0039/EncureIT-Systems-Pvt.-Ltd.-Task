package com.app.encureitsystemsprivatelimitedtask.Interface;

import com.app.encureitsystemsprivatelimitedtask.Network.NetworkConfig;
import com.app.encureitsystemsprivatelimitedtask.TaskResponse;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    @Multipart
    @POST("/country.php")
    Call<List<TaskResponse>> getList(@Part("country") RequestBody countryName);



    }




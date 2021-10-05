package com.app.encureitsystemsprivatelimitedtask.Listener;


import com.app.encureitsystemsprivatelimitedtask.TaskResponse;

import java.util.List;

public class AppListener {

    public interface OnListListener{
        void onSuccess(List<TaskResponse> taskResponse);
        void onFailure(String message);
    }
}

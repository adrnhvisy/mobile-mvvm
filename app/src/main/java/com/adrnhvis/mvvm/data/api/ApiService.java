package com.adrnhvis.mvvm.data.api;

import com.adrnhvis.mvvm.data.model.DataResponse;
import retrofit2.Call;
import retrofit2.http.PUT;

public interface ApiService {
    @PUT("counter")
    Call<DataResponse> updateCounter();
}
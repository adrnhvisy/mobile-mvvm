package com.adrnhvis.mvvm.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.adrnhvis.mvvm.data.api.ApiConfig;
import com.adrnhvis.mvvm.data.model.DataResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CounterRepository {

    // MutableLiveData untuk menampung perubahan nilai counter dari server
    private final MutableLiveData<Integer> counterLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    // Fungsi untuk memicu request PUT ke Laravel
    public void incrementCounter() {
        ApiConfig.getApiService().updateCounter().enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(@NonNull Call<DataResponse> call, @NonNull Response<DataResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Ambil nilai 'value' dari dalam objek cetakan DataResponse
                    int newValue = response.body().getData().getValue();
                    counterLiveData.setValue(newValue);
                } else {
                    errorLiveData.setValue("Gagal memuat data dari server");
                }
            }

            @Override
            public void onFailure(@NonNull Call<DataResponse> call, @NonNull Throwable t) {
                errorLiveData.setValue("Koneksi gagal: " + t.getMessage());
            }
        });
    }

    // Getter agar ViewModel bisa memantau LiveData dari Repository
    public LiveData<Integer> getCounter() {
        return counterLiveData;
    }

    public LiveData<String> getError() {
        return errorLiveData;
    }
}
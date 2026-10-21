package com.adrnhvis.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.adrnhvis.mvvm.data.repository.CounterRepository;

public class CounterViewModel extends ViewModel {

    private final CounterRepository repository;

    public CounterViewModel() {
        repository = new CounterRepository();
    }

    // Meminta Repository untuk melakukan request update ke Laravel
    public void incrementCounter() {
        repository.incrementCounter();
    }

    // Menyediakan LiveData agar bisa diamati (observed) oleh Activity/Fragment
    public LiveData<Integer> getCounter() {
        return repository.getCounter();
    }

    public LiveData<String> getError() {
        return repository.getError();
    }
}
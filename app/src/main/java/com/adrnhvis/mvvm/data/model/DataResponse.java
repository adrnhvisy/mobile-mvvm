package com.adrnhvis.mvvm.data.model;

import com.google.gson.annotations.SerializedName;

public class DataResponse {

    // Mencocokkan dengan objek "data" di JSON
    @SerializedName("data")
    private CounterData data;

    public CounterData getData() {
        return data;
    }

    // Kelas anak untuk struktur di dalam "data"
    public class CounterData {

        // Mencocokkan dengan angka "value" di JSON
        @SerializedName("value")
        private int value;

        public int getValue() {
            return value;
        }
    }
}
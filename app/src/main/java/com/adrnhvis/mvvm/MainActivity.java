package com.adrnhvis.mvvm;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.adrnhvis.mvvm.viewmodel.CounterViewModel;

public class MainActivity extends AppCompatActivity {

    private CounterViewModel counterViewModel;
    private TextView tvCounter;
    private Button btnIncrement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tvCounter);
        btnIncrement = findViewById(R.id.btnIncrement);

        // Inisialisasi ViewModel
        counterViewModel = new ViewModelProvider(this).get(CounterViewModel.class);

        // Mengamati (observe) perubahan data counter dari ViewModel
        counterViewModel.getCounter().observe(this, value -> {
            // Perbarui tampilan TextView setiap kali ada data baru dari server Laravel
            tvCounter.setText(String.valueOf(value));
        });

        // Mengamati pesan error jika koneksi gagal
        counterViewModel.getError().observe(this, errorMessage -> {
            Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
        });

        // Aksi ketika tombol diklik
        btnIncrement.setOnClickListener(v -> {
            // Memanggil fungsi di ViewModel untuk menembak endpoint PUT /api/counter
            counterViewModel.incrementCounter();
        });
    }
}
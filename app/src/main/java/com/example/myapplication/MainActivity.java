package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private int sekundy = 0;
    private boolean realizowany = false;
    private boolean byl_uruchomiony = false;

    @Override
    protected void onCreate(Bundle paczka) {
        super.onCreate(paczka);
        setContentView(R.layout.activity_main);

        if (paczka != null) {
            sekundy = paczka.getInt("sekundy");
            realizowany = paczka.getBoolean("realizacja");
            byl_uruchomiony = paczka.getBoolean("poprzednio");
        }
        runStopper();
    }

    @Override
    public void onSaveInstanceState(Bundle paczka) {
        super.onSaveInstanceState(paczka);
        paczka.putInt("sekundy", sekundy);
        paczka.putBoolean("realizacja", realizowany);
        paczka.putBoolean("poprzednio", byl_uruchomiony);
    }
}

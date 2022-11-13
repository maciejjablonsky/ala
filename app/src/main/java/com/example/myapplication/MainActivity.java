package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

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
        runStoper();
    }

    @Override
    public void onSaveInstanceState(Bundle paczka) {
        super.onSaveInstanceState(paczka);
        paczka.putInt("sekundy", sekundy);
        paczka.putBoolean("realizacja", realizowany);
        paczka.putBoolean("poprzednio", byl_uruchomiony);
    }

    private void runStoper(){
        TextView wyswietlacz = findViewById(R.id.tekst);
        final Handler uchwyt = new Handler();
        uchwyt.post(new Runnable() {
            @Override
            public void run() {
                // kod metody a w nim również metoda postDelayed
            }
        });
    }


}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int sekundy = 0;
    private boolean realizowany = false;
    private boolean byl_uruchomiony = true;

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

    private void runStoper() {
        TextView wyswietlacz = findViewById(R.id.tekst);
        final Handler uchwyt = new Handler();
        uchwyt.post(new Runnable() {
            @Override
            public void run() {
                int godziny = sekundy / 3600;
                int minuty = (sekundy % 3600) / 60;
                int sek = sekundy % 60;
                String czas = String.format("%d:%02d:%02d", godziny, minuty, sek);
                wyswietlacz.setText(czas);
                if (realizowany) sekundy++;
                uchwyt.postDelayed(this, 1000);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        byl_uruchomiony = realizowany;
        realizowany = false;
        Log.v("kom.2",
                "onPause wywołana");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (byl_uruchomiony) realizowany = true;
        Log.v("kom.1",
                "onResume wywołana");

    }

}

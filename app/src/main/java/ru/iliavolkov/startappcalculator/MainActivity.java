package ru.iliavolkov.startappcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pusk = findViewById(R.id.pusk);

        Intent intentCalc = getPackageManager().getLaunchIntentForPackage("ru.iliavolkov.calculator");

        pusk.setOnClickListener(v -> {
            if (intentCalc != null) {
                intentCalc.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentCalc);
            } else Toast.makeText(this, "У вас не установлено это приложение", Toast.LENGTH_SHORT).show();

        });
    }
}
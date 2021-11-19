package com.example.am;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MapsRutas extends AppCompatActivity {

    EditText ini, dest;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_rutas);

        ini = findViewById(R.id.inicio);
        dest = findViewById(R.id.destino);
        btn = findViewById(R.id.btngo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inicio = ini.getText().toString().trim();
                String fin = dest.getText().toString().trim();
                if (inicio.equals("") && fin.equals("")) {
                    Toast.makeText(getApplicationContext(), "Ingrese una locacion,",
                            Toast.LENGTH_SHORT).show();
                } else {
                    DisplayTrack(inicio, fin);
                }
            }
        });
    }

    private void DisplayTrack(String inicio, String fin) {
        try{
            Uri uri=Uri.parse("https://www.google.co.in/maps/dir/"+inicio+"/"+fin);
            Intent intent= new Intent(Intent.ACTION_VIEW,uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        catch (ActivityNotFoundException e){
            Uri uri=Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent= new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}


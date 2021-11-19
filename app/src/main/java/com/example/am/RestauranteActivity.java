package com.example.am;

import android.Manifest;
import android.app.AppComponentFactory;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public class RestauranteActivity extends AppCompatActivity {
    ImageView img;
    TextView descrip,titu,ubica,lola;
    ImageButton btn;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        img= findViewById(R.id.imgres);
        titu= findViewById(R.id.txtTitulo);
        descrip= findViewById(R.id.txtdescripcion);
        ubica= findViewById(R.id.txtubicacion); 
        btn= findViewById(R.id.btnimgruta);
        lola=findViewById(R.id.longlat);

        Intent i=getIntent();
        String titulo=i.getStringExtra("titulo");
        String descripcion=i.getStringExtra("descripcion");
        String ubicacion=i.getStringExtra("ubicacion");
        String longlat=i.getStringExtra("LongLat");
        int imagen= i.getIntExtra("foto",0);
        String yo="-13.5446821,-71.8902527";


        titu.setText(titulo);
        descrip.setText(descripcion);
        ubica.setText(ubicacion);
        img.setImageResource(imagen);
        lola.setText(longlat);



        //----------------------------------------------------------/-------//
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inicio = titu.getText().toString().trim();
                String fin = lola.getText().toString().trim();
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

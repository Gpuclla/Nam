package com.example.am;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.am.databinding.ActivityMapsMmodernasBinding;

public class MapsMModernas extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ActivityMapsMmodernasBinding binding;
    private Marker markerPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsMmodernasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Marcador de Taj Mahal
        LatLng Taj = new LatLng(27.175335656846666, 78.04214220339504);
        mMap.addMarker(new MarkerOptions().position(Taj).title("Taj Mahal-India").snippet("Mausoleo del siglo XVII, revestido de mármol.").icon(BitmapDescriptorFactory.fromResource(R.drawable.taj)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(Cusco));

        //Marcador de Petra
        LatLng Petra  = new LatLng(30.32863031330995, 35.44440511914245);
        mMap.addMarker(new MarkerOptions().position(Petra ).title("Petra-Jordania").snippet("Fachadas de templos mortuorios, esculpidas en roca.").icon(BitmapDescriptorFactory.fromResource(R.drawable.petra)));

        //Marcador de la La Gran Muralla china
        LatLng Muralla = new LatLng(40.432095490077806, 116.57034271902695);
        mMap.addMarker(new MarkerOptions().position(Muralla).title("La Gran Muralla china-China").snippet("Concebida como muro defensivo, cuenta con 6000 kilómetros de largo.").icon(BitmapDescriptorFactory.fromResource(R.drawable.muralla)));

        //Marcador de Chichén Itzá
        LatLng Chichén = new LatLng(20.679363803701442, -88.56831595786151);
        mMap.addMarker(new MarkerOptions().position(Chichén).title("Chichén Itzá-México").snippet("Era un centro político-religioso del imperio maya.").icon(BitmapDescriptorFactory.fromResource(R.drawable.chichen)));

        // Marcador de Machu Picchu, Perú
        LatLng Saqsaywaman = new LatLng(-13.162963583093736, -72.54495217280251);
        mMap.addMarker(new MarkerOptions().position(Saqsaywaman).title("Machu Picchu-Perú").snippet("Ciudadela Inca construida en las montaña.").icon(BitmapDescriptorFactory.fromResource(R.drawable.picchi)));

        // Marcador de Coliseo - Italia
        LatLng Coliseo = new LatLng(41.890329961271625, 12.49220944590936);
        mMap.addMarker(new MarkerOptions().position(Coliseo).title("Coliseo Romano-Italia").snippet("En su día fue escenarios de espectáculos y luchas de gladiadores.").icon(BitmapDescriptorFactory.fromResource(R.drawable.coliseo)));

        // Marcador de El Cristo Redentor, Brasil
        LatLng Cristo = new LatLng(-22.951708500577332, -43.21045501677034);
        mMap.addMarker(new MarkerOptions().position(Cristo).title("El Cristo Redentor-Brasil").snippet("Tiene 30 metros de altura y pesa 1145 toneladas.").icon(BitmapDescriptorFactory.fromResource(R.drawable.cristo)));

        //camara zoom
        googleMap.setOnMarkerClickListener(this);

    }
    @Override
    public boolean onMarkerClick(@NonNull Marker marker)
    {
        String lat,lng;
        lat=Double.toString(marker.getPosition().latitude);
        lng=Double.toString(marker.getPosition().longitude);

        Toast.makeText(this,"lat:"+lat+"-"+"long:"+lng,Toast.LENGTH_LONG).show();
        return false;
    }

}
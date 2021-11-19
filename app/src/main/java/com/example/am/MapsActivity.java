package com.example.am;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
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
import com.example.am.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {


    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Marker markerPrueba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
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

        // Marcador de Moray
        LatLng Moray = new LatLng(-13.3298634, -72.1958153);
        mMap.addMarker(new MarkerOptions().position(Moray).title("Moray").snippet("Sitio arqueológico de andenes circulares.").icon(BitmapDescriptorFactory.fromResource(R.drawable.moray)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(Cusco));

        //Marcador de la catedral de cusco
        LatLng Catedral = new LatLng(-13.51616861928473, -71.97807664893274);
        mMap.addMarker(new MarkerOptions().position(Catedral).title("Catedral del Cuzco").snippet("Principal templo de la ciudad del Cuzco.").icon(BitmapDescriptorFactory.fromResource(R.drawable.catedral)));

        //Marcador de la Chomba
        LatLng Chomba = new LatLng(-13.517776801430182, -71.9742092342708);
        mMap.addMarker(new MarkerOptions().position(Chomba).title("La Chomba Ajha Wasi").snippet("Quita Restaurante y Picanteria.").icon(BitmapDescriptorFactory.fromResource(R.drawable.chomba)));

        //Marcador de Pisac
        LatLng Pisac = new LatLng(-13.40734596126217, -71.84411128620795);
        mMap.addMarker(new MarkerOptions().position(Pisac).title("Parque Arqueológico Pisac").snippet("Centro arqueológico importante del Valle Sagrado.").icon(BitmapDescriptorFactory.fromResource(R.drawable.pisaq)));

        // mMarcador de Saqsaywaman
        LatLng Saqsaywaman = new LatLng(-13.509595180594943, -71.98159124261807);
        mMap.addMarker(new MarkerOptions().position(Saqsaywaman).title("Saqsaywaman").snippet("Fortaleza ceremonial inca.").icon(BitmapDescriptorFactory.fromResource(R.drawable.saqsaywaman)));

        //camara zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Catedral, 10));
        googleMap.setOnMarkerClickListener(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

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
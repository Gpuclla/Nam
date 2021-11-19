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
import com.example.am.databinding.ActivityMapsMantiguasBinding;

public class MapsMAntiguas extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ActivityMapsMantiguasBinding binding;
    private Marker markerPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsMantiguasBinding.inflate(getLayoutInflater());
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

        // Marcador de La gran pirámide de Giza
        LatLng Giza = new LatLng(29.97943627955704, 31.134153403126955);
        mMap.addMarker(new MarkerOptions().position(Giza).title(" La gran pirámide de Giza").snippet("Construida como la tumba del faraón Keops.").icon(BitmapDescriptorFactory.fromResource(R.drawable.giza)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(Cusco));

        //Marcador de la Mausoleo de Halicarnaso
        LatLng Halicarnaso = new LatLng(37.03791301637418, 27.424116285576325);
        mMap.addMarker(new MarkerOptions().position(Halicarnaso).title("Mausoleo de Halicarnaso").snippet("Sitio arqueológico con ruinas de la enorme tumba.").icon(BitmapDescriptorFactory.fromResource(R.drawable.halcarnaso)));

        //Marcador de la Estatua de Zeus
        LatLng Zeus = new LatLng(37.63809718789613, 21.630214104110884);
        mMap.addMarker(new MarkerOptions().position(Zeus).title("La estatua de Zeus").snippet("Ancestral templo griego clásico, ahora en ruinas.").icon(BitmapDescriptorFactory.fromResource(R.drawable.zeus)));

        //Marcador de los Jardines Colgantes de Babilonia
        LatLng Babilonia = new LatLng(32.54230993160304, 44.42088974049255);
        mMap.addMarker(new MarkerOptions().position(Babilonia).title("Jardines Colgantes de Babilonia").snippet("Maravilla más misteriosa situada en Irak.").icon(BitmapDescriptorFactory.fromResource(R.drawable.babilonia)));

        // Marcador de El Faro de Alejandría
        LatLng Faro = new LatLng(31.214134092410248, 29.885304361088426);
        mMap.addMarker(new MarkerOptions().position(Faro).title("El Faro de Alejandría").snippet("Torre construida en el siglo III a.C.").icon(BitmapDescriptorFactory.fromResource(R.drawable.faro)));

        // Marcador de El Templo de Artemisa
        LatLng Artemisa = new LatLng(37.94958840860109, 27.36391301232232);
        mMap.addMarker(new MarkerOptions().position(Artemisa).title("El Templo de Artemisa").snippet("En el interior había una estatua de la diosa Artemisa.").icon(BitmapDescriptorFactory.fromResource(R.drawable.artemisa)));

        // Marcador de El Coloso de Rodas
        LatLng Rodas = new LatLng(36.451257300124766, 28.226557713261656);
        mMap.addMarker(new MarkerOptions().position(Rodas).title("El Coloso de Rodas").snippet("Permaneció en pie durante menos de 60 años.").icon(BitmapDescriptorFactory.fromResource(R.drawable.coloso)));

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
package com.example.am;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

    public class ActivityLista extends AppCompatActivity {
    ListView listrest;
    List<Restaurante>lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listrest=findViewById(R.id.lista);
        CustomAdapter adapter=new CustomAdapter(this,GetData());
        listrest.setAdapter(adapter);
        listrest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Restaurante restaurante= lst.get(i);
                Intent openrest = new Intent(ActivityLista.this,RestauranteActivity.class)
                        .putExtra("titulo",restaurante.titulo)
                        .putExtra("foto",restaurante.fotorest)
                        .putExtra("ubicacion",restaurante.ubica)
                        .putExtra("descripcion",restaurante.descrip)
                        .putExtra("LongLat",restaurante.LongLat);
                startActivity(openrest);
                Toast.makeText(getBaseContext(),restaurante.titulo,Toast.LENGTH_SHORT).show();
            }
        });
    }

        private List<Restaurante> GetData() {
        lst= new ArrayList<>();
        lst.add(new Restaurante(1,R.drawable.chombaicon,"La Chomba Restaurant y Picanteria","Restaureante tradicional cusqueño","Prolongacion Av. de la Cultura","-13.5437176743694, -71.88790134524244"));
        lst.add(new Restaurante(2,R.drawable.chicha,"Chicha por Gaston Acurio","Restaureante del chef Gaston Acurio","Plaza Regocijo, Cusco 05184","-13.5437176743694, -71.88790134524244"));
        lst.add(new Restaurante(3,R.drawable.cusquenita,"Cusqueñísima Picantería","Restaureante tradicional cusqueño","Avenida Alfredo Yepez Miranda Urb. Magisterio, segunda etapa, C-8, Cusco","-13.5437176743694, -71.88790134524244"));
        lst.add(new Restaurante(4,R.drawable.machitas,"Las Machitas","Restaureante y Cevicheria","Avenida Perú F-9 Urb. Progreso Wanchaq, Cusco","-13.5437176743694, -71.88790134524244"));
        lst.add(new Restaurante(5,R.drawable.tradiciones,"Tradiciones Cusqueñas","Restaureante tradicional cusqueño","Prolongacion Av. de la Cultura","-13.5437176743694, -71.88790134524244"));
        lst.add(new Restaurante(6,R.drawable.tunupa,"Restaurante Tunupa","Restaureante tradicional cusqueño","Portal de Confituria 233","-13.5437176743694, -71.88790134524244"));
        return lst;
        }
    }
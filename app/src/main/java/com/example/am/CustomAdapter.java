package com.example.am;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<Restaurante>lst;

    public CustomAdapter(Context context,List<Restaurante> lst) {
        this.context = context;
        this.lst=lst;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView fotos;
        TextView ubicacion,titulos;
        Restaurante rest=lst.get(i);

        if (view==null)
            view= LayoutInflater.from(context).inflate(R.layout.item,null);

        titulos=view.findViewById(R.id.txtTitulo);
        fotos=view.findViewById(R.id.imgdelrest);
        ubicacion= view.findViewById(R.id.txtContenido);

        titulos.setText(rest.titulo);
        fotos.setImageResource(rest.fotorest);
        ubicacion.setText(rest.descrip);
        return view;
    }
}

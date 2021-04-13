package com.dat.agendamedica.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dat.agendamedica.Entidades.DetallesCita;
import com.dat.agendamedica.R;
import com.dat.agendamedica.detallesCita;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorDetallesCitas extends RecyclerView.Adapter<AdaptadorDetallesCitas.CViewHolder> {
    private ArrayList<DetallesCita> citas;
    public Context p2;
    public class CViewHolder extends RecyclerView.ViewHolder{
        public TextView texto;
        public TextView texto2;
        public TextView texto3;
        public TextView texto4;
        public ImageView imagen;
        public LinearLayout lineal;
        public CardView carta;

        public CViewHolder(View v) {
            super(v);
            texto=(TextView)v.findViewById(R.id.textonombrecita);
            texto2=(TextView)v.findViewById(R.id.textohoracita);
            texto3=(TextView)v.findViewById(R.id.textodescripcions);
            texto4=(TextView)v.findViewById(R.id.textodescripcions);
            imagen=(ImageView)v.findViewById(R.id.imagencitacarta);
            lineal=(LinearLayout)v.findViewById(R.id.linearL);
            carta=(CardView)v.findViewById(R.id.cardL);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v2) {
                    if(v2.isSelected()){
                        v2.setBackgroundColor(Color.WHITE);
                        v2.setSelected(false);
                    }else {
                        v2.setBackgroundColor(Color.GRAY);
                        v2.setSelected(true);
                        int s=getAdapterPosition();
                        Intent y=new Intent(p2, detallesCita.class);
                        y.putExtra("id",getAdapterPosition());
                        ContextCompat.startActivity(p2,y,null);
                    }
                }
            });
        }
    }
    public AdaptadorDetallesCitas(ArrayList<DetallesCita> v, Context g)
    {
        p2=g;
        citas=v;
    }

    @Override
    public CViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.vistatarjetas,parent,false);

        //
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.vistatarjetas,parent,false);
        CViewHolder vh=new CViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CViewHolder holder, int position) {
        try {
            holder.texto.setText(citas.get(position).getNombreCita());
            holder.texto2.setText(citas.get(position).getHoy());
            holder.texto4.setText(citas.get(position).getDetalles());
        }catch(Exception e){

        }

    }

    @Override
    public int getItemCount() {
        return citas.size();
    }
}

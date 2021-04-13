package com.dat.agendamedica.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dat.agendamedica.CrearCita;
import com.dat.agendamedica.Entidades.Cita;
import com.dat.agendamedica.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorCitas extends RecyclerView.Adapter<AdaptadorCitas.CitasViewHolder> {
    public ArrayList<Cita> citas;
    public Context cc;
    private int seleccion=-1;
    public class CitasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView texto;
        public TextView texto2;
        public TextView texto3;
        public ImageView imagen;
        public LinearLayout lineal;
        public CardView carta;
        public CitasViewHolder(View itemView) {
            super(itemView);
            texto=(TextView)itemView.findViewById(R.id.textonombrecita2);
            texto2=(TextView)itemView.findViewById(R.id.textonobremedico);
            texto3=(TextView)itemView.findViewById(R.id.textoestado);
            lineal=(LinearLayout)itemView.findViewById(R.id.linearL2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(v.isSelected()){
                        v.setBackgroundColor(Color.WHITE);
                        v.setSelected(false);
                    }else {
                        v.setBackgroundColor(Color.GRAY);
                        v.setSelected(true);
                        int s=getAdapterPosition();
                        Intent y=new Intent(cc, CrearCita.class);
                        y.putExtra("crearv","e");
                        y.putExtra("id",getAdapterPosition());
                        ContextCompat.startActivity(cc,y,null);
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            //

        }
    }
    public AdaptadorCitas(ArrayList<Cita> entrada, Context d){
        cc=d;
        citas=entrada;
    }
    @NonNull
    @Override
    public AdaptadorCitas.CitasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.vistatarjetas2,parent,false);
        AdaptadorCitas.CitasViewHolder vh=new AdaptadorCitas.CitasViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorCitas.CitasViewHolder holder, int position) {
        try{
            holder.texto.setText(citas.get(position).getNombre());
            holder.texto2.setText(citas.get(position).getNombreMedico());
            holder.texto3.setText(citas.get(position).getEstado());
            //

        }catch (Exception e){

        }
    }

    @Override
    public int getItemCount() {
        return citas.size();
    }



}

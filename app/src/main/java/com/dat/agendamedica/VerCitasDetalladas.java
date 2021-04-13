package com.dat.agendamedica;

import android.content.Intent;
import android.os.Bundle;

import com.dat.agendamedica.Adaptadores.AdaptadorCitas;
import com.dat.agendamedica.Adaptadores.AdaptadorDetallesCitas;
import com.dat.agendamedica.BD.BaseD;
import com.dat.agendamedica.Entidades.Cita;
import com.dat.agendamedica.Entidades.DetallesCita;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class VerCitasDetalladas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_citas_detalladas);
        ImageButton atras=findViewById(R.id.editarbtnatras);
        Button accion=findViewById(R.id.editarbotonaccion);
        RecyclerView lista=findViewById(R.id.listaeditar);
        lista.setHasFixedSize(true);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        lista.setLayoutManager(llm);
        BaseD b=new BaseD(this);
        b.iniciarBase();
        ArrayList<Cita> citas=new ArrayList<Cita>();
        ArrayList<Cita> citas2=new ArrayList<Cita>();
        ArrayList<DetallesCita> detallesCitas=new ArrayList<>();
        Intent t=getIntent();
        String ver=t.getStringExtra("ver");
        switch (ver){
            case "ec":
                citas=b.obtenerCitas();
                AdaptadorCitas acc=new AdaptadorCitas(citas,this);
                lista.setAdapter(acc);

                break;
            case "vdc":
                detallesCitas=b.obtenerTodosDetalles();
                for(DetallesCita ind: detallesCitas){
                    String temp=b.obtenerNombreCita(ind.getIdCita());
                    ind.setNombreCita(temp);}
                AdaptadorDetallesCitas adaptadorDetallesCitas=new AdaptadorDetallesCitas(detallesCitas,this);
                lista.setAdapter(adaptadorDetallesCitas);
                break;
            case "bdc":
                citas2=b.obtenerCitas();
                AdaptadorCitas acc2=new AdaptadorCitas(citas2,this);
                lista.setAdapter(acc2);
                break;
        }
        Intent volver=new Intent(this,MainActivity.class);
        atras.setOnClickListener(evt->{
            startActivity(volver);
        });
    }
}
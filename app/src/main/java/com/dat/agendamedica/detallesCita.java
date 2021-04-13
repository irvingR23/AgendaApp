package com.dat.agendamedica;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dat.agendamedica.BD.BaseD;
import com.dat.agendamedica.Entidades.DetallesCita;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class detallesCita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_cita);
        Button atras=findViewById(R.id.atrasbtndc);
        FloatingActionButton hecho=findViewById(R.id.hechobtndc);
        TextView fecha=findViewById(R.id.fechatextodc);
        TextView num=findViewById(R.id.numerotextodc);
        EditText detalles=findViewById(R.id.detallesespaciodc);
        Intent v=new Intent(this,MainActivity.class);
        Intent data=getIntent();
        atras.setOnClickListener(evt->{
            startActivity(v);
        });
        int id=data.getIntExtra("id",-1);
        BaseD b=new BaseD(this);
        b.iniciarBase();
        DetallesCita dc=new DetallesCita();
        System.out.println(id);
        dc=b.obtenerDetalleCita(id);
        //
        //1-8 2-15 3-22 4-29 5-36
        fecha.setText(String.valueOf(dc.getFecha()));
        detalles.setText(dc.getDetalles());
        DetallesCita dc2=new DetallesCita();
        hecho.setOnClickListener(evt->{
            dc2.setDetalles(detalles.getText().toString());
            b.actualizarDetallesCita(dc2,id+1);
            startActivity(v);
        });
    }
}
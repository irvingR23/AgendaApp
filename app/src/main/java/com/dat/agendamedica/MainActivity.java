package com.dat.agendamedica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.dat.agendamedica.Adaptadores.AdaptadorDetallesCitas;
import com.dat.agendamedica.BD.BaseD;
import com.dat.agendamedica.Entidades.Cita;
import com.dat.agendamedica.Entidades.DetallesCita;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private String crearv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView lista=findViewById(R.id.listaMain);
        Button editar=findViewById(R.id.editarbtn);
        Button ver=findViewById(R.id.vercitasbtn);
        Button borrar=findViewById(R.id.borrarbtnc);
        lista.setHasFixedSize(true);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        lista.setLayoutManager(llm);

        int anio= Calendar.getInstance().get(Calendar.YEAR);
        int mes=Calendar.getInstance().get(Calendar.MONTH);
        int diam=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        anio=anio*10000;
        mes=mes*100;
        int fecha=anio+mes+diam;
        BaseD b=new BaseD(this);
        b.iniciarBase();
        ArrayList<DetallesCita> ci=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dia = sdf.format(d);


        try {
            ci = b.obtenerTodosDetallesC(dia);
            for(DetallesCita ind: ci){
                String temp=b.obtenerNombreCita(ind.getIdCita());
                ind.setNombreCita(temp);

                //apartado de Horas
                switch (dia){
                    case "Monday":
                        ind.setHoy(b.obtenerLunes(ind.getIdCita()).getHora());
                        break;
                    case "Tuesday":
                        ind.setHoy(b.obtenerMartes(ind.getIdCita()).getHora());
                        break;
                    case "Wednesday":
                        ind.setHoy(b.obtenerMiercoles(ind.getIdCita()).getHora());
                        break;
                    case "Thursday":
                        ind.setHoy(b.obtenerJueves(ind.getIdCita()).getHora());
                        break;
                    case "Friday":
                        ind.setHoy(b.obtenerViernes(ind.getIdCita()).getHora());
                        break;
                    case "Saturday":
                        ind.setHoy(b.obtenerSabado(ind.getIdCita()).getHora());
                        break;
                    case "Sunday":
                        ind.setHoy(b.obtenerDomingo(ind.getIdCita()).getHora());
                        break;
                }
            }

            AdaptadorDetallesCitas ad = new AdaptadorDetallesCitas(ci,this                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               );
            lista.setAdapter(ad);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        Button crear=findViewById(R.id.bCrearCita);

        Intent uno=new Intent(this,CrearCita.class);
        crear.setOnClickListener(evt->{
            uno.putExtra("crearv","c");
            startActivity(uno);
        });

        Intent iedit=new Intent(this,VerCitasDetalladas.class);
        editar.setOnClickListener(evt->{
            iedit.putExtra("ver","ec");
            startActivity(iedit);
        });
        Intent  verin=new Intent(this,VerCitasDetalladas.class);
        ver.setOnClickListener(evt->{
            verin.putExtra("ver","vdc");
            startActivity(verin);
        });
        Intent borrarin=new Intent(this,VerCitasDetalladas.class);
        borrar.setOnClickListener(evt->{
            borrarin.putExtra("ver","bdc");
            startActivity(borrarin);
        });
    }
}
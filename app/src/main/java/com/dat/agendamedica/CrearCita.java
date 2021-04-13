package com.dat.agendamedica;

import android.content.Intent;
import android.os.Bundle;

import com.dat.agendamedica.BD.BaseD;
import com.dat.agendamedica.Entidades.Cita;
import com.dat.agendamedica.Entidades.DetallesCita;
import com.dat.agendamedica.Entidades.Domingo;
import com.dat.agendamedica.Entidades.FechaActual;
import com.dat.agendamedica.Entidades.Jueves;
import com.dat.agendamedica.Entidades.Lunes;
import com.dat.agendamedica.Entidades.Martes;
import com.dat.agendamedica.Entidades.Miercoles;
import com.dat.agendamedica.Entidades.Sabado;
import com.dat.agendamedica.Entidades.Viernes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CrearCita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cita2);

        Intent t=getIntent();
        String[] ya=new String[7];
        for(int i=0;i<7;i++){
            ya[i]="no";
        }
        String data=t.getStringExtra("crearv");
        Button nuevo=findViewById(R.id.bNuevo);
        EditText nombre=findViewById(R.id.nombrecrear);
        EditText descripcion=findViewById(R.id.descripcioncrear);
        EditText nombreM=findViewById(R.id.nombremcrear);
        CheckBox lunescb=findViewById(R.id.lunesCk);
        CheckBox martescb=findViewById(R.id.martesCk);
        CheckBox miercolescb=findViewById(R.id.miercolesCk);
        CheckBox juevescb=findViewById(R.id.juevesCk);
        CheckBox viernescb=findViewById(R.id.viernesCk);
        CheckBox sabadocb=findViewById(R.id.sabadoCk);
        CheckBox domingocb=findViewById(R.id.domingoCk);
        ToggleButton lunestb=findViewById(R.id.luneson);
        ToggleButton martestb=findViewById(R.id.marteson);
        ToggleButton miercolestb=findViewById(R.id.miercoleson);
        ToggleButton juevestb=findViewById(R.id.jueveson);
        ToggleButton viernestb=findViewById(R.id.vierneson);
        ToggleButton sabadotb=findViewById(R.id.sabadoon);
        ToggleButton domingotb=findViewById(R.id.domingoon);
        EditText lunese=findViewById(R.id.lunescrear);
        EditText martese=findViewById(R.id.martescrear);
        EditText miercolese=findViewById(R.id.miercolescrear);
        EditText juevese=findViewById(R.id.juevescrear);
        EditText viernese=findViewById(R.id.viernescrear);
        EditText sabadoe=findViewById(R.id.sabadocrear);
        EditText domingoe=findViewById(R.id.domingocrear);
        ImageButton fab = findViewById(R.id.volvercrear);
        int anio= Calendar.getInstance().get(Calendar.YEAR);
        int mes=Calendar.getInstance().get(Calendar.MONTH);
        int dia=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        Intent yyy=new Intent(this,MainActivity.class);
        anio=anio*10000;
        mes=mes*100;
        // 2020*10000=2020-12-12
        //1*100=100-12*100=1200
        int fecha=anio+mes+dia;
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String diam = sdf.format(d);
        BaseD bd=new BaseD(this);
        bd.iniciarBase();
        try {
            String existe = bd.obtenerExisteFecha();
        }catch(Exception e){
            FechaActual f = new FechaActual();
            f.setActual(fecha);
            f.setExiste("si");
            bd.insertarFecha(f);
        }
        switch (data){
            case "c":
                fab.setOnClickListener(evt->{
                    Intent pika=new Intent(this,MainActivity.class);
                    startActivity(pika);
                });
                Cita c=new Cita();
                nuevo.setOnClickListener(evt->{
                    c.setNombre(nombre.getText().toString());
                    c.setDescripcion(descripcion.getText().toString());
                    c.setNombreMedico(nombreM.getText().toString());
                    c.setEstado("vigente");
                    bd.insertarCita(c);
                    int indice=bd.obtenerIdCita();
                    if(lunescb.isChecked()){
                        Lunes l=new Lunes();
                        l.setHora(lunese.getText().toString());
                        l.setIdCita(indice);
                        if(lunestb.isChecked()){
                            l.setHora(l.getHora()+" "+lunestb.getTextOn());
                        }else{
                            l.setHora(l.getHora()+" "+lunestb.getTextOff());
                        }
                        bd.insertarLunes(l);
                        for(int i=0;i<50;i=i+7) {
                            DetallesCita detallesCita = new DetallesCita();
                            detallesCita.setIdCita(indice);
                            detallesCita.setEstado("vigente");
                            detallesCita.setFecha("Monday");
                            bd.insertarDetallesCita2(detallesCita);
                        }
                    }

                    if(martescb.isChecked()){
                        Martes m=new Martes();
                        m.setHora(martese.getText().toString());
                        m.setIdCita(indice);
                        if(martestb.isChecked()){
                            m.setHora(m.getHora()+" "+martestb.getTextOn());
                        }else{
                            m.setHora(m.getHora()+" "+martestb.getTextOff());
                        }
                        bd.insertarMartes(m);
                        for(int i=0;i<50;i=i+7) {
                            DetallesCita detallesCita = new DetallesCita();
                            detallesCita.setIdCita(indice);
                            detallesCita.setEstado("vigente");
                            detallesCita.setFecha("Tuesday");
                            bd.insertarDetallesCita2(detallesCita);
                        }
                    }

                    if (miercolescb.isChecked()){
                        Miercoles mi=new Miercoles();
                        mi.setHora(miercolese.getText().toString());
                        mi.setIdCita(indice);
                        if(miercolestb.isChecked()){
                            mi.setHora(mi.getHora()+" "+miercolestb.getTextOn());
                        }else{
                            mi.setHora(mi.getHora()+" "+miercolestb.getTextOff());
                        }
                        bd.insertarMiercoles(mi);

                        for(int i=0;i<50;i=i+7) {
                            DetallesCita detallesCita = new DetallesCita();
                            detallesCita.setIdCita(indice);
                            detallesCita.setEstado("vigente");
                            detallesCita.setFecha("Wednesday");
                            bd.insertarDetallesCita2(detallesCita);
                        }
                    }

                    if(juevescb.isChecked()){
                        Jueves j=new Jueves();
                        j.setHora(juevese.getText().toString());
                        j.setIdCita(indice);
                        if(juevestb.isChecked()){
                            j.setHora(j.getHora()+" "+juevestb.getTextOn());
                        }else{
                            j.setHora(j.getHora()+" "+juevestb.getTextOff());
                        }
                        bd.insertarJueves(j);
                        for(int i=0;i<50;i=i+7) {
                            DetallesCita detallesCita = new DetallesCita();
                            detallesCita.setIdCita(indice);
                            detallesCita.setEstado("vigente");
                            detallesCita.setFecha("Thursday");
                            bd.insertarDetallesCita2(detallesCita);
                        }
                    }
                    if (viernescb.isChecked()){
                        Viernes v=new Viernes();
                        v.setHora(viernese.getText().toString());
                        v.setIdCita(indice);
                        if(viernestb.isChecked()){
                            v.setHora(v.getHora()+" "+viernestb.getTextOn());
                        }else{
                            v.setHora(v.getHora()+" "+viernestb.getTextOff());
                        }
                        bd.insertarViernes(v);
                        for(int i=0;i<50;i=i+7) {
                            DetallesCita detallesCita = new DetallesCita();
                            detallesCita.setIdCita(indice);
                            detallesCita.setEstado("vigente");
                            detallesCita.setFecha("Friday");
                            bd.insertarDetallesCita2(detallesCita);
                        }

                    }
                    if(sabadocb.isChecked()){
                        Sabado s=new Sabado();
                        s.setHora(sabadoe.getText().toString());
                        s.setIdCita(indice);
                        if(sabadotb.isChecked()){
                            s.setHora(s.getHora()+" "+sabadotb.getTextOn());
                        }else{
                            s.setHora(s.getHora()+" "+sabadotb.getTextOff());
                        }
                        bd.insertarSabado(s);
                        for(int i=0;i<50;i=i+7) {
                            DetallesCita detallesCita = new DetallesCita();
                            detallesCita.setIdCita(indice);
                            detallesCita.setEstado("vigente");
                            detallesCita.setFecha("Saturday");
                            bd.insertarDetallesCita2(detallesCita);
                        }
                    }
                    if(domingocb.isChecked()){
                        Domingo dos=new Domingo();
                        dos.setHora(domingoe.getText().toString());
                        dos.setIdCita(indice);
                        if(domingotb.isChecked()){
                            dos.setHora(dos.getHora()+" "+domingotb.getTextOn());
                        }else{
                            dos.setHora(dos.getHora()+" "+domingotb.getTextOff());
                        }
                        bd.insertarDomingo(dos);
                        for(int i=0;i<50;i=i+7) {
                            DetallesCita detallesCita = new DetallesCita();
                            detallesCita.setIdCita(indice);
                            detallesCita.setEstado("vigente");
                            detallesCita.setFecha("Sunday");
                            bd.insertarDetallesCita2(detallesCita);
                        }

                    }
                    Intent main=new Intent(this,MainActivity.class);
                    startActivity(main);
                });
                break;
            case "e":
                fab.setOnClickListener(evt->{
                    Intent pika=new Intent(this,VerCitasDetalladas.class);
                    pika.putExtra("ver","ec");
                    startActivity(pika);
                });
                Cita c2=new Cita();
                Intent temp=getIntent();
                int id=temp.getIntExtra("id",-1);

                c2=bd.obtenerCita(id+1);
                nuevo.setText("editar");
                nombre.setText(c2.getNombre());
                Toast tcc=Toast.makeText(this,String.valueOf(id)+c2.getNombre(),Toast.LENGTH_LONG);
                tcc.show();
                descripcion.setText(c2.getDescripcion());
                nombreM.setText(c2.getNombreMedico());
                //
                Lunes lc=bd.obtenerLunes(id+1);
                if(lc.getHora()!=null){
                    ya[0]="si";
                    String vt2=lc.getHora();
                    try {
                        if (vt2.contains("AM")) {
                            lunestb.setChecked(true);
                            vt2 = vt2.replace("AM", "");
                        } else if (vt2.contains("PM")) {
                            lunestb.setChecked(false);
                            vt2 = vt2.replace("PM", "");
                        }
                        lunese.setText(vt2);
                        lunescb.setChecked(true);
                    }catch(Exception e){

                    }
                }
                //
                //
                Martes mc=bd.obtenerMartes(id+1);
                if(mc.getHora()!=null){
                    ya[1]="si";
                    String vt3=mc.getHora();
                    try {
                        if (vt3.contains("AM")) {
                            martestb.setChecked(true);
                            vt3 = vt3.replace("AM", "");
                        } else if (vt3.contains("PM")) {
                            martestb.setChecked(false);
                            vt3 = vt3.replace("PM", "");
                        }
                        martese.setText(vt3);
                        martescb.setChecked(true);
                    }catch(Exception e){

                    }
                }
                //
                //
                Miercoles mic=bd.obtenerMiercoles(id+1);
                if(mic.getHora()!=null){
                    ya[2]="si";
                    String vt4=mic.getHora();
                    try {
                        if (vt4.contains("AM")) {
                            miercolestb.setChecked(true);
                            vt4 = vt4.replace("AM", "");
                        } else if (vt4.contains("PM")) {
                            miercolestb.setChecked(false);
                            vt4 = vt4.replace("PM", "");
                        }
                        miercolese.setText(vt4);
                        miercolescb.setChecked(true);
                    }catch(Exception e){

                    }
                }
                //
                //
                Jueves jc=bd.obtenerJueves(id+1);
                if(jc.getHora()!=null){
                    ya[3]="si";
                    String vt5=jc.getHora();
                    try {
                        if (vt5.contains("AM")) {
                            juevestb.setChecked(true);
                            vt5 = vt5.replace("AM", "");
                        } else if (vt5.contains("PM")) {
                            juevestb.setChecked(false);
                            vt5 = vt5.replace("PM", "");
                        }
                        juevese.setText(vt5);
                        juevescb.setChecked(true);
                    }catch(Exception e){

                    }
                }
                //
                //
                Viernes v=bd.obtenerViernes(id+1);
                if(v.getHora()!=null){
                    ya[4]="si";
                    String vt=v.getHora();
                    try {
                        if (vt.contains("AM")) {
                            viernestb.setChecked(true);
                            vt = vt.replace("AM", "");
                        } else if (vt.contains("PM")) {
                            viernestb.setChecked(false);
                            vt = vt.replace("PM", "");
                        }
                        viernese.setText(vt);
                        viernescb.setChecked(true);
                    }catch(Exception e){

                    }
                }
                //
                //
                Sabado sc=bd.obtenerSabado(id+1);
                if(sc.getHora()!=null){
                    ya[5]="si";
                    String vt6=v.getHora();
                    try {
                        if (vt6.contains("AM")) {
                            sabadotb.setChecked(true);
                            vt6 = vt6.replace("AM", "");
                        } else if (vt6.contains("PM")) {
                            sabadotb.setChecked(false);
                            vt6 = vt6.replace("PM", "");
                        }
                        sabadoe.setText(vt6);
                        sabadocb.setChecked(true);
                    }catch(Exception e){

                    }
                }
                //
                //
                Domingo dc=bd.obtenerDomingo(id+1);
                if(dc.getHora()!=null){
                    ya[6]="si";
                    String vt7=v.getHora();
                    try {
                        if (vt7.contains("AM")) {
                            domingotb.setChecked(true);
                            vt7 = vt7.replace("AM", "");
                        } else if (vt7.contains("PM")) {
                            domingotb.setChecked(false);
                            vt7 = vt7.replace("PM", "");
                        }
                        domingoe.setText(vt7);
                        domingocb.setChecked(true);
                    }catch(Exception e){

                    }
                }
                //
                Cita pack=new Cita();
                nuevo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pack.setNombre(nombre.getText().toString());
                        pack.setDescripcion(descripcion.getText().toString());
                        pack.setNombreMedico(nombreM.getText().toString());
                        bd.actualizarCita(pack,id+1);
                        if(lunescb.isChecked()){
                            Lunes l=new Lunes();
                            l.setHora(lunese.getText().toString());
                            l.setIdCita(id+1);
                            if(lunestb.isChecked()){
                                l.setHora(l.getHora()+" "+lunestb.getTextOn());
                            }else{
                                l.setHora(l.getHora()+" "+lunestb.getTextOff());
                            }
                            if(ya[0].equals("si")){
                                bd.actualizarLunes(l,id+1);
                            }else if(ya[0].equals("no")) {
                                bd.insertarLunes(l);
                                        for(int i=0;i<50;i=i+7) {
                                            DetallesCita detallesCita = new DetallesCita();
                                            detallesCita.setIdCita(id + 1);
                                            detallesCita.setEstado("vigente");
                                            detallesCita.setFecha("Monday");
                                            bd.insertarDetallesCita2(detallesCita);
                                        }

                            }
                        }
                        if(martescb.isChecked()){
                            Martes m=new Martes();
                            m.setHora(martese.getText().toString());
                            m.setIdCita(id+1);
                            if(martestb.isChecked()){
                                m.setHora(m.getHora()+" "+martestb.getTextOn());
                            }else{
                                m.setHora(m.getHora()+" "+martestb.getTextOff());
                            }
                            if(ya[1].equals("si")){
                                bd.actualizarMartes(m,id+1);
                            }else if(ya[1].equals("no")) {
                                bd.insertarMartes(m);
                                        for(int i=0;i<50;i=i+7) {
                                            DetallesCita detallesCita = new DetallesCita();
                                            detallesCita.setIdCita(id + 1);
                                            detallesCita.setEstado("vigente");
                                            detallesCita.setFecha("Tuesday");
                                            bd.insertarDetallesCita2(detallesCita);
                                        }

                                }
                            }
                        if (miercolescb.isChecked()){
                            Miercoles mi=new Miercoles();
                            mi.setHora(miercolese.getText().toString());
                            mi.setIdCita(id+1);
                            if(miercolestb.isChecked()){
                                mi.setHora(mi.getHora()+" "+miercolestb.getTextOn());
                            }else{
                                mi.setHora(mi.getHora()+" "+miercolestb.getTextOff());
                            }
                            if(ya[2].equals("si")){
                                bd.actualizarMiercoles(mi,id+1);
                            }else if(ya[2].equals("no")) {
                                bd.insertarMiercoles(mi);
                                        for(int i=0;i<50;i=i+7) {
                                            DetallesCita detallesCita = new DetallesCita();
                                            detallesCita.setIdCita(id + 1);
                                            detallesCita.setEstado("vigente");
                                            detallesCita.setFecha("Wednesday");
                                            bd.insertarDetallesCita2(detallesCita);
                                        }

                            }
                        }
                        if(juevescb.isChecked()){
                            Jueves j=new Jueves();
                            j.setHora(juevese.getText().toString());
                            j.setIdCita(id+1);
                            if(juevestb.isChecked()){
                                j.setHora(j.getHora()+" "+juevestb.getTextOn());
                            }else{
                                j.setHora(j.getHora()+" "+juevestb.getTextOff());
                            }
                            if(ya[3].equals("si")){
                                bd.actualizarJueves(j,id+1);
                            }else if(ya[3].equals("no")) {
                                bd.insertarJueves(j);
                                        for(int i=0;i<50;i=i+7) {
                                            DetallesCita detallesCita = new DetallesCita();
                                            detallesCita.setIdCita(id + 1);
                                            detallesCita.setEstado("vigente");
                                            detallesCita.setFecha("Thursday");
                                            bd.insertarDetallesCita2(detallesCita);
                                        }
                            }
                        }


                        if (viernescb.isChecked()){
                            Viernes vv=new Viernes();
                            vv.setHora(viernese.getText().toString());
                            vv.setIdCita(id+1);
                            if(viernestb.isChecked()){
                                vv.setHora(vv.getHora()+" "+viernestb.getTextOn());
                            }else{
                                vv.setHora(vv.getHora()+" "+viernestb.getTextOff());
                            }
                            if(ya[4].equals("si")){
                                bd.actualizarViernes(vv,id+1);
                            }else if(ya[4].equals("no")) {
                                bd.insertarViernes(vv);
                                        for(int i=0;i<50;i=i+7) {
                                            DetallesCita detallesCita = new DetallesCita();
                                            detallesCita.setIdCita(id + 1);
                                            detallesCita.setEstado("vigente");
                                            detallesCita.setFecha("Friday");
                                            bd.insertarDetallesCita2(detallesCita);
                                        }
                            }
                        }
                        if(sabadocb.isChecked()){
                            Sabado s=new Sabado();
                            s.setHora(sabadoe.getText().toString());
                            s.setIdCita(id+1);
                            if(sabadotb.isChecked()){
                                s.setHora(s.getHora()+" "+sabadotb.getTextOn());
                            }else{
                                s.setHora(s.getHora()+" "+sabadotb.getTextOff());
                            }
                            if(ya[5].equals("si")){
                                bd.actualizarSabado(s,id+1);
                            }else if(ya[5].equals("no")) {
                                bd.insertarSabado(s);
                                        for(int i=0;i<50;i=i+7) {
                                            DetallesCita detallesCita = new DetallesCita();
                                            detallesCita.setIdCita(id + 1);
                                            detallesCita.setEstado("vigente");
                                            detallesCita.setFecha("Saturday");
                                            bd.insertarDetallesCita2(detallesCita);
                                        }

                            }
                        }
                        if(domingocb.isChecked()){
                            Domingo dos=new Domingo();
                            dos.setHora(domingoe.getText().toString());
                            dos.setIdCita(id+1);
                            if(domingotb.isChecked()){
                                dos.setHora(dos.getHora()+" "+domingotb.getTextOn());
                            }else{
                                dos.setHora(dos.getHora()+" "+domingotb.getTextOff());
                            }
                            if(ya[6].equals("si")){
                                bd.actualizarDomingo(dos,id+1);
                            }else if(ya[6].equals("no")) {
                                bd.insertarDomingo(dos);
                                for(int i=0;i<50;i=i+7) {
                                    DetallesCita detallesCita = new DetallesCita();
                                    detallesCita.setIdCita(id + 1);
                                    detallesCita.setEstado("vigente");
                                    detallesCita.setFecha("Sunday");
                                    bd.insertarDetallesCita2(detallesCita);
                                }
                            }
                        }
                        startActivity(yyy);
                    }

                });

                break;
        }


    }
}
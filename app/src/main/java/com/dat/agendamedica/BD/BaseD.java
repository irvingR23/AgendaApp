package com.dat.agendamedica.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.dat.agendamedica.Entidades.Cita;
import com.dat.agendamedica.Entidades.DetallesCita;
import com.dat.agendamedica.Entidades.Domingo;
import com.dat.agendamedica.Entidades.FechaActual;
import com.dat.agendamedica.Entidades.Jueves;
import com.dat.agendamedica.Entidades.Lunes;
import com.dat.agendamedica.Entidades.Martes;
import com.dat.agendamedica.Entidades.Medicina;
import com.dat.agendamedica.Entidades.Miercoles;
import com.dat.agendamedica.Entidades.Sabado;
import com.dat.agendamedica.Entidades.Viernes;

import java.util.ArrayList;

public class BaseD {
    private Context c;

    public final class ContratoAgenda{
        private ContratoAgenda(){}
        public class EntradaCita implements BaseColumns{
            public static final String nombreTabla="Cita";
            public static final String columna1="id";
            public static final String columna2="nombre";
            public static final String columna3="descripcion";
            public static final String columna4="nombreMedico";
            public static final String columna5="fotoMedico";
            public static final String columna6="estado";
        }
        public class EntradaMedicina implements BaseColumns{
            public static final String nombreTabla="Medicina";
            public static final String columna1="id";
            public static final String columna2="nombre";
            public static final String columna3="idDetallesCita";
        }
        public class EntradaDetallesCita implements BaseColumns{
            public static final String nombreTabla="DetallesCita";
            public static final String columna1="id";
            public static final String columna2="numeroCita";
            public static final String columna3="detalles";
            public static final String columna4="idCita";
            /**public static final String columna5="lunes";
            public static final String columna6="martes";
            public static final String columna7="miercoles";
            public static final String columna8="jueves";
            public static final String columna9="viernes";
            public static final String columna10="sabado";
            public static final String columna11="domingo";*/
            public static final String columna12="estado";
            public static final String columna13="fecha";
        }
        public class EntradaLunes implements BaseColumns{
            public static final String nombreTabla="CitaLunes";
            public static final String columna1="id";
            public static final String columna2="hora";
            public static final String columna3="idCita";
        }
        public class EntradaMartes implements BaseColumns{
            public static final String nombreTabla="CitaMartes";
            public static final String columna1="id";
            public static final String columna2="hora";
            public static final String columna3="idCita";
        }
        public class EntradaMiercoles implements BaseColumns{
            public static final String nombreTabla="CitaMiercoles";
            public static final String columna1="id";
            public static final String columna2="hora";
            public static final String columna3="idCita";
        }
        public class EntradaJueves implements BaseColumns{
            public static final String nombreTabla="CitaJueves";
            public static final String columna1="id";
            public static final String columna2="hora";
            public static final String columna3="idCita";
        }
        public class EntradaViernes implements BaseColumns{
            public static final String nombreTabla="CitaViernes";
            public static final String columna1="id";
            public static final String columna2="hora";
            public static final String columna3="idCita";
        }
        public class EntradaSabado implements BaseColumns{
            public static final String nombreTabla="CitaSabado";
            public static final String columna1="id";
            public static final String columna2="hora";
            public static final String columna3="idCita";
        }
        public class EntradaDomingo implements BaseColumns{
            public static final String nombreTabla="CitaDomingo";
            public static final String columna1="id";
            public static final String columna2="hora";
            public static final String columna3="idCita";
        }
        public class EntradaFechaActual implements BaseColumns{
            public static final String nombreTabla="FechaActual";
            public static final String columna1="id";
            public static final String columna2="actual";
            public static final String columna3="existe";
        }

        public class obten{
            public static final String C1="create table "+
                    EntradaCita.nombreTabla + " ("+
                    EntradaCita.columna1 + " INTEGER PRIMARY KEY, "+
                    EntradaCita.columna2 + " TEXT, "+
                    EntradaCita.columna3 + " TEXT, "+
                    EntradaCita.columna4 + " TEXT, "+
                    EntradaCita.columna5 + " BLOB, "+
                    EntradaCita.columna6 + " TEXT)";

            public static final String BorrarEntidadSQL1="DROP TABLE "+
                    "IF EXISTS "+ EntradaCita.nombreTabla;

            public static final String C2="create table "+
                    EntradaMedicina.nombreTabla + " ("+
                    EntradaMedicina.columna1+ " INTEGER PRIMARY KEY, "+
                    EntradaMedicina.columna2+ " TEXT, "+
                    EntradaMedicina.columna3+ " INTEGER)";

            public static  final String BorrarEntidadSQL2="DROP TABLE "+
                    "IF EXISTS "+ EntradaMedicina.nombreTabla;

            public static final String C3="create table "+
                    EntradaDetallesCita.nombreTabla+ " ("+
                    EntradaDetallesCita.columna1+ " INTEGER PRIMARY KEY, "+
                    EntradaDetallesCita.columna2+ " INTEGER, "+
                    EntradaDetallesCita.columna3+ " TEXT, "+
                    EntradaDetallesCita.columna4+ " INTEGER, "+
                    /**EntradaDetallesCita.columna5+ " TEXT, "+
                    EntradaDetallesCita.columna6+ " TEXT, "+
                    EntradaDetallesCita.columna7+ " TEXT, "+
                    EntradaDetallesCita.columna8+ " TEXT, "+
                    EntradaDetallesCita.columna9+ " TEXT, "+
                    EntradaDetallesCita.columna10+ " TEXT, "+
                    EntradaDetallesCita.columna11+ " TEXT, "+*/
                    EntradaDetallesCita.columna12+ " TEXT, "+
                    EntradaDetallesCita.columna13+ " INTEGER)";

            public static final String BorrarEntidadSQL3="DROP TABLE "+
                    "IF EXISTS " + EntradaDetallesCita.nombreTabla;

            public static final String C4="create table "+
                    EntradaLunes.nombreTabla+ " ("+
                    EntradaLunes.columna1+ " INTEGER PRIMARY KEY, "+
                    EntradaLunes.columna2+ " TEXT, "+
                    EntradaLunes.columna3+ " INTEGER)";

            public static final String BorrarEntidadSQL4="DROP TABLE "+
                    "IF EXISTS "+ EntradaLunes.nombreTabla;

            public static final String C5="create table "+
                    EntradaMartes.nombreTabla+ " ("+
                    EntradaMartes.columna1+ " INTEGER PRIMARY KEY, "+
                    EntradaMartes.columna2+ " TEXT, "+
                    EntradaMartes.columna3+ " INTEGER)";

            public static final String BorrarEntidadSQL5="DROP TABLE "+
                    "IF EXISTS "+ EntradaMartes.nombreTabla;

            public static final String C6="create table "+
                    EntradaMiercoles.nombreTabla+ " ("+
                    EntradaMiercoles.columna1+ " INTEGER PRIMARY KEY, "+
                    EntradaMiercoles.columna2+ " TEXT, "+
                    EntradaMiercoles.columna3+ " INTEGER)";

            public static final String BorrarEntidadSQL6="DROP TABLE "+
                    "IF EXISTS "+ EntradaMiercoles.nombreTabla;

            public static final String C7="create table "+
                    EntradaJueves.nombreTabla+ " ("+
                    EntradaJueves.columna1+ " INTEGER PRIMARY KEY, "+
                    EntradaJueves.columna2+ " TEXT, "+
                    EntradaJueves.columna3+ " INTEGER)";

            public static final String BorrarEntidadSQL7="DROP TABLE "+
                    "IF EXISTS "+ EntradaJueves.nombreTabla;

            public static final String C8="create table "+
                    EntradaViernes.nombreTabla+ " ("+
                    EntradaViernes.columna1+ " INTEGER PRIMARY KEY, "+
                    EntradaViernes.columna2+ " TEXT, "+
                    EntradaViernes.columna3+ " INTEGER)";

            public static final String BorrarEntidadSQL8="DROP TABLE "+
                    "IF EXISTS "+ EntradaViernes.nombreTabla;

            public static final String C9="create table "+
                    EntradaSabado.nombreTabla+ " ("+
                    EntradaSabado.columna1+ " INTEGER PRIMARY KEY, "+
                    EntradaSabado.columna2+ " TEXT, "+
                    EntradaSabado.columna3+ " INTEGER)";

            public static final String BorrarEntidadSQL9="DROP TABLE "+
                    "IF EXISTS "+ EntradaSabado.nombreTabla;

            public static final String C10="create table "+
                    EntradaDomingo.nombreTabla+ " ("+
                    EntradaDomingo.columna1+ " INTEGER PRIMARY KEY, "+
                    EntradaDomingo.columna2+ " TEXT, "+
                    EntradaDomingo.columna3+ " INTEGER)";

            public static final String BorrarEntidadSQL10="DROP TABLE "+
                    "IF EXISTS "+ EntradaDomingo.nombreTabla;

            public static final String C11="create table "+
                    EntradaFechaActual.nombreTabla+ " ("+
                    EntradaFechaActual.columna1+ " INTEGER PRIMARY KEY, "+
                    EntradaFechaActual.columna2+ " INTEGER, "+
                    EntradaFechaActual.columna3+ " TEXT)";

        }
    }
    public class AgendaDbHelper extends SQLiteOpenHelper{
        public static final int versionBaseDatos=1;
        public static final String nombreBaseDatos="AgendaMedica.db";


        public AgendaDbHelper(Context context){
            super(context,nombreBaseDatos,null,versionBaseDatos);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(ContratoAgenda.obten.C1);
            db.execSQL(ContratoAgenda.obten.C3);
            db.execSQL(ContratoAgenda.obten.C2);
            db.execSQL(ContratoAgenda.obten.C4);
            db.execSQL(ContratoAgenda.obten.C5);
            db.execSQL(ContratoAgenda.obten.C6);
            db.execSQL(ContratoAgenda.obten.C7);
            db.execSQL(ContratoAgenda.obten.C8);
            db.execSQL(ContratoAgenda.obten.C9);
            db.execSQL(ContratoAgenda.obten.C10);
            db.execSQL(ContratoAgenda.obten.C11);
        }
        public void onUpgrade(SQLiteDatabase db,int oldV,int newV){
            //
        }
        public void onDowngrade(SQLiteDatabase db,int oldV,int newV){
            //
        }
    }

    public  BaseD(Context d){
        this.c=d;
    }
    private AgendaDbHelper helper;
    public void iniciarBase(){
        helper=new AgendaDbHelper(c);
    }
    public long insertarCita(Cita datos){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaCita.columna2,datos.getNombre());
        valores.put(ContratoAgenda.EntradaCita.columna3,datos.getDescripcion());
        valores.put(ContratoAgenda.EntradaCita.columna4,datos.getNombreMedico());
        //valores.put(ContratoAgenda.EntradaCita.columna5,datos.getFotoMedico().toString());
        valores.put(ContratoAgenda.EntradaCita.columna6,datos.getEstado());
        long nuevaFila=bd.insert(ContratoAgenda.EntradaCita.nombreTabla,null,valores);
        return nuevaFila;
    }

    public long insertarMedicina(Medicina datos){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaMedicina.columna2,datos.getNombre());
        valores.put(ContratoAgenda.EntradaMedicina.columna3,datos.getIdDetallesCita());
        long nuevaFila=bd.insert(ContratoAgenda.EntradaMedicina.nombreTabla,null,valores);
        return nuevaFila;
    }

    public long insertarDetallesCita(DetallesCita datos){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaDetallesCita.columna2,datos.getNumeroCita());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna3,datos.getDetalles());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna4,datos.getIdCita());
        /**valores.put(ContratoAgenda.EntradaDetallesCita.columna5,datos.getLunes());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna6,datos.getMartes());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna7,datos.getMiercoles());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna8,datos.getJueves());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna9,datos.getViernes());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna10,datos.getSabado());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna11,datos.getDomingo());**/
        valores.put(ContratoAgenda.EntradaDetallesCita.columna12,datos.getEstado());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna13,datos.getFecha());
        long nuevaFila=bd.insert(ContratoAgenda.EntradaDetallesCita.nombreTabla,null,valores);
        return nuevaFila;
    }
    public long insertarDetallesCita2(DetallesCita datos){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaDetallesCita.columna4,datos.getIdCita());
        /**valores.put(ContratoAgenda.EntradaDetallesCita.columna5,datos.getLunes());
         valores.put(ContratoAgenda.EntradaDetallesCita.columna6,datos.getMartes());
         valores.put(ContratoAgenda.EntradaDetallesCita.columna7,datos.getMiercoles());
         valores.put(ContratoAgenda.EntradaDetallesCita.columna8,datos.getJueves());
         valores.put(ContratoAgenda.EntradaDetallesCita.columna9,datos.getViernes());
         valores.put(ContratoAgenda.EntradaDetallesCita.columna10,datos.getSabado());
         valores.put(ContratoAgenda.EntradaDetallesCita.columna11,datos.getDomingo());**/
        valores.put(ContratoAgenda.EntradaDetallesCita.columna12,datos.getEstado());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna13,datos.getFecha());
        long nuevaFila=bd.insert(ContratoAgenda.EntradaDetallesCita.nombreTabla,null,valores);
        return nuevaFila;
    }

    public long insertarLunes(Lunes datos){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaLunes.columna2,datos.getHora());
        valores.put(ContratoAgenda.EntradaLunes.columna3,datos.getIdCita());
        long nuevaFila=bd.insert(ContratoAgenda.EntradaLunes.nombreTabla,null,valores);
        return nuevaFila;
    }

    public long insertarMartes(Martes datos){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaMartes.columna2,datos.getHora());
        valores.put(ContratoAgenda.EntradaMartes.columna3,datos.getIdCita());
        long nuevaFila=bd.insert(ContratoAgenda.EntradaMartes.nombreTabla,null,valores);
        return nuevaFila;
    }

    public long insertarMiercoles(Miercoles datos){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaMiercoles.columna2,datos.getHora());
        valores.put(ContratoAgenda.EntradaMiercoles.columna3,datos.getIdCita());
        long nuevaFila=bd.insert(ContratoAgenda.EntradaMiercoles.nombreTabla,null,valores);
        return nuevaFila;
    }

    public long insertarJueves(Jueves datos){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaJueves.columna2,datos.getHora());
        valores.put(ContratoAgenda.EntradaJueves.columna3,datos.getIdCita());
        long nuevaFila=bd.insert(ContratoAgenda.EntradaJueves.nombreTabla,null,valores);
        return nuevaFila;
    }

    public long insertarViernes(Viernes datos){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaViernes.columna2,datos.getHora());
        valores.put(ContratoAgenda.EntradaViernes.columna3,datos.getIdCita());
        long nuevaFila=bd.insert(ContratoAgenda.EntradaViernes.nombreTabla,null,valores);
        return nuevaFila;
    }

    public long insertarSabado(Sabado datos){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaSabado.columna2,datos.getHora());
        valores.put(ContratoAgenda.EntradaSabado.columna3,datos.getIdCita());
        long nuevaFila=bd.insert(ContratoAgenda.EntradaSabado.nombreTabla,null,valores);
        return nuevaFila;
    }

    public long insertarDomingo(Domingo datos){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaDomingo.columna2,datos.getHora());
        valores.put(ContratoAgenda.EntradaDomingo.columna3,datos.getIdCita());
        long nuevaFila=bd.insert(ContratoAgenda.EntradaDomingo.nombreTabla,null,valores);
        return nuevaFila;
    }

    public long insertarFecha(FechaActual fecha){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaFechaActual.columna2,fecha.getActual());
        valores.put(ContratoAgenda.EntradaFechaActual.columna3,fecha.getExiste());
        long nuevaFila=bd.insert(ContratoAgenda.EntradaFechaActual.nombreTabla,null,valores);
        return nuevaFila;
    }

    public ArrayList<Cita> obtenerCitas(){
        SQLiteDatabase bd=helper.getReadableDatabase();
        ArrayList<Cita> citas=new ArrayList<>();
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaCita.nombreTabla,null);
        cursor.moveToFirst();
        while(cursor.isAfterLast()==false){
            Cita temp=new Cita();
            temp.setId(cursor.getInt(cursor.getColumnIndex(ContratoAgenda.EntradaCita.columna1)));
            temp.setNombre(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaCita.columna2)));
            temp.setDescripcion(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaCita.columna3)));
            temp.setNombreMedico(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaCita.columna4)));
            ////Entrada pendiente de foto
            temp.setEstado(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaCita.columna6)));
            citas.add(temp);
            cursor.moveToNext();
        }
        return citas;
    }

    public Cita obtenerCita(int id){
        SQLiteDatabase bd=helper.getReadableDatabase();
        Cita cita=new Cita();
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaCita.nombreTabla+ " where id="+id,null);
        cursor.moveToFirst();
        while(cursor.isAfterLast()==false){
            Cita temp=new Cita();
            temp.setId(cursor.getInt(cursor.getColumnIndex(ContratoAgenda.EntradaCita.columna1)));
            temp.setNombre(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaCita.columna2)));
            temp.setDescripcion(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaCita.columna3)));
            temp.setNombreMedico(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaCita.columna4)));
            ////Entrada pendiente de foto
            temp.setEstado(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaCita.columna6)));
            cita=temp;
            cursor.moveToNext();
        }
        return cita;
    }

    public ArrayList<Medicina> obtenerMedicinas(){
        SQLiteDatabase bd=helper.getReadableDatabase();
        ArrayList<Medicina> medicinas=new ArrayList<>();
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaMedicina.nombreTabla,null);
        cursor.moveToFirst();
        while(cursor.isAfterLast()==false){
            Medicina temp=new Medicina();
            temp.setId(cursor.getInt(cursor.getColumnIndex(ContratoAgenda.EntradaMedicina.columna1)));
            temp.setNombre(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaMedicina.columna2)));
            temp.setIdDetallesCita(cursor.getInt(cursor.getColumnIndex(ContratoAgenda.EntradaMedicina.columna3)));
            medicinas.add(temp);
            cursor.moveToNext();
        }
        return medicinas;
    }

    public ArrayList<Medicina> obtenerMedicinasDetalles(int idc){
        SQLiteDatabase bd=helper.getReadableDatabase();
        ArrayList<Medicina> medicinas=new ArrayList<>();
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaMedicina.nombreTabla+ " where idDetallesCita="+idc,null);
        cursor.moveToFirst();
        while(cursor.isAfterLast()==false){
            Medicina temp=new Medicina();
            temp.setId(cursor.getInt(cursor.getColumnIndex(ContratoAgenda.EntradaMedicina.columna1)));
            temp.setNombre(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaMedicina.columna2)));
            temp.setIdDetallesCita(cursor.getInt(cursor.getColumnIndex(ContratoAgenda.EntradaMedicina.columna3)));
            medicinas.add(temp);
            cursor.moveToNext();
        }
        return medicinas;
    }

    public ArrayList<DetallesCita> obtenerTodosDetalles(){
        SQLiteDatabase bd=helper.getReadableDatabase();
        ArrayList<DetallesCita> detallesCitas=new ArrayList<>();
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaDetallesCita.nombreTabla,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            DetallesCita temp=new DetallesCita();
            temp.setId(cursor.getInt(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna1)));
            temp.setNumeroCita(cursor.getInt(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna2)));
            temp.setDetalles(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna3)));
            /**temp.setLunes(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna5)));
            temp.setMartes(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna6)));
            temp.setMiercoles(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna7)));
            temp.setJueves(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna8)));
            temp.setViernes(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna9)));
            temp.setSabado(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna10)));
            temp.setDomingo(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna11)));*/
            temp.setFecha(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna13)));
            detallesCitas.add(temp);
            cursor.moveToNext();
        }
        return detallesCitas;
    }
    public ArrayList<DetallesCita> obtenerTodosDetallesC(String fecha){
        SQLiteDatabase bd=helper.getReadableDatabase();
        int im=0;
        int itu=0;
        int iw=0;
        int ithu=0;
        int ifr=0;
        int isa=0;
        int isu=0;
        ArrayList<DetallesCita> detallesCitas=new ArrayList<>();
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaDetallesCita.nombreTabla+ " where estado='vigente'",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            DetallesCita temp=new DetallesCita();
            temp.setId(cursor.getInt(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna1)));
            temp.setDetalles(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna3)));
            temp.setIdCita(cursor.getInt(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna4)));
            temp.setFecha(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna13)));
            switch(fecha){
                case "Monday":
                    if (temp.getFecha().equals("Monday")) {
                        im++;
                        String datl=" lunes numero:" + im;
                        temp.setDetalles(datl);
                        detallesCitas.add(temp);
                    }else{
                        if(temp.getFecha().equals("Tuesday")){
                            itu++;
                            String datl=" martes numero:" + itu;
                            temp.setDetalles(datl);
                            System.out.println(temp.getDetalles());
                            detallesCitas.add(temp);
                        }
                    }
                    break;
                case "Tuesday":
                    if (temp.getFecha().equals("Tuesday")) {
                        itu++;
                        String datl=" martes numero:" + itu;
                        temp.setDetalles(datl);
                        detallesCitas.add(temp);
                    }else{
                        if(temp.getFecha().equals("Wednesday")){
                            iw++;
                            String datl=" miercoles numero:" + iw;
                            temp.setDetalles(datl);
                            detallesCitas.add(temp);
                        }
                    }
                    break;
                case "Wednesday":
                    if (temp.getFecha().equals("Wednesday")) {
                        iw++;
                        String datl=" miercoles numero:" + iw;
                        temp.setDetalles(datl);
                        detallesCitas.add(temp);
                    }else{
                        if(temp.getFecha().equals("Thursday")){
                            ithu++;
                            String datl=" jueves numero:" + ithu;
                            temp.setDetalles(datl);
                            detallesCitas.add(temp);
                        }
                    }
                    break;
                case "Thursday":
                    if (temp.getFecha().equals("Thursday")) {
                        ithu++;
                        String datl=" jueves numero:" + ithu;
                        temp.setDetalles(datl);
                        detallesCitas.add(temp);
                    }else{
                        if(temp.getFecha().equals("Friday")){
                            ifr++;
                            String datl=" viernes numero:" + ifr;
                            temp.setDetalles(datl);
                            detallesCitas.add(temp);
                        }
                    }
                    break;
                case "Friday":
                    if (temp.getFecha().equals("Friday")) {
                        ifr++;
                        String datl= " viernes numero:" + ifr;
                        temp.setDetalles(datl);
                        detallesCitas.add(temp);
                    }else{
                        if(temp.getFecha().equals("Saturday")){
                            isa++;
                            String datl= " sabado numero:" + isa;
                            temp.setDetalles(datl);
                            detallesCitas.add(temp);
                        }
                    }
                    break;
                case "Saturday":
                    if (temp.getFecha().equals("Saturday")) {
                        isa++;
                        String datl=" sabado numero:" + isa;
                        temp.setDetalles(datl);
                        detallesCitas.add(temp);
                    }else{
                        if(temp.getFecha().equals("Sunday")){
                            isu++;
                            String datl=" domingo numero:" + isu;
                            temp.setDetalles(datl);
                            detallesCitas.add(temp);
                        }
                    }
                    break;
                case "Sunday":
                    if (temp.getFecha().equals("Sunday")) {
                        isu++;
                        String datl=" domingo numero:" + isu;
                        temp.setDetalles(datl);
                        detallesCitas.add(temp);
                    }else{
                        if(temp.getFecha().equals("Monday")){
                            im++;
                            String datl=" Lunes numero:" + im;
                            temp.setDetalles(datl);
                            detallesCitas.add(temp);
                        }
                    }
                    break;
            }
            System.out.println(temp.getId());
            cursor.moveToNext();
        }
        return detallesCitas;
    }

    public DetallesCita obtenerDetalleCita(int idc){
        SQLiteDatabase bd=helper.getReadableDatabase();
        DetallesCita detalles=new DetallesCita();
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaDetallesCita.nombreTabla+ " where id="+idc,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            DetallesCita temp=new DetallesCita();
            temp.setId(cursor.getInt(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna1)));
            temp.setFecha(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna13)));
            temp.setDetalles(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaDetallesCita.columna3)));
            detalles=temp;
            cursor.moveToNext();
        }
        return detalles;
    }

    public String obtenerNombreCita(int idc){
        SQLiteDatabase bd=helper.getReadableDatabase();
        String nombre="";
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaCita.nombreTabla+ " where id="+idc,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            nombre=cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaCita.columna2));
            cursor.moveToNext();
        }
        return nombre;
    }

    public Lunes obtenerLunes(int idc){
        SQLiteDatabase bd=helper.getReadableDatabase();
        Lunes lunes=new Lunes();
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaLunes.nombreTabla + " where idCita="+idc,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            Lunes temp=new Lunes();
            temp.setHora(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaLunes.columna2)));
            lunes=temp;
            cursor.moveToNext();
        }
        if(cursor.getCount()<1){
            return null;
        }else {
            return lunes;
        }
    }

    public Martes obtenerMartes(int idc){
        SQLiteDatabase bd=helper.getReadableDatabase();
        Martes martes=new Martes();
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaMartes.nombreTabla + " where idCita="+idc,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            Martes temp=new Martes();
            temp.setHora(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaMartes.columna2)));
            martes=temp;
            cursor.moveToNext();
        }
        if(cursor.getCount()<1){
            return null;
        }else {
            return martes;
        }
    }

    public Miercoles obtenerMiercoles(int idc){
        SQLiteDatabase bd=helper.getReadableDatabase();
        Miercoles miercoles=new Miercoles();
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaMiercoles.nombreTabla + " where idCita="+idc,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            Miercoles temp=new Miercoles();
            temp.setHora(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaMiercoles.columna2)));
            miercoles=temp;
            cursor.moveToNext();
        }
        if(cursor.getCount()<1){
            return null;
        }else {
            return miercoles;
        }
    }

    public Jueves obtenerJueves(int idc){
        SQLiteDatabase bd=helper.getReadableDatabase();
        Jueves jueves=new Jueves();
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaJueves.nombreTabla + " where idCita="+idc,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            Jueves temp=new Jueves();
            temp.setHora(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaJueves.columna2)));
            jueves=temp;
            cursor.moveToNext();
        }
        if(cursor.getCount()<1){
            return null;
        }else {
            return jueves;
        }
    }

    public Viernes obtenerViernes(int idc){
        SQLiteDatabase bd=helper.getReadableDatabase();
        Viernes viernes=new Viernes();
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaViernes.nombreTabla + " where idCita="+idc,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            Viernes temp=new Viernes();
            temp.setHora(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaViernes.columna2)));
            viernes=temp;
            cursor.moveToNext();
        }
        if(cursor.getCount()<1){
            return null;
        }else {
            return viernes;
        }
    }

    public Sabado obtenerSabado(int idc){
        SQLiteDatabase bd=helper.getReadableDatabase();
        Sabado sabado=new Sabado();
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaSabado.nombreTabla + " where idCita="+idc,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            Sabado temp=new Sabado();
            temp.setHora(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaSabado.columna2)));
            sabado=temp;
            cursor.moveToNext();
        }
        if(cursor.getCount()<1){
            return null;
        }else {
            return sabado;
        }
    }

    public Domingo obtenerDomingo(int idc){
        SQLiteDatabase bd=helper.getReadableDatabase();
        Domingo domingo=new Domingo();
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaDomingo.nombreTabla + " where idCita="+idc,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            Domingo temp=new Domingo();
            temp.setHora(cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaDomingo.columna2)));
            domingo=temp;
            cursor.moveToNext();
        }
        if(cursor.getCount()<1){
            return null;
        }else {
            return domingo;
        }
    }

    public String obtenerExisteFecha(){
        SQLiteDatabase bd=helper.getReadableDatabase();
        String existe="";
        Cursor cursor=bd.rawQuery("select "+ ContratoAgenda.EntradaFechaActual.columna3 +" from "+ ContratoAgenda.EntradaFechaActual.nombreTabla,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            existe=cursor.getString(cursor.getColumnIndex(ContratoAgenda.EntradaFechaActual.columna3));
            cursor.moveToNext();
        }
        return existe;
    }

    public FechaActual obtenerFecha(){
        SQLiteDatabase bd=helper.getReadableDatabase();
        FechaActual fecha=new FechaActual();
        Cursor cursor=bd.rawQuery("select * from "+ ContratoAgenda.EntradaFechaActual.nombreTabla,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            FechaActual temp=new FechaActual();
            temp.setId(cursor.getInt(cursor.getColumnIndex(ContratoAgenda.EntradaFechaActual.columna1)));
            temp.setActual(cursor.getInt(cursor.getColumnIndex(ContratoAgenda.EntradaFechaActual.columna2)));
            fecha=temp;
            cursor.moveToNext();
        }
        return fecha;
    }

    public int obtenerIdCita(){
        SQLiteDatabase bd=helper.getReadableDatabase();
        int id=0;
        Cursor cursor=bd.rawQuery("select id from "+ ContratoAgenda.EntradaCita.nombreTabla,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            id=cursor.getInt(cursor.getColumnIndex(ContratoAgenda.EntradaCita.columna1));
            cursor.moveToNext();
        }
        return id;
    }

    public long actualizarCita(Cita c,int cid){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaCita.columna2,c.getNombre());
        valores.put(ContratoAgenda.EntradaCita.columna3,c.getDescripcion());
        valores.put(ContratoAgenda.EntradaCita.columna4,c.getNombreMedico());
        //valores.put(ContratoAgenda.EntradaCita.columna5,c.getFotoMedico());
        valores.put(ContratoAgenda.EntradaCita.columna6,c.getEstado());
        String referencia="id="+cid;
        long resultado=bd.update(ContratoAgenda.EntradaCita.nombreTabla,valores,referencia,null);
        return resultado;
    }

    public long actualizarMedicina(Medicina m,int mid){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaMedicina.columna2,m.getNombre());
        String referencia="id="+mid;
        long resultado=bd.update(ContratoAgenda.EntradaMedicina.nombreTabla,valores,referencia,null);
        return resultado;
    }

    public long actualizarDetallesCita(DetallesCita d,int did){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaDetallesCita.columna3,d.getDetalles());
        /**valores.put(ContratoAgenda.EntradaDetallesCita.columna5,d.getLunes());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna6,d.getMartes());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna7,d.getMiercoles());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna8,d.getJueves());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna9,d.getViernes());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna10,d.getSabado());
        valores.put(ContratoAgenda.EntradaDetallesCita.columna11,d.getDomingo());*/
        String referencia="id="+did;
        long resultado=bd.update(ContratoAgenda.EntradaDetallesCita.nombreTabla,valores,referencia,null);
        return resultado;
    }
    public long actualizarDesactivarcita(int did){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaDetallesCita.columna12,"d");
        String referencia="id="+did;
        String[] args={String.valueOf(did)};
        long resultado=bd.update(ContratoAgenda.EntradaDetallesCita.nombreTabla,valores,referencia,args);
        return resultado;
    }

    public long actualizarLunes(Lunes l,int lid){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaLunes.columna2,l.getHora());
        String referencia="idCita="+lid;
        long resultado=bd.update(ContratoAgenda.EntradaLunes.nombreTabla,valores,referencia,null);
        return resultado;
    }

    public long actualizarMartes(Martes m,int mid){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaMartes.columna2,m.getHora());
        String referencia="idCita="+mid;
        long resultado=bd.update(ContratoAgenda.EntradaMartes.nombreTabla,valores,referencia,null);
        return resultado;
    }

    public long actualizarMiercoles(Miercoles mi,int miid){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaMiercoles.columna2,mi.getHora());
        String referencia="idCita="+miid;
        long resultado=bd.update(ContratoAgenda.EntradaMiercoles.nombreTabla,valores,referencia,null);
        return resultado;
    }

    public long actualizarJueves(Jueves j,int jid){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaJueves.columna2,j.getHora());
        String referencia="idCita="+jid;
        long resultado=bd.update(ContratoAgenda.EntradaJueves.nombreTabla,valores,referencia,null);
        return resultado;
    }

    public long actualizarViernes(Viernes v,int vid){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaViernes.columna2,v.getHora());
        String referencia="idCita="+vid;
        long resultado=bd.update(ContratoAgenda.EntradaViernes.nombreTabla,valores,referencia,null);
        return resultado;
    }

    public long actualizarSabado(Sabado s,int sid){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaSabado.columna2,s.getHora());
        String referencia="idCita="+sid;
        long resultado=bd.update(ContratoAgenda.EntradaSabado.nombreTabla,valores,referencia,null);
        return resultado;
    }

    public long actualizarDomingo(Domingo d,int did){
        SQLiteDatabase bd=helper.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put(ContratoAgenda.EntradaDomingo.columna2,d.getHora());
        String referencia="idCita="+did;
        long resultado=bd.update(ContratoAgenda.EntradaDomingo.nombreTabla,valores,referencia,null);
        return resultado;
    }
}

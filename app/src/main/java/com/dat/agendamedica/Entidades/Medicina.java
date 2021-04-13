package com.dat.agendamedica.Entidades;

public class Medicina {
    private int id=0;
    private String nombre;
    private int idDetallesCita=0;

    public Medicina() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDetallesCita() {
        return idDetallesCita;
    }

    public void setIdDetallesCita(int idDetallesCita) {
        this.idDetallesCita = idDetallesCita;
    }
}

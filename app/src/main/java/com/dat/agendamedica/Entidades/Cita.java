package com.dat.agendamedica.Entidades;

import android.media.Image;

public class Cita {
    private int id=0;
    private String nombre;
    private String descripcion;
    private String nombreMedico;
    private Image fotoMedico;
    private String estado;

    public Cita() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public Image getFotoMedico() {
        return fotoMedico;
    }

    public void setFotoMedico(Image fotoMedico) {
        this.fotoMedico = fotoMedico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

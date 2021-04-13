package com.dat.agendamedica.Entidades;

public class Jueves {
    private int id=0;
    private String hora;
    private int idCita=0;

    public Jueves() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }
}

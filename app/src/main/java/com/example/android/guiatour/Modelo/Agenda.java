package com.example.android.guiatour.Modelo;

public class Agenda {

    public String titulo;
    public String local;
    public String detalhes;
    public String dataInicio;
    public String uid;



    public Agenda(){}

    public Agenda(String titulo, String local, String detalhes, String dataInicio, String uid) {
        this.titulo = titulo;
        this.local = local;
        this.detalhes = detalhes;
        this.dataInicio = dataInicio;
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String data) {
        this.dataInicio = data;
    }

    @Override
    public String toString() {
        return titulo;
    }
}

package com.example.android.guiatour.Modelo;

import java.util.Date;

public class Comentarios{

    private String mensagem, user_id;
    private Date timestamp;

    public Comentarios(){}

    public Comentarios(String mensagem, String user_id, Date timestamp) {
        this.mensagem = mensagem;
        this.user_id = user_id;
        this.timestamp = timestamp;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.model;

/**
 *
 * @author vitor
 */
public class Presenca {

    private int id;
    private int idEvento;
    private int idParticipante;
    private String dataHoraCheckin;
    protected String token = "SenhaUltraSecreta";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getDataHoraCheckin() {
        return dataHoraCheckin;
    }

    public void setDataHoraCheckin(String dataHoraCheckin) {
        this.dataHoraCheckin = dataHoraCheckin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

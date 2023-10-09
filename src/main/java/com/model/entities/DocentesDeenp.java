package com.model.entities;

import java.util.ArrayList;
import java.util.List;

public class DocentesDeenp extends Docentes{
    private List<String> listArea;
    private int ramal;
    private String sala;

    public DocentesDeenp(){
    }

    public DocentesDeenp(String nome, String email, String area){
        super(nome, email);
        String[] arrayAreas = area.split("/");
        this.listArea = new ArrayList<>();
        for(String str : arrayAreas){
            str = str.trim();
            this.listArea.add(str);
        }
    }

    public DocentesDeenp(String nome, String email, String area, int ramal, String sala) {
        super(nome, email);
        this.ramal = ramal;
        this.sala = sala;
        this.listArea = new ArrayList<>();
        String[] arrayAreas = area.split("/");
        for(String str : arrayAreas){
            str = str.trim();
            this.listArea.add(str);
        }
    }

    public List<String> getlistArea() {
        return listArea;
    }

    public void setArea(List<String> listArea) {
        this.listArea = listArea;
    }

    public int getRamal() {
        return ramal;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + " | Áreas de pesquisa: " + getlistArea() 
        + " | Ramal: " + getRamal() + " | Sala: " + getSala() + " | Email: " + getEmail();
    }

}

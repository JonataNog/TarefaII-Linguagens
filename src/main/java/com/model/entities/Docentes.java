package com.model.entities;

import java.util.List;

public class Docentes {
    private String nome;
    private String email;
    private String sala;
    private String area;
    private int ramal;
    

    public Docentes(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Docentes(){
    }

    public Docentes(String nome, String email, String area){
        super();
        this.nome = nome;
        this.email = email;
        this.area = area;
    }

    public Docentes(String nome, String email, String sala, String area, int ramal) {
        super();
        this.nome = nome;
        this.email = email;
        this.sala = sala;
        this.area = area;
        this.ramal = ramal;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSala() {
        return sala;
    }

    public String getArea() {
        return area;
    }

    public int getRamal() {
        return ramal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Docentes other = (Docentes) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Docentes [nome=" + nome + ", email=" + email + ", sala=" + sala + ", area=" + area + ", ramal=" + ramal
                + "]";
    }

    
    
}

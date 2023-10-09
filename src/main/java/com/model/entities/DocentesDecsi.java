package com.model.entities;

public class DocentesDecsi extends Docentes{
    private String linhaDePesquisa;

    public DocentesDecsi(){
    }

    public DocentesDecsi(String nome, String email, String linhaDePesquisa) {
        super(nome, email);
        this.linhaDePesquisa = linhaDePesquisa;
    }

    public String getLinhaDePesquisa() {
        return linhaDePesquisa;
    }

    public void setLinhaDePesquisa(String linhaDePesquisa) {
        this.linhaDePesquisa = linhaDePesquisa;
    }

    @Override
    public String toString() {
        return "Nome " + getNome() + " | Email: " + getEmail() 
        + " | Linha de pesquisa: " + getLinhaDePesquisa();
    }

}

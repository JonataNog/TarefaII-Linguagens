package com.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.model.entities.Docentes;
import com.model.entities.DocentesDeenp;

public class Scraper {
    
    public List<Docentes> Scraping(String url, int opc){
        if(opc == 1){
            List<Docentes> docentes = getDataDecsi(url);
            return docentes;
            
        }else if(opc == 2){
            List<Docentes> docentes = getDataDeenp(url);
            return docentes;
        }
        return null;
    }

    private List<Docentes> getDataDecsi(String url){
        List<Docentes> listDocentes = new ArrayList<>();
        Queue<String> queueNomeDocentes = new LinkedList<>();
        Queue<String> queueEmailDocentes = new LinkedList<>();

        try{
            Document doc = Jsoup.connect(url).get();
            

            // Seleciona elementos h3 usando regex
            Elements nomeDocentes = doc.select("h3:matches(\\w.*)");

            // Seleciona elementos âncora com href começando com "mailto:" usando regex
            Elements emailDocentes = doc.select("a[href~=^mailto:]");

            for(Element element : nomeDocentes){
                String nome = element.text();
                queueNomeDocentes.offer(nome);
            }
            
            for(Element element : emailDocentes){
                String email = element.text();
                queueEmailDocentes.offer(email);
            }

            while(!queueNomeDocentes.isEmpty()){
                String nome = queueNomeDocentes.poll();
                String email = queueEmailDocentes.poll();
                Docentes docente = new Docentes(nome, email);
                listDocentes.add(docente);
            }
        }
        catch(IOException e){
            e.printStackTrace(System.out);
        }
        return listDocentes;
    } 

    private List<Docentes> getDataDeenp(String url){
        List<Docentes> listDocentes = new ArrayList<>();
        String nome = "";
        String area = "";
        int ramal = 0;
        String sala = "";
        String email = "";    

        try{
            
            Document doc = Jsoup.connect(url).get();
            Elements nomeDocentes = doc.select("td:matches(\\w.*)");

            int cont = 1;
            int contCarla = 1;
            for(Element element : nomeDocentes){
                String str = element.text();
                if(cont == 1){
                    nome = str;
                }else if(cont == 2){
                    area = str;
                }else if(cont == 3){
                    if(contCarla == 4){
                        email = str;
                        cont = 6;
                    }else{
                        ramal = Integer.parseInt(str);
                    }
                }else if(cont == 4){
                    sala = str;
                }else if(cont == 5){
                    email = str;
                }else{
                    if(contCarla != 4){
                        String strAux = str;
                        Docentes docente = new DocentesDeenp(nome, email, area, ramal, sala);
                        listDocentes.add(docente);
                        nome = strAux;
                        cont = 1;
                        contCarla++;
                    }else{
                        String strAux = str;
                        Docentes docente = new DocentesDeenp(nome, email, area);
                        listDocentes.add(docente);
                        nome = strAux;
                        cont = 1;
                        contCarla++;
                    }
                }
                cont++;    
            }

        }catch(IOException e){
            e.printStackTrace(System.out);
        }
        return listDocentes;

    }

}

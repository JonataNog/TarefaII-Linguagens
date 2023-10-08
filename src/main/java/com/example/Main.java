package com.example;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) {
        
        try {
            Document doc = Jsoup.connect("https://decsi.ufop.br/docentes").get();

            Elements nomeDocentes = doc.select("h3 class=\"title\">(.+?)<\/h3>");
            Elements emailDocentes = doc.select("a[href^=mailto:]");
            //Elements linhaPesquisa = doc.select("strong.r > a").attr("dddd");
 
            for(Element element : nomeDocentes){
                String nomeDocente = element.text();
                System.out.println("Nome do docente: " + nomeDocente);
            }

            for(Element element : emailDocentes){
                String emailDocente = element.text();
                System.out.println("Email do docente: " + emailDocente);
            }

            /*for(Element element : linhaPesquisa){
                String pesquisa = element.text();
                System.out.println("Linha de pesquisa: " + pesquisa);
            }*/
        } catch (IOException e) {
            
            e.printStackTrace();
        }


    }
}
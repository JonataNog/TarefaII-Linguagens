package com.application;

import java.text.ParseException;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        
        int opcSite = 0;
        Scraper scraper = new Scraper();

        while(opcSite != 3){
            try{
                opcSite = Integer.parseInt(JOptionPane.showInputDialog("Digite o número referente ao site desejado:"
                    + "\n1 - decsi.ufop.br/docentes" + "\n2 - deenp.ufop.br/corpo-docente" + "\n3 - Sair"));

                switch(opcSite){
                    case 1:
                        scraper.Scraping("https://decsi.ufop.br/docentes", opcSite);
                        break;

                    case 2:
                        scraper.Scraping("https://deenp.ufop.br/corpo-docente", opcSite);
                        break;

                    case 3:
                        System.exit(0);
                        break;
                    
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                        break;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Digite apenas valores númericos!");
            }
        }
    }
}

package com.application;

import java.util.List;

import javax.swing.JOptionPane;

import com.model.entities.Docentes;
import com.model.entities.DocentesDeenp;

public class Main {
    public static void main(String[] args) {
        
        int opcSite = 0;
        Scraper scraper = new Scraper();
        List<Docentes> listDocentes;

        while(opcSite != 3){
            try{
                opcSite = Integer.parseInt(JOptionPane.showInputDialog("Digite o número referente ao site desejado:"
                    + "\n1 - decsi.ufop.br/docentes" + "\n2 - deenp.ufop.br/corpo-docente" + "\n3 - Sair"));

                switch(opcSite){
                    case 1:
                        listDocentes = scraper.Scraping("https://decsi.ufop.br/docentes", opcSite);
                        SUB_MENU(listDocentes);
                        break;

                    case 2:
                        listDocentes = scraper.Scraping("https://deenp.ufop.br/corpo-docente", opcSite);
                        SUB_MENU(listDocentes);
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

    private static void SUB_MENU(List<Docentes> listDocentes) {
        int opc = 0;
        while(opc != 3){
            opc = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da opção:"
                + "\n1 - Mostrar todos os docentes" + "\n2 - Procurar docente pela área"
                + "\n3 - Voltar"));
            switch(opc){
                case 1:
                    ImprimirDocentes(listDocentes);
                    break;
                
                case 2:
                    ProcurarDocentes(listDocentes);
                    break;

                case 3:
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        }


    }

    private static void ProcurarDocentes(List<Docentes> listDocentes) {
        String areaPesquisada = JOptionPane.showInputDialog("Digite a área de pesquisa: ");
        StringBuilder list = new StringBuilder();
        for(Docentes docente : listDocentes){
            if(docente instanceof DocentesDeenp){
            List<String> listStr = ((DocentesDeenp) docente).getlistArea();
                for(String str : listStr){
                    if(str.equalsIgnoreCase(areaPesquisada)){
                        list.append(docente.getNome()).append("\n");
                    }
                }
            }
        }
        if(!list.isEmpty()){
                JOptionPane.showMessageDialog(null, list.toString(), areaPesquisada, JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Nenhum docente encontrado");
        }
    }

    private static void ImprimirDocentes(List<Docentes> listDocentes) {
        StringBuilder list = new StringBuilder("Todos os docentes:\n");
        for(Docentes docente : listDocentes){
            list.append(docente).append("\n");
        }

        JOptionPane.showMessageDialog(null, list.toString(), "Todos os docentes", JOptionPane.INFORMATION_MESSAGE);
    }
}

package org.example.atividadepratica.Q1Q2.Q1.service;



import org.example.atividadepratica.Q1Q2.Q1.exception.LampadaException;
import org.example.atividadepratica.Q1Q2.Q1.lampada.Lampada;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {

    public Lampada lampada= new Lampada();

    static Scanner scan = new Scanner(System.in);
    static final int QNT = 6;
    static Lampada[] lampadas = new Lampada[QNT];

    public void inicializar(){
        System.out.println("__________________________");
        for (int i = 0; i < 6; i++) {
            lampadas[i] = new Lampada();
            System.out.println("Lâmpada: " + (i + 1));
        }

        System.out.println("""
                __________________________
                TODAS AS LAMPADAS INICIALIZADAS""");
    }


    public void menu(){
        System.out.println("""
                *** ESCOLHA UMA OPÇÃO ***
                1- Ligar alguma das 6 (seis) lâmpadas, pela entrada de sua identificação (um inteiro entre 1 e 6);
                2- Desligar alguma das 6 (seis) lâmpadas, pela entrada de sua identificação (um inteiro entre 1 e 6);
                3- Listar identificadores das lâmpadas que se encontram ligadas;
                4- Listar percentual de lâmpadas desligadas;
                5- Encerrar aplicação.""");

    }

    public void ligarAlgumaLampada(){
        System.out.println("Escolha uma lampada para ligar entre 1 e 6:");
        int escolha = scan.nextInt();

        // lampadas inicializadas -> 0 1 2 3 4 5
        // escolha 1->ligada 0 | escolha 2->ligada 1 | escolha 3->ligada 2 |escolha 4->ligada 3
        // escolha 5->ligada 4 | escolha 6->ligada 5

        if(!lampadas[escolha-1].isLigada()){
            lampadas[escolha-1].ligar();
            System.out.println("Lampada [" + escolha + "] ligada com sucesso!");
        }else{
            throw  new LampadaException("Lampada já esta ligada");
        }
    }

    public void desligarAlgumaLampada() {
        System.out.println("Escolha uma lampada para desligar entre 1 e 6");
        int escolha = scan.nextInt();

        // lampadas inicializadas -> 0 1 2 3 4 5
        // escolha 1-> desligada 0 | escolha 2-> desligada 1 | escolha 3-> desligada 2
        // escolha 4-> desligada 3 | escolha 5-> desligada 4 | escolha 6-> desligada 5

        if(lampadas[escolha-1].isLigada()){
            lampadas[escolha-1].desligar();
            System.out.println("Lampada [" + escolha + "] desligada com sucesso!");
        } else{
            throw  new LampadaException("Lampada já esta desligada");
        }
    }

    public void lampadasLigadas() {
        for (int i = 0; i <QNT ; i++) {
            Lampada lampada1 = lampadas[i];
            if (lampada1.isLigada()) {
               // System.out.println("id lampada que se encontra ligada: " + (i)); 0 1 2 3 4 5
                System.out.println("id lampada que se encontra ligada: " + (i+1)); // 1 2 3 4 5 6
            }
        }
    }

    public void listarPercentualDesligadas() {
         List<Lampada> lampadaList = new ArrayList<>();

        for (Lampada lamp : lampadas) {
            if (!lamp.isLigada()) {
                lampadaList.add(lamp);
            }
        }
        double percentDeslig = ((double) lampadaList.size() / QNT) * 100;
        if(percentDeslig!=0) {
            System.out.println("Percentual de lampadas desligadas: " + percentDeslig + "%");
        }else{
            System.out.println("Percentual desligada: " + percentDeslig);
        }
    }


}



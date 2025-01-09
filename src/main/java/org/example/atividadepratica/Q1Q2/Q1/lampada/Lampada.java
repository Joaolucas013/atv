package org.example.atividadepratica.Q1Q2.Q1.lampada;

public class Lampada {

    private boolean ligada;

    public Lampada(){
        this.ligada = false;
    }

    public void desligar() {
        ligada = false;
    }

    public void ligar() {
        this.ligada = true;
    }

    public boolean isLigada() {
        return ligada;
    }


}

package org.example;

import org.example.atividadepratica.Q1Q2.Q2.service.EmpregadoService;

import java.util.Scanner;

public class EmpregadoUtil {

    private static EmpregadoService service = new EmpregadoService();

    public static void main(String[] args) {
        service.inicializar();
        boolean encerrar = true;

        while (encerrar) {
            service.menu();
            int opcao = new Scanner(System.in).nextInt();

            switch (opcao) {
                case 1:
                    atualizarHoras();
                    break;
                case 2:
                   maiorSalarioPorHora();
                    break;
                case 3:
                    menorSalarioPorHora();
                    break;
                case 4:
                    listarMediaHoraTrabalhada();
                    break;
                case 5:
                    encerrar=false;
                    break;


            }
        }
    }

    private static void listarMediaHoraTrabalhada() {
        service.listarMediaHoraTrabalhada();
    }

    private static void menorSalarioPorHora() {
        service.menorSalarioPorHora();
    }

    private static void maiorSalarioPorHora() {
        service.listarMaiorSalarioHora();
    }

    private static void atualizarHoras() {
        service.atualizarHoras();
    }
}

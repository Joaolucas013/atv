package org.example;

import org.example.aluno.service.Service;

import java.util.Scanner;

public class AlunoMain {

    static Scanner scanner = new Scanner(System.in);
    //static List<Aluno> alunos = new ArrayList<>();

    public  static Service service = new Service();

    public static void main(String[] args) {


//        for (int i = 0; i <=1 ; i++) {
//            System.out.println("Informe a matricula do aluno");
//            int matricula = scanner.nextInt();
//            System.out.println("Informe o nome do aluno:");
//          String nome =  scanner.nextLine();
//            System.out.println("Informe o sexo do aluno: (F/M)");
//            String sexo = scanner.nextLine();
//            System.out.println("Informe o nome do curso:");
//            String curso = scanner.nextLine();
//            System.out.println("Informe o ano de ingresso");
//            int anoIngresso = scanner.nextInt();
//            System.out.println("Informe o semestre de ingresso do aluno:");
//            int semestreIngresso = scanner.nextInt();
//
//            alunos.add(new Aluno(matricula, nome, sexo, curso, anoIngresso, semestreIngresso));
//        }

        boolean encerrar = false;

        while (!encerrar) {
            menu();
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    listarDadosAlunos();
                    break;
                case 2:
                    listarPeloAnoAndSemestre();
                    break;
                case 3:
                    listarQuantidadeAlunos();
                    break;
                case 4:
                    listarPercentual();
                    break;
            }

        }
    }

    private static void listarPercentual() {
       service.listarPercentualSexo();
    }


private static void listarQuantidadeAlunos() {
    service.quantidade();

}

private static void listarPeloAnoAndSemestre() {
   service.listarAnoSemestre();
}

private static void listarDadosAlunos() {
    service.listarDadosAlunos();

}

private static void menu() {
    System.out.println("""
                *** escolha uma opção!!! ***
                1 - Listagem de matrículas, nomes, anos e semestres de ingresso de alunos de determinado curso
                2 - Listagem de matrículas, nomes e cursos de alunos que ingressaram em determinado ano e semestre, a serem informados
                    pelo usuário
                3 - Listagem de quantidade de alunos até então inseridos
                4 - listar percentual
                
               """);
}

}
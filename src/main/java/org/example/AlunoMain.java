package org.example;

import org.example.aluno.Aluno;
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
            service.menu();
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
                case 5:
                   cadastrarAluno();
            }

        }
    }

    private static void cadastrarAluno() {
        var aluno = cadastro();
        service.cadastrarAluno(aluno);
        System.out.println("Aluno cadastrado com sucesso!");

    }

    private static Aluno cadastro() {
        System.out.println("Informe a matricula do aluno:");
        int matricula = new Scanner(System.in).nextInt();
        System.out.println("Informe o nome do aluno");
        String name = new Scanner(System.in).nextLine().trim();
        System.out.println("Informe o sexo do aluno(a): (F/M)");
        String sexo = new Scanner(System.in).nextLine().trim();
        System.out.println("Informe o curso:");
        String curso = new Scanner(System.in).nextLine().trim();
        System.out.println("Informe o ano de ingresso:");
        int ano = new Scanner(System.in).nextInt();
        System.out.println("Informe o semestre de ingresso do aluno:");
        int semestre = new Scanner(System.in).nextInt();
        var aluno = new Aluno(matricula, name, sexo, curso, ano, semestre);
        return aluno;
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



}
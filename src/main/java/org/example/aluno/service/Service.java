package org.example.aluno.service;


import org.example.aluno.Aluno;
import org.example.aluno.AlunoDAO;
import org.example.aluno.conexao.ConnectionFactory;

import java.sql.Connection;
import java.util.Scanner;

public class Service {

    private ConnectionFactory connection;

    public Service(){
        this.connection = new ConnectionFactory();
    }

    public void listarDadosAlunos() {
        Connection conn = connection.retornarConexao();
        System.out.println("informe o curso do aluno:");
        String curso = new Scanner(System.in).nextLine();
        var aluno = new AlunoDAO(conn).listar(curso);
        aluno.stream()
                .forEach(System.out::println);
    }

    public void listarPercentualSexo() {
        Connection conn = connection.retornarConexao();
        new AlunoDAO(conn).listarPercentual();
    }

    public void listarAnoSemestre() {
        Connection connec = connection.retornarConexao();
        System.out.println("Informe o ano de ingresso");
        int ano = new Scanner(System.in).nextInt();
        System.out.println("Informe o semestre de ingresso: (1/2)");
        int semestre = new Scanner(System.in).nextInt();
        var aluno = new AlunoDAO(connec).listarAnoSemestre(ano, semestre);
        aluno.stream()
                .forEach(System.out::println);
    }


    public void quantidade(){
        Connection connection1 = connection.retornarConexao();
        var aluno = new AlunoDAO(connection1).quantidade();

        System.out.println("Quantidade de pessoas cadastradas: " + aluno.size());
    }


    public void cadastrarAluno(Aluno aluno) {
     Connection connection1 = connection.retornarConexao();
     new AlunoDAO(connection1).cadastro(aluno);

    }


    public void menu() {
        System.out.println("""
                *** escolha uma opção!!! ***
                1 - Listagem de matrículas, nomes, anos e semestres de ingresso de alunos de determinado curso
                2 - Listagem de matrículas, nomes e cursos de alunos que ingressaram em determinado ano e semestre, a serem informados
                    pelo usuário
                3 - Listagem de quantidade de alunos até então inseridos
                4 - listar percentual
                5 - cadastrar aluno
               """);
    }
}

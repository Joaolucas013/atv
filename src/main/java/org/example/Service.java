package org.example;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Service {

    private ConnectionFactory connection;

    public Service(){
        this.connection = new ConnectionFactory();
    }

    public void listarDadosAlunos() {
        Connection conn = connection.retornarConexao();
        var aluno = new AlunoDAO(conn).listar();
        aluno.stream()
                .forEach(System.out::println);
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

    public int quantidade() {
        Connection connection1 = connection.retornarConexao();
      var aluno =   new AlunoDAO(connection1).quantidade();
      return aluno.size();

    }
}

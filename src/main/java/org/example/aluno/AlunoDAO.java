package org.example.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private Connection conn;
    public static  List<Aluno> alunos = new ArrayList<>();

    public AlunoDAO(Connection connection){
        this.conn = connection;
    }

    public List<Aluno> listar(String curso) {
        List<Aluno> alunos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select * from aluno a where a.curso like ?;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, curso + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                int matricula = rs.getInt(1);
                String nome = rs.getString(2);
                String sexo = rs.getString(3);
                String cursoo = rs.getString(4);
                int ano_ingresso = rs.getInt(5);
                int semestre = rs.getInt(6);

                Aluno aluno = new Aluno(matricula, nome, sexo, cursoo, ano_ingresso, semestre);
                alunos.add(aluno);
            }
            ps.execute();
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alunos;
    }


    public List<Aluno> listarAnoSemestre(int ano, int semestre) {
      //  List<Aluno> alunos = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;
            String sql = "select * from aluno a where a.ano_ingresso=? and a.semestre_ingresso=? ;";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, ano);
            ps.setInt(2, semestre);
            rs = ps.executeQuery();

            while (rs.next()){
                int matricul = rs.getInt(1);
                String nom = rs.getString(2);
                String sex = rs.getString(3);
                String curs = rs.getString(4);
                int ano_ingress = rs.getInt(5);
                int semestr = rs.getInt(6);

                Aluno aluno = new Aluno(matricul, nom, sex, curs, ano_ingress, semestr);
                alunos.add(aluno);
            }

            ps.execute();
            ps.close();
            rs.close();
            conn.close();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alunos;
    }

    public List<Aluno>  quantidade() {
       // List<Aluno> alunos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select * from aluno;";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                int matricul = rs.getInt(1);
                String nom = rs.getString(2);
                String sex = rs.getString(3);
                String curs = rs.getString(4);
                int ano_ingress = rs.getInt(5);
                int semestr = rs.getInt(6);

                Aluno aluno = new Aluno(matricul, nom, sex, curs, ano_ingress, semestr);
                alunos.add(aluno);
            }

            ps.close();
            rs.close();
            conn.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alunos;
    }

    private int listarQuantidadeFeminino() {
        String sql = "Select * from aluno a where a.sexo = 'F' ";
       List<Aluno> alunosFem = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        int quantidadeFeminino;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                int matricul = rs.getInt(1);
                String nom = rs.getString(2);
                String sex = rs.getString(3);
                String curs = rs.getString(4);
                int ano_ingress = rs.getInt(5);
                int semestr = rs.getInt(6);

                Aluno aluno = new Aluno(matricul, nom, sex, curs, ano_ingress, semestr);
                alunosFem.add(aluno);
            }

            ps.close();
            rs.close();
           // conn.close();

          quantidadeFeminino = alunosFem.size();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quantidadeFeminino;

    }

//    private int listarQuantidadeMasculino(){
//        String sql = "Select * from aluno  where sexo = 'M' ;";
//        List<Aluno> alunosMasc = new ArrayList<>();
//        PreparedStatement ps;
//        ResultSet rs;
//        int quantidadeMasc;
//        try {
//            ps = conn.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            while (rs.next()){
//
//                int matricula = rs.getInt(1);
//                String nome = rs.getString(2);
//                String sexo = rs.getString(3);
//                String curso = rs.getString(4);
//                int ano = rs.getInt(5);
//                int semestre = rs.getInt(6);
//
//                Aluno aluno = new Aluno(matricula,nome,sexo, curso, ano, semestre);
//                alunosMasc.add(aluno);
//            }
//            quantidadeMasc = alunosMasc.size();
//            ps.execute();
//            ps.close();
//            rs.close();
//           conn.close();
//
//        }catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//     return quantidadeMasc;
//
//    }


    public void listarPercentual() {
        int quantidadeMulher = listarQuantidadeFeminino();
        int total = quantidade().size();

        double percentualMulher = ((double) quantidadeMulher / total) * 100;
        double percentualHomens = 100 - percentualMulher;

        System.out.println("*** Informacoes percentuais ****");

        System.out.println("Percentual de mulheres: " + percentualMulher + "%");
        System.out.println("Percentual de homens: " + percentualHomens + "%");
        System.out.println("___________________________________________");

    }

    public void cadastro(Aluno aluno) {
        String sql = "INSERT INTO aluno(matricula, nome, sexo, curso, ano_ingresso, semestre_ingresso)" +
                " values(?,?,?,?,?,?)";
        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, aluno.getMatricula());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getSexo());
            ps.setString(4, aluno.getCurso());
            ps.setInt(5, aluno.getAnoIngresso());
            ps.setInt(6, aluno.getSemestreIngresso());

            ps.execute();
            ps.close();
            conn.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

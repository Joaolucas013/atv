package org.example;

import javax.xml.stream.events.Characters;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private Connection conn;

    public AlunoDAO(Connection connection){
        this.conn = connection;
    }

    public List<Aluno> listar() {
        PreparedStatement ps;
        ResultSet rs;
        List<Aluno> alunos = new ArrayList<>();
        String sql = "select * from aluno ;";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int matricula = rs.getInt(1);
                String nome = rs.getString(2);
                String sexo = rs.getString(3);
                String curso = rs.getString(4);
                int ano_ingresso = rs.getInt(5);
                int semestre = rs.getInt(6);

                Aluno aluno = new Aluno(matricula, nome, sexo, curso, ano_ingresso, semestre);
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
        List<Aluno> alunos = new ArrayList<>();

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
        List<Aluno> alunos = new ArrayList<>();
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
}

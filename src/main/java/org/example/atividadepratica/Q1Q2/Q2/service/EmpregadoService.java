package org.example.atividadepratica.Q1Q2.Q2.service;

import org.example.atividadepratica.Q1Q2.Q2.empregado.Empregado;
import org.example.atividadepratica.Q1Q2.Q2.empregadoexception.EmpregadoException;

import java.util.Scanner;

public class EmpregadoService {

    static Scanner scan = new Scanner(System.in);
    private static final int QNT = 6;
    private static Empregado[] empregados = new Empregado[QNT];

    public void inicializar(){
        for (int i = 0; i <2 ; i++) {
            System.out.println("Informe o seu nome:");
            String nome = new Scanner(System.in).nextLine().trim();
            System.out.println("Informe o departamento:");
            String departamento = new Scanner(System.in).nextLine().trim();
            System.out.println("Informe o salario/hora: (exemplo: 20 reais por hora)");
            int salarioHora = scan.nextInt();


            empregados[i] = new Empregado(nome, departamento, salarioHora);
        }

    }

    public void menu(){
        System.out.println("""
                1- Atualizar quantidade de horas trabalhadas de algum dos 5 (cinco) funcionários após entrada, pelo usuário, de funcionário e
                de quantidade adicional de horas trabalhadas;
                2- Listar nome, departamento e salário (atual) de empregado com maior salário por hora trabalhada;
                3- Listar nome, departamento e salário (atual) de empregado com menor quantidade de horas trabalhadas;
                4- Listar média salarial por hora trabalhada considerando dados fornecidos para os 5 (cinco) funcionários;
                5- Encerrar aplicação.""");
    }


    public void atualizarHoras() {
        boolean encontrado = false;
        System.out.println("Informe o nome do funcionário:");
        String name = new Scanner(System.in).nextLine();
        for (Empregado empregado : empregados) {
            if (empregado.getName().equalsIgnoreCase(name)) {
                System.out.println("Informe a quantidade adicional de horas:");
                int hrs = scan.nextInt();
                empregado.adicionarHorasTrabalhadas(hrs);
                encontrado=true;
            }
        }
        if(!encontrado){
            throw new EmpregadoException("Nenhum empregado encontrado com nome: [" + name.toUpperCase() + "]");
        }
    }

    public void listarMaiorSalarioHora() {
        Empregado empregadoMaior = empregados[0];
        for (int i = 0; i < QNT; i++) {
            Empregado empregado = empregados[i];
            if (empregado.getSalarioHora() > empregadoMaior.getSalarioHora()) {
                empregadoMaior = empregado;
            }
        }
        validacao(empregadoMaior);
        System.out.println("Informacões: " + empregadoMaior.toString());
    }

    public void menorSalarioPorHora() {
        Empregado empregadoMenor = empregados[0];

        for (int i = 0; i < QNT; i++) {
            Empregado empregado = empregados[i];
            if (empregado.getSalarioHora() < empregadoMenor.getSalarioHora()) {
                empregadoMenor = empregado;
            }
            validacao(empregadoMenor);
        }
        System.out.println("Funcionário com  menor salario/hora: " + empregadoMenor.toString());
    }

    public void listarMediaHoraTrabalhada() {
        double somaSalarioHora = 0;
        for (Empregado empregado:empregados){
            somaSalarioHora+=empregado.getSalarioHora();
        }
        double media = somaSalarioHora/empregados.length;
        System.out.println("Média salarial por hora trabalhada considerando dados fornecidos para os 5 (cinco) funcionários: " + media);
    }

    private void validacao(Empregado empregadoMaior) {
        if (empregadoMaior.getHorasTrabalhadasPorMes() == 0) {
            System.out.println("informe a quantidade de horas trabalhadas, " + empregadoMaior.getName() + ".");
            int hrs = scan.nextInt();
            empregadoMaior.adicionarHorasTrabalhadas(hrs);
        }
    }
}

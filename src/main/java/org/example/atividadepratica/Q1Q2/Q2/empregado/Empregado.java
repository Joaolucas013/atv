package org.example.atividadepratica.Q1Q2.Q2.empregado;

public class Empregado {
    private String name;
    private String departamento;
    private double salarioHora;
    private int horasTrabalhadasPorMes;


    public Empregado(String nome, String departamento, double salarioHora){
        this.name = nome;
        this.departamento = departamento;
        this.salarioHora = salarioHora;
        this.horasTrabalhadasPorMes=0;
    }

//    public String retornaNome(){
//        return  name;
//    }

   public  double getSalario(){
     return salarioHora * horasTrabalhadasPorMes;
   }


    public void adicionarHorasTrabalhadas(int hours){
        this.horasTrabalhadasPorMes+=hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }

    public int getHorasTrabalhadasPorMes() {
        return horasTrabalhadasPorMes;
    }

    public void setHorasTrabalhadasPorMes(int horasTrabalhadasPorMes) {
        this.horasTrabalhadasPorMes = horasTrabalhadasPorMes;
    }

    @Override
    public String toString() {
        return
                " nome=" + name  +
                ", departamento:" + this.getDepartamento() +
                ", salario atual:" + getSalario()  +
                " salarioHora=" + salarioHora;
    }
}

 package org.example;





 import org.example.atividadepratica.Q1Q2.Q1.service.Service;

 import java.util.Scanner;

 public class LampadaUtil {

    public static Service service = new Service();

    public static void main(String[] args) {
         boolean encerrar = false;
         service.inicializar();

         while (!encerrar) {
             service.menu();
             int opcao = new Scanner(System.in).nextInt();

             switch (opcao) {
                 case 1:
                     service.ligarAlgumaLampada();
                     break;
                 case 2:
                     service.desligarAlgumaLampada();
                     break;
                 case 3:
                     service.lampadasLigadas();
                     break;
                 case 4:
                     service.listarPercentualDesligadas();
                     break;
                 case 5:
                     System.out.println("Encerrando...");
                     encerrar = true;
                 default:
                     System.out.println("Opção não listada no menu!");
                     break;
             }
         }

     }


}



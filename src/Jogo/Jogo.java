package Jogo;

import Entidades.Piloto;
import Entidades.Veiculo;

import java.util.Scanner;

public class Jogo {

    //CRIAR PILOTO






    // DEFINIR DIFICULDADE
    private int escolherDificuldade(Scanner input) {
        int dificuldade = 0;
        boolean opcaoValida = false;

        while (!opcaoValida) {
            try {
                System.out.println("\n [DIFICULDADE DO JOGO] ");
                System.out.println(" Escolhe a dificuldade inserindo a opção númerica correspondente: ");
                System.out.println(" [1] Fácil"); //ATRIBUI 2000 FICHAS DE CORRIDA
                System.out.println(" [2] Difícil"); //ATRIBUI 1500 FICHAS DE CORRIDA
                System.out.print("\n> ");
                dificuldade = Integer.parseInt(input.nextLine());

                if (dificuldade == 1 || dificuldade == 2) {
                    opcaoValida = true;
                } else {
                    System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Só podes avançar se inserires o número [1] ou [2].");
            }
        }
        return dificuldade;
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);




    }

}

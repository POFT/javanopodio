import Entidades.*;
import Itens.Habilidade;
import Itens.ItemCorrida;
import Itens.Modificacao;
import Itens.TipoCarro;
import Jogo.Jogo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static <Habilidade> void main(String[] args) {
        Scanner input = new Scanner(System.in);



        System.out.println("\nTrabalho Prático - Desenvolvido por Pedro Oliveira");
        System.out.println("Programação Orientada a Objetos");
        System.out.println("\nBem-vindo ao Simulador de Corridas!");
        Jogo jogo = new Jogo();
        Piloto piloto = jogo.criarPiloto();
        jogo.simuladorCorridas(piloto);


 


    }
}

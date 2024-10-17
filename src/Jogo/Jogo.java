package Jogo;

import Entidades.Oficina;
import Entidades.Piloto;
import Entidades.Veiculo;

import java.util.Scanner;

public class Jogo {



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("Bem-vindo ao Simulador de Corridas!");

        Oficina oficina = new Oficina();
        oficina.carregarVeiculos("File/VeiculosCorridas.csv");

        // CRIAR UM PILOTO
        Piloto piloto = new Piloto("",0,null,0);
        piloto.definirNomePiloto();
        piloto.escolherDificuldade();
        piloto.atribuirFichas(piloto.escolherDificuldade());



        // Veiculo  veiculo = new Veiculo();
        // Piloto piloto = new Piloto("João", 0,veiculo,0);




    }

}

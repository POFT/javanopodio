import Entidades.*;
import Itens.Habilidade;
import Itens.ItemCorrida;
import Itens.Modificacao;
import Itens.TipoCarro;
import Jogo.Jogo;

import java.util.Scanner;

public class Main {

    public static <Habilidade> void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("Bem-vindo ao Simulador de Corridas!");

        Jogo jogo = new Jogo();
        Piloto piloto = jogo.criarPiloto();
        jogo.simuladorCorridas(piloto);





        // Veiculo  veiculo = new Veiculo();
        // Piloto piloto = new Piloto("João", 0,veiculo,0);




    }
}

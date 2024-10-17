package Entidades;

import Itens.ItemCorrida;

import java.util.ArrayList;
import java.util.Scanner;

public class Piloto {
    private String nome;
    private int fichasCorrida;
    private Veiculo veiculoAtual;
    private int vitorias;

    public Piloto(String nome, int fichasCorrida, Veiculo veiculoAtual, int vitorias) {
        this.nome = nome;
        this.fichasCorrida = fichasCorrida;
        this.veiculoAtual = veiculoAtual;
        this.vitorias = vitorias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFichasCorrida() {
        return fichasCorrida;
    }

    public void setFichasCorrida(int fichasCorrida) {
        this.fichasCorrida = fichasCorrida;
    }

    // DEFINIR NOME DO PILOTO
    public void definirNomePiloto() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("\n [NOME DO PILOTO] ");
            System.out.print("\n> ");
            String nomeInserido = input.nextLine();
            this.nome = nomeInserido;
            System.out.println("\nBem-vindo " + this.nome + "!");
        }
    }

    // DEFINIR DIFICULDADE
    public int escolherDificuldade() {
        int dificuldade = 0;
        boolean opcaoValida = false;

        while (!opcaoValida) {
            try {
                System.out.println("\n [DIFICULDADE DO JOGO] ");
                System.out.println("Escolha a dificuldade inserindo a opção numérica correspondente: ");
                System.out.println(" [1] Fácil - 2000 fichas de corrida");
                System.out.println(" [2] Difícil - 1500 fichas de corrida");
                System.out.print("\n> ");
                dificuldade = Integer.parseInt(input.nextLine());

                if (dificuldade == 1 || dificuldade == 2) {
                    opcaoValida = true;
                } else {
                    System.out.println("Opção inválida! Escolha entre [1] ou [2].");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Escolha entre [1] ou [2].");
            }
        }
        return dificuldade;
    }


    // DEFINIR ATRIBUIÇÃO FICHAS DE CORRIDA
    public void atribuirFichas(int dificuldade) {
        if (dificuldade == 1) {
            this.fichasCorrida = 2000;
        } else if (dificuldade == 2) {
            this.fichasCorrida = 1500;
        } else {
            System.out.println("Opção inválida!");
        }
    }


    // USAR ITEM COM LIMITE DE 2 POR CORRIDA
    public void usarItem(int maxItemsPorCorrida) {
        ArrayList<ItemCorrida> inventario = veiculoAtual.getInventario();
        try (Scanner scanner = new Scanner(System.in)) {
            int itemsUsados = 0;

            while (itemsUsados < maxItemsPorCorrida && !inventario.isEmpty()) {
                System.out.println("\n [INVENTÁRIO DE ITEMS] ");
                for (int i = 0; i < inventario.size(); i++) {
                    System.out.println((i + 1) + ". " + inventario.get(i).getNome());
                }

                System.out.println("Escolha o item inserindo a opção numérica correspondente: ");
                System.out.print("\n> ");
                int escolha = scanner.nextInt();

                // Validação da escolha
                if (escolha < 1 || escolha > inventario.size()) {
                    System.out.println("Opção inválida! Tente novamente.");
                    continue;  // Voltar ao início do loop e permitir uma nova escolha
                }

                ItemCorrida itemEscolhido = inventario.get(escolha - 1);
                aplicarEfeitos(itemEscolhido);
                inventario.remove(escolha - 1);
                System.out.println("Item utilizado: " + itemEscolhido.getNome());

                itemsUsados++;
            }

            if (itemsUsados >= maxItemsPorCorrida) {
                System.out.println("Máximo de 2 itens por corrida foi alcançado.");
            }
        }
    }



    private void aplicarEfeitos(ItemCorrida item) {
        item.aplicarEfeito(veiculoAtual);  // O item sabe como aplicar o seu efeito
    }


    // MÉTODO PARA CALCULAR O TEMPO TOTAL DA CORRIDA E VERIFICAR O RECORDE
    public double corrida(Pista pista, ArrayList<Momento> momentosPista) {
        double tempoTotal = 0.0;
        double desgaste = 0.0;
        int numeroVoltas = pista.getQuantidadeVoltas();
        double tempoRecorde = pista.getTempoRecordeSeg();

        for (int i = 0; i < numeroVoltas; i++) {
            double distanciaVolta = pista.getDistanciaVoltaM();
            double potencia = veiculoAtual.getPotenciaCV();
            double peso = veiculoAtual.getPesokg();
            double tempoVolta = (distanciaVolta / (1.6 * potencia)) - (0.2 * peso) - (0.5 * desgaste);

            double atrasoTotal = 0.0;
            for (Momento momento : momentosPista) {
                double atraso = ((peso * momento.getAtrasoPeso()) + (potencia * momento.getAtrasoPotencia())) / 100;
                atrasoTotal += atraso;
            }

            tempoTotal += tempoVolta + atrasoTotal;
            desgaste += 20;
        }

        System.out.println("Tempo total da corrida: " + tempoTotal + " segundos");

        // Verificar se o piloto bateu o recorde da pista
        if (tempoTotal < tempoRecorde) {
            System.out.println("Parabéns! Bateu o recorde da pista!");
            this.fichasCorrida += 500; // Bônus por bater o recorde
        } else {
            this.fichasCorrida += 250; // Recompensa parcial
        }

        return tempoTotal;
    }
}

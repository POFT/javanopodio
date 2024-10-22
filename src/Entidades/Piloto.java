package Entidades;

import Itens.Habilidade;
import Itens.ItemCorrida;
import Itens.Modificacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Piloto {
    private String nome;
    private int fichasCorrida;
    private Veiculo veiculoAtual;
    private int vitorias=0; // Começa o jogo com 0 vitórias.

    public Piloto(String nome, int fichasCorrida, Veiculo veiculoAtual, int vitorias) {
        this.nome = nome;
        this.fichasCorrida = fichasCorrida;
        this.veiculoAtual = veiculoAtual;
        this.vitorias = vitorias;
    }

    // GETTERS & SETTERS
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

    public Veiculo getVeiculoAtual() {
        return veiculoAtual;
    }

    public void setVeiculoAtual(Veiculo veiculoAtual) {
        this.veiculoAtual = veiculoAtual;
    }


    /**
     * Método para apresentar/utilizar o item no inventário do Piloto,
     * @param maxItemsPorCorrida
     */
    public void usarItem(int maxItemsPorCorrida) {

        ArrayList<ItemCorrida> inventario = veiculoAtual.getInventario();
        Scanner input = new Scanner(System.in);

        // VALIDAÇÃO DE INVENTÁRIO (VAZIO)
        if (inventario.isEmpty()) {
            System.out.println("O inventário está vazio!");
            return;
        }

        int itemsUsados = 0;
        while (itemsUsados < maxItemsPorCorrida && !inventario.isEmpty()) {
            System.out.println("\n [INVENTÁRIO DE ITEMS] ");
            for (int i = 0; i < inventario.size(); i++) {
                System.out.println((i + 1) + ". " + inventario.get(i).getNome());
            }

            System.out.println("Escolha o item inserindo a opção numérica correspondente: ");
            System.out.print("\n> ");
            int escolha = input.nextInt();

            // VALIDAÇÃO ESCOLHA
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
                System.out.println("Máximo de " + maxItemsPorCorrida + " itens por corrida foi alcançado.");
        }
    }


    /**
     * Método auxiliar para aplicarEfeitos no método usarItem,
     * @param item
     */
    private void aplicarEfeitos(ItemCorrida item) {

        if (item instanceof Modificacao){
            Modificacao modificacao = (Modificacao) item;
            veiculoAtual.setDesgaste(veiculoAtual.getDesgaste()- modificacao.getDiminuicaoDesgaste());
            veiculoAtual.setPesokg(veiculoAtual.getPesokg()- modificacao.getDiminuicaoPeso());
        } else if (item instanceof Habilidade) {
            Habilidade habilidade = (Habilidade) item;
            veiculoAtual.setPotenciaCV(veiculoAtual.getPotenciaCV()+ habilidade.getAumentoPotencia());
        }
    }


    /**
     * Método para calcular o tempo total da corrida e validar se recorde da pista é batido,
     * @param pista
     * @return tempoTotal
     */
    public double corrida(Pista pista) {
        double tempoTotal = 0.0;
        int numeroVoltas = pista.getQuantidadeVoltas();
        double tempoRecorde = pista.getTempoRecordeSeg();

        // Desgaste inicial do veículo
        double desgaste = veiculoAtual.getDesgaste(); // CORREÇÃO

        for (int i = 0; i < numeroVoltas; i++) {
            double distanciaVolta = pista.getDistanciaVoltaM();
            double potencia = veiculoAtual.getPotenciaCV();
            double peso = veiculoAtual.getPesokg();

            // Calcular o tempo da volta:
            double tempoBase = distanciaVolta / (1.6 * potencia);
            double ajustePeso = (0.2 * peso);
            double ajusteDesgaste = (0.5 * desgaste);
            double tempoVolta = tempoBase + ajustePeso + ajusteDesgaste;

            // Calcular os atrasos nos momentos da pista:
            double atrasoTotal = 0.0;
            for (Momento momento : pista.getMomentosPista()) {
                double atraso = ((peso * momento.getAtrasoPeso()) + (potencia * momento.getAtrasoPotencia())) / 100;
                atrasoTotal += atraso;
            }

            // Soma o tempo da volta mais o atraso total
            tempoTotal += tempoVolta + atrasoTotal;

            // Incrementar o desgaste por volta
            veiculoAtual.aumentarDesgaste(20);
            desgaste = veiculoAtual.getDesgaste();

            // Se valor de desgaste ultrapassa o limite (1000)
            if (desgaste > 1000) {
                System.out.println("O teu veículo avariou durante a corrida!");
                break; // AVARIADO
            }

        }

        System.out.println("O teu Tempo total: " + tempoTotal + " segundos");
        // Verificar se o piloto bateu o recorde da pista
        if (tempoTotal < tempoRecorde && desgaste < 1000) {
            // Se tempo do piloto na pista for inferior ao tempo recorde da pista
            System.out.println("\nParabéns! Bateu o recorde da pista! ");
            this.fichasCorrida += 1000; // Prémio total
            this.vitorias++;
            System.out.println("Prémio: 1000/1000\n");
        } else {
            this.fichasCorrida += 500; // Prémio parcial
            System.out.println("Terminaste a corrida mas o recorde não é teu!");
            System.out.println("Prémio: 500/1000");
        }

        return tempoTotal;
    }


    /**
     * Método para apresentar os detalhes do piloto
     */
    public void mostrarDetalhes() {
        System.out.println("\n***** DETALHES DO PILOTO *****");
        System.out.println("Nome do piloto: " + this.nome);
        System.out.println("Fichas de corrida: " + this.fichasCorrida);
        System.out.println("Vitórias: " + this.vitorias);
        System.out.println("******************************\n");
    }


}

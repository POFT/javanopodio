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




    // METODO USAR ITEM COM LIMITE DE 2 POR CORRIDA
    public void usarItem(int maxItemsPorCorrida) {
        ArrayList<ItemCorrida> inventario = veiculoAtual.getInventario();

        // Verificação se o inventário está vazio
        if (inventario.isEmpty()) {
            System.out.println("O inventário está vazio! Nenhum item disponível para usar.");
            return;
        }

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
                System.out.println("Máximo de " + maxItemsPorCorrida + " itens por corrida foi alcançado.");
            }
        }
    }

    // METODO AUXILIAR PARA APLICAR OS ITENS
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


    // MÉTODO PARA CALCULAR O TEMPO TOTAL DA CORRIDA E VERIFICAR O RECORDE
    public double corrida(Pista pista) {
        double tempoTotal = 0.0;
        //double desgaste = 0.0;
        double desgaste = veiculoAtual.getDesgaste(); // CORREÇÃO
        int numeroVoltas = pista.getQuantidadeVoltas();
        double tempoRecorde = pista.getTempoRecordeSeg();

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


            tempoTotal += tempoVolta + atrasoTotal;
            // Auto desgaste em cada volta:
            desgaste += 20;
        }

        System.out.println("O teu Tempo total: " + tempoTotal + " segundos");

        if (desgaste > 1000) {
            System.out.println("O teu veículo avariou durante a corrida!");
        }

        // Verificar se o piloto bateu o recorde da pista
        if (tempoTotal < tempoRecorde && desgaste < 1000) {
            System.out.println("Parabéns! Bateu o recorde da pista! ");
            this.fichasCorrida += 1000; // Bônus por bater o recorde
            this.vitorias++;
            System.out.println("Prémio: 1000/1000");
        } else {
            this.fichasCorrida += 500; // Recompensa parcial
            System.out.println("Terminaste a corrida mas o recorde não é teu!");
            System.out.println("Prémio: 500/1000");
        }

        return tempoTotal;
    }




    public void mostrarDetalhes() {
        System.out.println("***** DETALHES DO PILOTO *****");
        System.out.println("Nome do piloto: " + this.nome);
        System.out.println("Fichas de corrida: " + this.fichasCorrida);
        System.out.println("Vitórias: " + this.vitorias);

        if (this.veiculoAtual != null) {
            System.out.println("\n[DETALHES DO VEÍCULO ATUAL]");
            veiculoAtual.mostrarDetalhes(); // Exibe os detalhes do veículo atual
        } else {
            System.out.println("\nNenhum veículo atual atribuído ao piloto.");
        }
        System.out.println("******************************");
    }


}

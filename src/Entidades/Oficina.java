package Entidades;

import Itens.ItemCorrida;
import Itens.Modificacao;
import Itens.TipoCarro;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * A Classe Oficina é a responsável por fornecer veiculo e itens para o jogador/personagem.
 */
public class Oficina {

    private ArrayList<Veiculo> garagem;
    private ArrayList<ItemCorrida> stock;

    // Construtor
    public Oficina() {
        this.garagem = new ArrayList<>();
        this.stock = new ArrayList<>();
    }



    // GETTERS & SETTERS
    public ArrayList<Veiculo> getGaragem() {
        return garagem;
    }

    public void setGaragem(ArrayList<Veiculo> garagem) {
        this.garagem = garagem;
    }

    public ArrayList<ItemCorrida> getStock() {
        return stock;
    }

    public void setStock(ArrayList<ItemCorrida> stock) {
        this.stock = stock;
    }


    /**
     * Método auxiliar para imprimir stock da oficina no método venderItem,
     * @return array random de 6 itens max.
     */
    public ArrayList<ItemCorrida> imprimirStock() {
        if (stock == null || stock.isEmpty()) {
            System.out.println("Não existem itens na garagem.");
            return new ArrayList<>(); // Retorna uma lista vazia
        }
        Random random = new Random();
        ArrayList<ItemCorrida> itensSelecionados = new ArrayList<>();
        int quantidadeItens = Math.min(stock.size(), 6);

        while (itensSelecionados.size() < quantidadeItens) {
            int indexAleatorio = random.nextInt(stock.size());
            ItemCorrida item = stock.get(indexAleatorio);
            // Certifica-se de não adicionar o mesmo item mais de uma vez
            if (!itensSelecionados.contains(item)) {
                itensSelecionados.add(item);
            }
        }
        // Exibe os itens selecionados
        System.out.println("[OFICINA ITENS]");
        int indice = 0;
        for (ItemCorrida item : itensSelecionados) {
            System.out.println("Item #" + indice);
            item.mostrarDetalhes();
            System.out.println("____________________________");
            indice++;
        }
        return itensSelecionados;
    }

    /**
     * Método para vender/comprar item na Oficina(Stock)
     * @param piloto
     */
    public void venderItem(Piloto piloto) {
        Scanner input = new Scanner(System.in);

        if (stock.isEmpty()) {
            System.out.println("Não há itens disponíveis para venda.");
            return;
        }

        int itensComprados = 0;
        int maxItens = 2; // Limite máximo de itens que pode comprar

        do{
            ArrayList<ItemCorrida> itensTemp = imprimirStock();
            System.out.println("Fichas: " + piloto.getFichasCorrida());

            System.out.println("Escolhe o item pelo índice:");
            int opcao = input.nextInt();

            // Verificação se a opção é válida
            if (opcao < 0 || opcao >= stock.size()) {
                System.out.println("Opção inválida.");
                return;
            }

            ItemCorrida itemEscolhido = stock.get(opcao);

            if (piloto.getFichasCorrida() >= itemEscolhido.getPrecoEmFichasCorrida()) {
                piloto.setFichasCorrida(piloto.getFichasCorrida() - itemEscolhido.getPrecoEmFichasCorrida());
                piloto.getVeiculoAtual().adicionarItem(itemEscolhido);
                System.out.println("Compra efetuada com sucesso: [" + itemEscolhido.getNome() + "]");
                itensComprados++; // Aumenta o contador de itens comprados
            } else {
                System.out.println("Não tens saldo suficiente!!!");
            }

        } while (itensComprados < maxItens);

        System.out.println("Apenas é possível comprar " + maxItens + " itens neste acesso.");
    }

    /**
     * Método auxiliar para imprimir garagem da oficina no método venderVeiculo,
     * @return array random de 12 veiculos max.
     */
    public ArrayList<Veiculo> imprimirGaragem() {
        if (garagem == null || garagem.isEmpty()) {
            System.out.println("Não existem veículos na garagem.");
            return new ArrayList<>(); // Retorna uma lista vazia
        }
        Random random = new Random();
        ArrayList<Veiculo> veiculosSelecionados = new ArrayList<>();
        int quantidadeVeiculos = Math.min(garagem.size(), 12);

        while (veiculosSelecionados.size() < quantidadeVeiculos) {
            int indexAleatorio = random.nextInt(garagem.size());
            Veiculo veiculo = garagem.get(indexAleatorio);

            if (!veiculosSelecionados.contains(veiculo)) {
                veiculosSelecionados.add(veiculo);
            }
        }

        System.out.println("\n[OFICINA GARAGEM]");
        int indice = 0;
        for (Veiculo veiculo : veiculosSelecionados) {
            System.out.println("Veículo [" + indice + "]");
            veiculo.mostrarDetalhes();
            System.out.println("____________________________");
            indice++;
        }
        return veiculosSelecionados;
    }


    /**
     * Método para vender/comprar veiculo na Oficina(garagem)
     * @param piloto
     */
    public void venderVeiculo(Piloto piloto) {
        Scanner input = new Scanner(System.in);

        if (garagem.isEmpty()) {
            System.out.println("Não há veículos disponíveis para venda.");
            return;
        }
        // Valor de retoma existe à condição se existe veiculo atual(true), se não é 0(false)
        int valorRetoma = piloto.getVeiculoAtual() != null ? piloto.getVeiculoAtual().getPreco() / 2 : 0;

        do {
            ArrayList<Veiculo> garagemTemp = imprimirGaragem();
            System.out.println("[Fichas disponíveis: " + piloto.getFichasCorrida() + "]");
            if (piloto.getVeiculoAtual()!=null){
                System.out.println("[Valor de retoma: " + valorRetoma + " fichas]");
                System.out.println("Podes gastar até " + (piloto.getFichasCorrida() + valorRetoma));
            }


            System.out.println("Escolhe o veículo inserindo a opção numérica correspondente:");
            System.out.print("> ");
            int opcao = input.nextInt();

            // Verificação se a opção é válida
            if (opcao < 0 || opcao >= garagemTemp.size()) {
                System.out.println("Opção inválida.");
                return;
            }

            Veiculo veiculoEscolhido = garagemTemp.get(opcao);


            if (piloto.getFichasCorrida() + valorRetoma >= veiculoEscolhido.getPreco()) {
                piloto.setFichasCorrida(piloto.getFichasCorrida() - veiculoEscolhido.getPreco());
                veiculoEscolhido.setDesgaste(0);
                piloto.setVeiculoAtual(veiculoEscolhido);
                System.out.println("Compra efetuada com sucesso. [" + veiculoEscolhido.getMarca() + " " + veiculoEscolhido.getModelo()+"]");
                garagem.remove(veiculoEscolhido);
            } else {
                System.out.println("Não tens saldo suficiente!!!");
            }
            System.out.println("______________\n")    ;


        }while (piloto.getVeiculoAtual()==null);

    }
}

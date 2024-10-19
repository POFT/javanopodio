package Entidades;

import Itens.ItemCorrida;
import Itens.Modificacao;
import Itens.TipoCarro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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




    // METODO IMPRIMIR STOCK
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
            System.out.println("______________");
            indice++;
        }
        return itensSelecionados;
    }

    // METODO VENDER ITEM
    public void venderItem(Piloto piloto) {
        Scanner scanner = new Scanner(System.in);

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
            int opcao = scanner.nextInt();

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
            } else {
                System.out.println("Não tens saldo suficiente!!!");
            }

        } while (itensComprados < maxItens);

        System.out.println("Apenas é possível comprar " + maxItens + " itens neste acesso.");
    }

    // METODO IMPRIMIR GARAGEM
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
            System.out.println("______________");
            indice++;
        }
        return veiculosSelecionados;
    }



    // METODO VENDER VEICULO
    public void venderVeiculo(Piloto piloto) {
        Scanner scanner = new Scanner(System.in);

        if (garagem.isEmpty()) {
            System.out.println("Não há veículos disponíveis para venda.");
            return;
        }

        do {
            ArrayList<Veiculo> garagemTemp = imprimirGaragem();
            System.out.println("[Fichas disponíveis: " + piloto.getFichasCorrida() + "]");
            System.out.println("Escolhe o veículo inserindo a opção numérica correspondente:");
            System.out.print("> ");
            int opcao = scanner.nextInt();

            // Verificação se a opção é válida
            if (opcao < 0 || opcao >= garagemTemp.size()) {
                System.out.println("Opção inválida.");
                return;
            }

            Veiculo veiculoEscolhido = garagemTemp.get(opcao);

            if (piloto.getFichasCorrida() >= veiculoEscolhido.getPreco()) {
                piloto.setFichasCorrida(piloto.getFichasCorrida() - veiculoEscolhido.getPreco());
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

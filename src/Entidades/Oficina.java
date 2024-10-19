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
    public void imprimirStock() {
        Random random = new Random();
        int tamanho = stock.size();

        if (tamanho == 0) {
            System.out.println("Nenhum item disponível no estoque.");
            return;
        }

        // Número de itens a imprimir (máximo 6 ou o tamanho do stock)
        int quantidadeItens = Math.min(tamanho, 6);

        ArrayList<ItemCorrida> itensSelecionados = new ArrayList<>();
        while (itensSelecionados.size() < quantidadeItens) {
            int indiceAleatorio = random.nextInt(tamanho);
            ItemCorrida item = stock.get(indiceAleatorio);

            // Certifica-se de não adicionar o mesmo item mais de uma vez
            if (!itensSelecionados.contains(item)) {
                itensSelecionados.add(item);
            }
        }

        // Exibe os itens selecionados
        System.out.println("Itens disponíveis no stock:");
        for (ItemCorrida item : itensSelecionados) {
            item.mostrarDetalhes();
            System.out.println("______________");
        }
    }

    // METODO IMPRIMIR GARAGEM
    public void imprimirGaragem() {
        if (garagem.size() == 0) {
            System.out.println("Não existem veículos na garagem.");
            return;
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

        System.out.println("Veículos disponíveis na garagem:");
        int indice = 0;
        for (Veiculo veiculo : veiculosSelecionados) {
            System.out.println("Veículo #" + indice);
            veiculo.mostrarDetalhes();
            System.out.println("______________");
            indice++;
        }
    }

    // METODO VENDER ITEM
    public void venderItem(Piloto piloto, Scanner scanner) {
        if (stock.isEmpty()) {
            System.out.println("Não há itens disponíveis para venda.");
            return;
        }

        System.out.println("Itens disponíveis:");
        imprimirStock();

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
            System.out.println("Compra efetuada com sucesso.");
            stock.remove(itemEscolhido);
        } else {
            System.out.println("Não tens saldo suficiente!!!");
        }
    }




    // METODO VENDER VEICULO
    public void venderVeiculo(Piloto piloto, Scanner scanner) {
        if (garagem.isEmpty()) {
            System.out.println("Não há veículos disponíveis para venda.");
            return;
        }

        System.out.println("Veículos disponíveis:");
        imprimirGaragem();

        System.out.println("Escolhe o veículo pelo índice:");
        int opcao = scanner.nextInt();

        // Verificação se a opção é válida
        if (opcao < 0 || opcao >= garagem.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Veiculo veiculoEscolhido = garagem.get(opcao);

        if (piloto.getFichasCorrida() >= veiculoEscolhido.getPreco()) {
            piloto.setFichasCorrida(piloto.getFichasCorrida() - veiculoEscolhido.getPreco());
            piloto.setVeiculoAtual(veiculoEscolhido);
            System.out.println("Compra efetuada com sucesso.");
            garagem.remove(veiculoEscolhido);
        } else {
            System.out.println("Não tens saldo suficiente!!!");
        }
    }
}

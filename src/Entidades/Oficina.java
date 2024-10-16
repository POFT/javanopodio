package Entidades;

import Itens.ItemCorrida;

import java.util.ArrayList;

public class Oficina {

    private ArrayList<Veiculo> garagem;
    private ArrayList<ItemCorrida> stock;

    public Oficina() {
        this.garagem = new ArrayList<>();
        this.stock = new ArrayList<>();
    }

    // Método para adicionar um veículo à garagem
    public void adicionarVeiculo(Veiculo veiculo) {
        this.garagem.add(veiculo);
    }

    // Método para remover um veículo da garagem
    public void removerVeiculo(Veiculo veiculo) {
        this.garagem.remove(veiculo);
    }

    // Método para adicionar um item ao stock
    public void adicionarItem(ItemCorrida item) {
        this.stock.add(item);
    }

    // Método para remover um item do stock
    public void removerItem(ItemCorrida item) {
        this.stock.remove(item);
    }

    public ArrayList<Veiculo> getGaragem() {
        return garagem;
    }

    public ArrayList<ItemCorrida> getStock() {
        return stock;
    }




}

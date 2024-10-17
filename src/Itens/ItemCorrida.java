package Itens;

import Entidades.Veiculo;

public abstract class ItemCorrida {

    private String nome;
    private int precoEmFichasCorrida;

    public ItemCorrida(String nome, int precoEmFichasCorrida) {
        this.nome = nome;
        this.precoEmFichasCorrida = precoEmFichasCorrida;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrecoEmFichasCorrida() {
        return precoEmFichasCorrida;
    }

    public void setPrecoEmFichasCorrida(int precoEmFichasCorrida) {
        this.precoEmFichasCorrida = precoEmFichasCorrida;
    }

    // Método abstrato para mostrar os detalhes do item
    public abstract void mostrarDetalhes();


    public void aplicarEfeito(Veiculo veiculoAtual) {
    }
}

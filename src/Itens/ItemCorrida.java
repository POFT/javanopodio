package Itens;

import Entidades.Veiculo;

/**
 * A Classe abstrata ItemCorrida tem como objetivo representar os itens que podem ser utilizados para modificar ou melhorar o desempenho de um veículo durante o jogo.
 */
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
        if (precoEmFichasCorrida > 0) {
            this.precoEmFichasCorrida = precoEmFichasCorrida;
        }
    }

    // Método abstrato para mostrar os detalhes do item
    public abstract void mostrarDetalhes();

}

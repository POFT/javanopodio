package Itens;

/**
 * A classe Habilidade é uma subclasse da classe abstrata ItemCorrida e tem como objetivo representar um item no jogo que proporciona aumento de potência para o veículo.
 */
public class Habilidade extends ItemCorrida{

    private int aumentoPotencia;

    public Habilidade(String nome, int precoEmFichasCorrida, int aumentoPotencia) {
        super(nome, precoEmFichasCorrida);
        this.aumentoPotencia = aumentoPotencia;
    }

    // Getters e Setters
    public int getAumentoPotencia() {
        return aumentoPotencia;
    }

    public void setAumentoPotencia(int aumentoPotencia) {
        if (aumentoPotencia > 0) {
            this.aumentoPotencia = aumentoPotencia;
        }
    }


    /**
     * Método para apresentar habilidades
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("Nome da Habilidade: " + this.getNome());
        System.out.println("Aumento de Potência: " + this.aumentoPotencia);
        System.out.println("Preço em Fichas de Corrida: " + this.getPrecoEmFichasCorrida());
    }
}

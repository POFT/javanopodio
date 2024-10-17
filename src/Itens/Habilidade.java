package Itens;

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
        this.aumentoPotencia = aumentoPotencia;
    }

    // Implementação do método mostrarDetalhes
    @Override
    public void mostrarDetalhes() {
        System.out.println("Nome da Habilidade: " + getNome());
        System.out.println("Preço em Fichas de Corrida: " + getPrecoEmFichasCorrida());
        System.out.println("Aumento de Potência: " + this.aumentoPotencia);
    }
}

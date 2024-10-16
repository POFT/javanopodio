package Itens;

public abstract class ItemCorrida {

    private String nome;
    private int precoEmFichasCorrida;

    public ItemCorrida(String nome, int precoEmFichasCorrida) {
        this.nome = nome;
        this.precoEmFichasCorrida = precoEmFichasCorrida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrecoEmFichasCorrida(int precoEmFichasCorrida) {
        return precoEmFichasCorrida;
    }

    public void setPrecoEmFichasCorrida(int precoEmFichasCorrida) {
        this.precoEmFichasCorrida = precoEmFichasCorrida;
    }
}

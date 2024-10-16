package Itens;

public class Habilidade extends ItemCorrida{

    private int aumentoPotencia;

    public Habilidade(String nome, int precoEmFichasCorrida, int aumentoPotencia) {
        super(nome, precoEmFichasCorrida);
        this.aumentoPotencia = aumentoPotencia;
    }


    public int getAumentoPotencia() {
        return aumentoPotencia;
    }

    public void setAumentoPotencia(int aumentoPotencia) {
        this.aumentoPotencia = aumentoPotencia;
    }

    @Override
    public void mostrarDetalhes(){
        super.mostrarDetalhes();
        System.out.println("Aumento de Potencia: " + this.aumentoPotencia);
    }
}

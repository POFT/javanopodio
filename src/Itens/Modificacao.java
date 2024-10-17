package Itens;

import java.util.ArrayList;

public class Modificacao extends ItemCorrida {

    private String nome;
    private int precoEmFichasCorrida;
    private int diminuicaoDesgaste;
    private double diminuicaoPeso;
    private ArrayList<String> carrosPermitidos; // guardar o tipo de carros que podem/sabem usar dada reparacao

    public Modificacao(String nome, int precoEmFichasCorrida, int diminuicaoDesgaste, double diminuicaoPeso, ArrayList<String> carrosPermitidos) {
        super(nome, precoEmFichasCorrida);
        this.diminuicaoDesgaste = diminuicaoDesgaste;
        this.diminuicaoPeso = diminuicaoPeso;
        this.carrosPermitidos = carrosPermitidos;
    }




    // Getters e Setters
    public int getDiminuicaoDesgaste() {
        return diminuicaoDesgaste;
    }

    public void setDiminuicaoDesgaste(int diminuicaoDesgaste) {
        this.diminuicaoDesgaste = diminuicaoDesgaste;
    }

    public double getDiminuicaoPeso() {
        return diminuicaoPeso;
    }

    public void setDiminuicaoPeso(double diminuicaoPeso) {
        this.diminuicaoPeso = diminuicaoPeso;
    }

    public ArrayList<String> getCarrosPermitidos() {
        return carrosPermitidos;
    }

    public void setCarrosPermitidos(ArrayList<String> carrosPermitidos) {
        this.carrosPermitidos = carrosPermitidos;
    }



    @Override
    public void mostrarDetalhes() {
        System.out.println("Nome da Modificação: " + getNome());
        System.out.println("Preço em Fichas de Corrida: " + getPrecoEmFichasCorrida());
        System.out.println("Diminuição de Desgaste: " + this.diminuicaoDesgaste);
        System.out.println("Diminuição de Peso: " + this.diminuicaoPeso);
        System.out.println("Carros Permitidos: " + String.join(", ", this.carrosPermitidos));
    }
}


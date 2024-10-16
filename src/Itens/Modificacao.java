package Itens;

import java.util.ArrayList;

public class Modificacao extends ItemCorrida {
    private String nome;
    private int precoEmFichasCorrida;
    private int diminuicaoDesgaste;
    private double diminuicaoPeso;
    private ArrayList<String> carrosPermitidos; // guardar o tipo de carros que podem/sabem usar dada reparacao

    public Modificacao(String nome, int precoEmFichasCorrida, String nome1, int precoEmFichasCorrida1, int diminuicaoDesgaste, double diminuicaoPeso, ArrayList<String> carrosPermitidos) {
        super(nome, precoEmFichasCorrida);
        this.nome = nome1;
        this.precoEmFichasCorrida = precoEmFichasCorrida1;
        this.diminuicaoDesgaste = diminuicaoDesgaste;
        this.diminuicaoPeso = diminuicaoPeso;
        this.carrosPermitidos = carrosPermitidos;
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
    public void mostrarDetalhes(){
        super.mostrarDetalhes();
        System.out.println("Desgaste: " + this.diminuicaoDesgaste);
        System.out.println("Peso: " + this.diminuicaoPeso);
        System.out.println("Carros Permitidos: " + this.carrosPermitidos);
    }
}


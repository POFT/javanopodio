package Itens;

import java.util.ArrayList;

public class Modificacao extends ItemCorrida {

    private int diminuicaoDesgaste;
    private double diminuicaoPeso;
    private ArrayList<String> carrosPermitidos; // guardar o tipo de carros que podem/sabem usar dada reparacao

    public Modificacao(String nome, int precoEmFichasCorrida, int diminuicaoDesgaste, double diminuicaoPeso) {
        super(nome, precoEmFichasCorrida);
        this.diminuicaoDesgaste = diminuicaoDesgaste;
        this.diminuicaoPeso = diminuicaoPeso;
        this.carrosPermitidos = new ArrayList<>();
    }




    // GETTERS & SETTERS
    public int getDiminuicaoDesgaste() {
        return diminuicaoDesgaste;
    }

    public void setDiminuicaoDesgaste(int diminuicaoDesgaste) {
        if (diminuicaoDesgaste >= 0) {
            this.diminuicaoDesgaste = diminuicaoDesgaste;
        }
    }

    public double getDiminuicaoPeso() {
        return diminuicaoPeso;
    }

    public void setDiminuicaoPeso(double diminuicaoPeso) {
        if (diminuicaoPeso >= 0) {
            this.diminuicaoPeso = diminuicaoPeso;
        }
    }

    public ArrayList<String> getCarrosPermitidos() {
        return carrosPermitidos;
    }

    public void setCarrosPermitidos(ArrayList<String> carrosPermitidos) {
        this.carrosPermitidos = carrosPermitidos;
    }


    /**
     * Método para apresentar as modificações
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("Nome da Modificação: " + this.getNome());
        System.out.println("Preço em Fichas de Corrida: " + this.getPrecoEmFichasCorrida());
        System.out.println("Diminuição de Desgaste: " + this.diminuicaoDesgaste);
        System.out.println("Diminuição de Peso: " + this.diminuicaoPeso + " kg");
        if (!carrosPermitidos.isEmpty()) {
            System.out.println("Carros Permitidos:");
            for (String tipoCarro : carrosPermitidos) {
                System.out.println("- " + tipoCarro);
            }
        } else {
            System.out.println("Nenhum carro permitido para esta modificação.");
        }
    }
}


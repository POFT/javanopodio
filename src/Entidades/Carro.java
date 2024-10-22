package Entidades;

import Itens.Modificacao;
import Itens.TipoCarro;

import java.util.ArrayList;

/**
 * A Classe Carro é uma subclasse da classe abstrata Veiculo.
 */
public class Carro extends Veiculo {

    // ATTRIBUTES
    private TipoCarro tipoCarro;
    private ArrayList<Modificacao> kitCorrida;

    // CONSTRUCTUR
    public Carro(String marca, String modelo, int potenciaCV, double pesokg,int desgaste, int preco, TipoCarro tipoCarro) {
        super(marca, modelo, potenciaCV, pesokg, desgaste, preco);
        this.tipoCarro = tipoCarro;
        this.kitCorrida = new ArrayList<>();
    }


    public TipoCarro getTipoCarro() {
        return tipoCarro;
    }

    public void setTipoCarro(TipoCarro tipoCarro) {
        this.tipoCarro = tipoCarro;
    }

    public ArrayList<Modificacao> getKitCorrida() {
        return kitCorrida;
    }

    public void setKitCorrida(ArrayList<Modificacao> kitCorrida) {
        this.kitCorrida = kitCorrida;
    }

    // ADICIONAR MODIFICAÇÃO AO KITCORRIDA
    public void adicionarModificacao(Modificacao modificacao) {
        if (modificacao.getCarrosPermitidos().contains(this.tipoCarro)) {
            this.kitCorrida.add(modificacao);
            System.out.println("Modificação " + modificacao.getNome() + " aplicada com sucesso.");
        } else {
            System.out.println("Esta modificação não pode ser aplicada a este tipo de carro.");
        }
    }


    /**
     * Método mostrarDetalhes para apresentar os detalhes do Carro.
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("[Preço: " + this.getPreco() + "] ");
        System.out.print("Marca: " + this.getMarca() + " | ");
        System.out.print("Modelo: " + this.getModelo() + " | ");
        System.out.print("Potência: " + this.getPotenciaCV() + "cv | ");
        System.out.print("Peso: " + this.getPesokg() + "kg | ");
        System.out.print("Desgaste: " + this.getDesgaste()+ " | ");
        System.out.print("Tipo de Carro: " + this.tipoCarro);
        System.out.println(" ");
    }
}

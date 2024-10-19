package Entidades;

import Itens.Modificacao;
import Itens.TipoCarro;

import java.util.ArrayList;

public class Carro extends Veiculo {

    private TipoCarro tipoCarro;
    private ArrayList<Modificacao> kitCorrida;

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


    @Override
    public void mostrarDetalhes() {
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Potência: " + this.getPotenciaCV() + " CV");
        System.out.println("Tipo de Carro: " + this.tipoCarro);
        System.out.println("Preço: " + this.getPreco());
        if (!kitCorrida.isEmpty()) {
            System.out.println("Modificações Aplicadas:");
            for (Modificacao mod : kitCorrida) {
                mod.mostrarDetalhes();
            }
        } else {
            System.out.println("Nenhuma modificação aplicada.");
        }
    }
}

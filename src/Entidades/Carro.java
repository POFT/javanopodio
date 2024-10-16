package Entidades;

import Itens.TipoCarro;

import java.util.ArrayList;

public class Carro extends Veiculo {

    private TipoCarro tipoCarro;
    private ArrayList<Modificacao> kitCorrida;

    public Carro(String marca, String modelo, int potenciaCV, double pesokg, int desgaste, int preco, TipoCarro tipoCarro) {
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

    public void adicionarModificacao (Modificacao modificacao){
        this.kitCorrida.add(modificacao);
    }


    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("Tipo Carro: " + this.tipoCarro);
        System.out.println("Modificações: " + this.kitCorrida.size() + " no total");

    }
}

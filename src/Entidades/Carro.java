package Entidades;

import Itens.Modificacao;
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

    // Método para adicionar modificação ao kit
    public void adicionarModificacao(Modificacao modificacao) {
        // Verificação para garantir que a modificação pode ser aplicada ao tipo de carro
        if (modificacao.getCarrosPermitidos().contains(this.tipoCarro.toString())) {
            this.kitCorrida.add(modificacao);
        } else {
            System.out.println("Esta modificação não pode ser aplicada a este tipo de carro.");
        }
    }


    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("Tipo de Carro: " + this.tipoCarro);

        if (this.kitCorrida.isEmpty()) {
            System.out.println("Nenhuma modificação aplicada.");
        } else {
            System.out.println("Modificações instaladas (" + this.kitCorrida.size() + "): ");
            for (Modificacao modificacao : this.kitCorrida) {
                modificacao.mostrarDetalhes();  // Chama o método mostrarDetalhes() da modificação
            }
        }
    }
}

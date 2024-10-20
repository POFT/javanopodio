package Entidades;

import Itens.Habilidade;

import java.util.ArrayList;

public class Mota extends Veiculo {

    private ArrayList<Habilidade> habilidadesMota;

    public Mota(String marca, String modelo, int potenciaCV, double pesokg,int desgaste, int preco) {
        super(marca, modelo, potenciaCV, pesokg, desgaste, preco);
        this.habilidadesMota = new ArrayList<>();
    }

    public ArrayList<Habilidade> getHabilidadesMota() {
        return habilidadesMota;
    }

    public void setHabilidadesMota(ArrayList<Habilidade> habilidadesMota) {
        this.habilidadesMota = habilidadesMota;
    }

    public void adicionarHabilidade(Habilidade habilidade) {
        habilidadesMota.add(habilidade);
        System.out.println("Habilidade " + habilidade.getNome() + " adicionada com sucesso.");
    }



    @Override
    public void mostrarDetalhes() {
        System.out.println("[Preço: " + this.getPreco() + "] ");
        System.out.print("Marca: " + this.getMarca() + " | ");
        System.out.print("Modelo: " + this.getModelo() + " | ");
        System.out.print("Potência: " + this.getPotenciaCV() + "cv | ");
        System.out.print("Peso: " + this.getPesokg() + "kg | ");
        System.out.print("Desgaste: " + this.getDesgaste() + " | ");
        System.out.println(" ");
    }
}

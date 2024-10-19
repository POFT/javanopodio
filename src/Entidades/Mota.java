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
        System.out.println("Marca: " + this.getMarca() + " | Modelo: " + this.getModelo() + " | Potência: " + this.getPotenciaCV() + " CV");
        System.out.println("[Preço: " + this.getPreco() + "]");
        if (this.getDesgaste() > 0){
            System.out.println("Desgaste: " + this.getDesgaste());
        }
    }
}

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
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Potência: " + this.getPotenciaCV() + " CV");
        if (!habilidadesMota.isEmpty()) {
            System.out.println("Habilidades Aplicadas:");
            for (Habilidade hab : habilidadesMota) {
                hab.mostrarDetalhes();
            }
        } else {
            System.out.println("Nenhuma habilidade aplicada.");
        }
    }
}

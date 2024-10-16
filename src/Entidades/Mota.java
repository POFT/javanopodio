package Entidades;

import java.util.ArrayList;

public class Mota extends Veiculo {

    private ArrayList<Habilidade> habilidadesMota;

    public Mota(String marca, String modelo, int potenciaCV, double pesokg, int desgaste, int preco) {
        super(marca, modelo, potenciaCV, pesokg, desgaste, preco);
        this.habilidadesMota = new ArrayList<Habilidade>();
    }

    public ArrayList<Habilidade> getHabilidadesMota() {
        return habilidadesMota;
    }

    public void setHabilidadesMota(ArrayList<Habilidade> habilidadesMota) {
        this.habilidadesMota = habilidadesMota;
    }

    public void adicionarHabilidade(Habilidade habilidade){
        habilidadesMota.add(habilidade);
    }

    @Override
    public void mostrarDetalhes(){
        super.mostrarDetalhes();
        System.out.println("Habilidades: " + this.habilidadesMota.size() + " no total");
    }
}

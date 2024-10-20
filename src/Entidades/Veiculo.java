package Entidades;

import Itens.ItemCorrida;
import Itens.TipoCarro;

import java.util.ArrayList;

public abstract class Veiculo {


    // ATRIBUTOS DA CLASS:
    private String marca;
    private String modelo;
    private int potenciaCV;
    private double pesokg;
    private int desgaste;
    private int preco;
    private ArrayList<ItemCorrida> inventario;

    public Veiculo(String marca, String modelo, int potenciaCV, double pesokg, int desgaste, int preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.potenciaCV = potenciaCV;
        this.pesokg = pesokg;
        this.desgaste = desgaste;
        this.preco = preco;
        this.inventario = new ArrayList<>();
    }


    // GETTERS & SETTERS
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPotenciaCV() {
        return potenciaCV;
    }

    public void setPotenciaCV(int potenciaCV) {
        if (potenciaCV > 0) {
            this.potenciaCV = potenciaCV;
        }
    }

    public double getPesokg() {
        return pesokg;
    }

    public void setPesokg(double pesokg) {
        if (pesokg > 0) {
            this.pesokg = pesokg;
        }
    }

    public int getDesgaste() {
        return desgaste;
    }

    public void setDesgaste(int desgaste) {
        if (desgaste >= 0) {
            this.desgaste = desgaste;
        }
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        if (preco > 0) {
            this.preco = preco;
        }
    }

    public ArrayList<ItemCorrida> getInventario() {
        return inventario;
    }




    // MÉTODO PARA ADICIONAR
    public void adicionarItem(ItemCorrida item) {
        inventario.add(item);
    }

    // MÉTODO PARA REMOVER
    public void removerItem(ItemCorrida item) {
        inventario.remove(item);
    }


    //METODO PRINT DE TODOS OS  DETALHES DO VEICULO
    public abstract void mostrarDetalhes();






    // VALIDAR MÉTODO PARA AUMENTAR DESGASTE DO VEÍCULO
    public void aumentarDesgaste(int valor) {
        this.desgaste += valor;
    }

    // VALIDAR MÉTODO PARA AUMENTAR POTÊNCIA DO VEÍCULO
    public void aumentarPotencia(int valor) {
        this.potenciaCV += valor;
    }

    // VALIDAR MÉTODO PARA REDUZIR PESO DO VEÍCULO
    public void reduzirPeso(double valor) {
        if (this.pesokg - valor >= 10) {
            this.pesokg -= valor;
        } else {
            System.out.println("Ainda não inventaram a tecnologia para reduzir mais peso.");
        }
    }

}

package Entidades;

import Itens.ItemCorrida;
import Itens.TipoCarro;

import java.util.ArrayList;

/**
 * A Classe Veiculo serve como uma base abstrata para todos os tipos de veículos no jogo,
 * permite a criação de diferentes veículos, como carros e motos.
 */
public abstract class Veiculo {

    // ATTRIBUTES
    private String marca;
    private String modelo;
    private int potenciaCV;
    private double pesokg;
    private int desgaste;
    private int preco;
    private ArrayList<ItemCorrida> inventario;

    // CONSTRUCTUR
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

    /**
     * Método para adicionar item ao inventário (item é um objeto da classe ItemCorrida),
     * @param item
     */
    public void adicionarItem(ItemCorrida item) {
        inventario.add(item);
    }

    /**
     * Método para remover item do inventário,
     * @param item
     */
    public void removerItem(ItemCorrida item) {
        inventario.remove(item);
    }

    /**
     * Método mostrarDetalhes para apresentar os detalhes do Veiculo.
     *  Nas subclasses será feito override para imprimir os detalhes específicos.
     */
    public abstract void mostrarDetalhes();

    /**
     * Método para aumentarDesgaste durante a corrida,
     * é chamado na classe Piloto no método corrida,
     * @param valor que será adicionado ao desgaste atual
     */
    public void aumentarDesgaste(int valor) {
        this.desgaste += valor;
    }

    /**
     * Método para aumentar a potencia do veiculo,
     * @param valor
     * é utilizaddo na classe Piloto método usarItem/aplicarEfeitos
     */
    public void aumentarPotencia(int valor) {
        this.potenciaCV += valor;
    }

    /**
     * Método para reduzir o peso do veiculo,
     * @param valor
     * é utilizaddo na classe Piloto método usarItem/aplicarEfeitos.
     */
    public void reduzirPeso(double valor) {
        if (this.pesokg - valor >= 10) {
            this.pesokg -= valor;
        } else {
            System.out.println("Ainda não inventaram a tecnologia para reduzir mais peso.");
        }
    }

}

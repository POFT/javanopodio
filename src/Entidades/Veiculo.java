package Entidades;

public abstract class Veiculo {


    // ATRIBUTOS DA CLASS:
    private String marca;
    private String modelo;
    private int potenciaCV;
    private double pesokg;
    private int desgaste;
    private int preco;

    public Veiculo(String marca, String modelo, int potenciaCV, double pesokg, int desgaste, int preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.potenciaCV = potenciaCV;
        this.pesokg = pesokg;
        this.desgaste = desgaste;
        this.preco = preco;
    }

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
        this.potenciaCV = potenciaCV;
    }

    public double getPesokg() {
        return pesokg;
    }

    public void setPesokg(double pesokg) {
        this.pesokg = pesokg;
    }

    public int getDesgaste() {
        return desgaste;
    }

    public void setDesgaste(int desgaste) {
        this.desgaste = desgaste;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    //METODO PRINT DE TODOS OS  DETALHES DO VEICULO
    public void mostrarDetalhes(){
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Potencia: " + this.potenciaCV);
        System.out.println("Peso(Kg): " + this.pesokg)  ;
        System.out.println("Desgaste: " + this.desgaste);
        System.out.println("Preço: " + this.preco);
    }


}

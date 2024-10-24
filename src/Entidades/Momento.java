package Entidades;

/**
 * A Classe Momento tem como objetivo representar os eventos específicos ou características de uma pista.
 */
public class Momento {

    private String nome;
    private double atrasoPeso;
    private double atrasoPotencia;

    public Momento(String nome, double atrasoPeso, double atrasoPotencia) {
        this.nome = nome;
        this.atrasoPeso = atrasoPeso;
        this.atrasoPotencia = atrasoPotencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAtrasoPeso() {
        return atrasoPeso;
    }

    public void setAtrasoPeso(double atrasoPeso) {
        this.atrasoPeso = atrasoPeso;
    }

    public double getAtrasoPotencia() {
        return atrasoPotencia;
    }

    public void setAtrasoPotencia(double atrasoPotencia) {
        this.atrasoPotencia = atrasoPotencia;
    }

    /**
     * Método para mostrar os momentos da pista
     * @return
     */
    @Override
    public String toString() {
        return "Momento: " + nome +
                ", Atraso Peso: " + atrasoPeso +
                ", Atraso Potência: " + atrasoPotencia;
    }
}

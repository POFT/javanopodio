package Entidades;

import java.util.ArrayList;

public class Pista {
    private String nome;
    private double tempo;
    private double tempoRecordeSeg;
    private double distanciaVoltaM;
    private int quantidadeVoltas;
    private ArrayList<Momento> momentosPista;

    public Pista(String nome, double tempo, double tempoRecordeSeg, double distanciaVoltaM, int quantidadeVoltas) {
        this.nome = nome;
        this.tempo = tempo;
        this.tempoRecordeSeg = tempoRecordeSeg;
        this.distanciaVoltaM = distanciaVoltaM;
        this.quantidadeVoltas = quantidadeVoltas;
        this.momentosPista = new ArrayList<>();
    }


    // GETTERS & SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public double getTempoRecordeSeg() {
        return tempoRecordeSeg;
    }

    public void setTempoRecordeSeg(double tempoRecordeSeg) {
        this.tempoRecordeSeg = tempoRecordeSeg;
    }

    public double getDistanciaVoltaM() {
        return distanciaVoltaM;
    }

    public void setDistanciaVoltaM(double distanciaVoltaM) {
        this.distanciaVoltaM = distanciaVoltaM;
    }

    public int getQuantidadeVoltas() {
        return quantidadeVoltas;
    }

    public void setQuantidadeVoltas(int quantidadeVoltas) {
        this.quantidadeVoltas = quantidadeVoltas;
    }

    public ArrayList<Momento> getMomentosPista() {
        return momentosPista;
    }

    public void setMomentosPista(ArrayList<Momento> momentosPista) {
        this.momentosPista = momentosPista;
    }


    // MÉTODO PARA ADICIONAR MOMENTO DA PISTA
    public void adicionarMomento(Momento momento) {
        this.momentosPista.add(momento);
    }

    // MÉTODO PARA REMOVER MOMENTO DA PISTA
    public void removerMomento(Momento momento) {
        this.momentosPista.remove(momento);
    }

    // METODO PARA VALIDAR QUANTIDADE DE MOMENTOS
    public boolean temMomentosSuficientes() {
        return this.momentosPista.size() >= 5;
    }


    // METODO PARA LISTAR MOMENTOS
    public void listarMomentos() {
        System.out.println("Momentos da Pista " + nome + ":");
        for (Momento momento : momentosPista) {
            System.out.println("Momento: " + momento.getNome() + ", Atraso Peso: " + momento.getAtrasoPeso() +
                    ", Atraso Potência: " + momento.getAtrasoPotencia());
        }
    }

    // Método para imprimir os detalhes da pista
    public void imprimirDetalhes() {
        System.out.println("Nome da pista: " + this.nome);
        System.out.println("Distância por volta: " + this.distanciaVoltaM + " metros");
        System.out.println("Número de voltas: " + this.quantidadeVoltas);
        System.out.println("Tempo recorde: " + this.tempoRecordeSeg + " segundos");

        double tempoTotal = tempoRecordeSeg * quantidadeVoltas;
        System.out.println("Tempo estimado total (com base no recorde): " + tempoTotal + " segundos");

        System.out.println("Momentos da pista: ");
        for (Momento momento : momentosPista) {
            System.out.println("- " + momento.getNome());
        }
    }
}

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


    // Getters e Setters
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

    // Método adicional para adicionar um momento à pista
    public void adicionarMomento(Momento momento) {
        this.momentosPista.add(momento);
    }

    // Método adicional para remover um momento da pista
    public void removerMomento(Momento momento) {
        this.momentosPista.remove(momento);
    }

    // Método para verificar se a pista tem momentos suficientes
    public boolean temMomentosSuficientes() {
        return this.momentosPista.size() >= 2;
    }

    // Método para imprimir os detalhes da pista
    public void imprimirDetalhes() {
        System.out.println("Nome da pista: " + this.nome);
        System.out.println("Distância por volta: " + this.distanciaVoltaM + " metros");
        System.out.println("Número de voltas: " + this.quantidadeVoltas);
        System.out.println("Tempo recorde: " + this.tempoRecordeSeg + " segundos");

        System.out.println("Momentos da pista: ");
        for (Momento momento : momentosPista) {
            System.out.println("- " + momento.getNome());
        }
    }
}

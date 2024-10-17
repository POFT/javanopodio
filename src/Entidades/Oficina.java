package Entidades;

import Itens.ItemCorrida;
import Itens.TipoCarro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Oficina {

    private ArrayList<Veiculo> garagem;
    private ArrayList<ItemCorrida> stock;

    // Construtor
    public Oficina() {
        this.garagem = new ArrayList<>();
        this.stock = new ArrayList<>();
    }

    // Método para carregar os veículos da garagem a partir do arquivo CSV
    public void carregarVeiculos(String caminhoArquivo) {
        try {
            File arquivo = new File(caminhoArquivo);
            Scanner scanner = new Scanner(arquivo);
            boolean primeiraLinha = true;

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();

                // Ignorar a primeira linha (cabeçalho)
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                // Separar os valores da linha
                String[] dados = linha.split(";");

                String tipo = dados[0];
                String marca = dados[1];
                String modelo = dados[2];
                int potenciaCV = Integer.parseInt(dados[3]);
                double pesoKg = Double.parseDouble(dados[4]);
                int preco = Integer.parseInt(dados[5]);

                // Verificar o tipo do veículo e instanciar o objeto correspondente
                if (tipo.equalsIgnoreCase("Carro")) {
                    TipoCarro tipoCarro = TipoCarro.valueOf(dados[6].toUpperCase());
                    Carro carro = new Carro(marca, modelo, potenciaCV, pesoKg, 0, preco, tipoCarro);
                    garagem.add(carro);
                } else if (tipo.equalsIgnoreCase("Mota")) {
                    Mota mota = new Mota(marca, modelo, potenciaCV, pesoKg, 0, preco);
                    garagem.add(mota);
                }
            }

            scanner.close();
            System.out.println("Veículos carregados com sucesso.");
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado. " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir o tipo de carro: " + e.getMessage());
        }
    }

    // Métodos relacionados ao stock de itens podem ser adicionados conforme necessidade
    public ArrayList<Veiculo> getGaragem() {
        return garagem;
    }

    public void setGaragem(ArrayList<Veiculo> garagem) {
        this.garagem = garagem;
    }

    public ArrayList<ItemCorrida> getStock() {
        return stock;
    }

    public void setStock(ArrayList<ItemCorrida> stock) {
        this.stock = stock;
    }
}

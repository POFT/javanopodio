package Jogo;

import Entidades.*;
import Itens.Habilidade;
import Itens.Modificacao;
import Itens.TipoCarro;
import java.util.Scanner;

public class Jogo {


    /**
     * Método para criar um Piloto (Nome, Dificuldade/Fichas)
     * @return
     */
    public Piloto criarPiloto() {
        System.out.println("\n******* MENU CRIAÇÃO DE JOGADOR *******");

        //METODO AUXILIAR DEFINIR NOME DO PILOTO:
        String nomeInserido = definirNomePiloto();

        //METODO AUXILIAR DEFINIR DIFICULDE:
        int dificuldadeEscolhida = escolherDificuldade();

        //METODO AUXILIAR DEFINIR FICHAS:
        int fichasIniciais = atribuirFichas(dificuldadeEscolhida);


        System.out.println("\n[RESUMO DA CRIAÇÃO DE JOGADOR]");
        System.out.println("> Piloto: " + nomeInserido);
        if(dificuldadeEscolhida == 1){
            System.out.println("> Dificuldade: " + dificuldadeEscolhida + ". Fácil");
        } else if (dificuldadeEscolhida == 2){
            System.out.println("> Dificuldade: " + dificuldadeEscolhida + ". Díficil");
        }
        System.out.println("> Fichas de corrida: " + fichasIniciais);
        System.out.println("*****************************************");

        return new Piloto(nomeInserido,fichasIniciais, null,0);
    }


    //METODO AUXILIAR DEFINIR NOME DO PILOTO
    public String definirNomePiloto() {
        Scanner input = new Scanner(System.in);
        String nome = "";

        // LOOP ATÉ NOME VÁLIDO
        while (true) {
            System.out.println("\n[NOME] ");
            System.out.println("Qual é o teu nome?");
            System.out.print("> ");
            nome = input.nextLine().trim(); // Remove espaços em branco no início e no final

            // Validação: nome não pode ser vazio
            if (!nome.isEmpty()) {
                break; // Nome válido
            } else {
                System.out.println("Nome inválido. Por favor, tenta novamente.");
            }
        }
        return nome;
    }

    //METODO AUXILIAR DEFINIR DIFICULDADE
    public int escolherDificuldade() {
        Scanner input = new Scanner(System.in);
        int dificuldade = 0;
        boolean opcaoValida = false;

        while (!opcaoValida) {
            try {
                System.out.println("\n[DIFICULDADE] ");
                System.out.println("Escolha a dificuldade inserindo a opção numérica correspondente: ");
                System.out.println("[1] Fácil - 2000 fichas de corrida");
                System.out.println("[2] Difícil - 1500 fichas de corrida");
                System.out.print("> ");
                dificuldade = Integer.parseInt(input.nextLine());

                if (dificuldade == 1 || dificuldade == 2) {
                    opcaoValida = true;
                } else {
                    System.out.println("Opção inválida! Escolha entre [1] ou [2].");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Escolha entre [1] ou [2].");
            }
        }
        return dificuldade;
    }

    //METODO AUXILIAR DEFINIR FICHAS
    public int atribuirFichas(int dificuldade) {
        int fichasCorrida = 0;

        if (dificuldade == 1) {
            fichasCorrida = 2000; // Fácil
        } else if (dificuldade == 2) {
            fichasCorrida = 1500; // Difícil
        } else {
            System.out.println("ERRO DO BOT!");
        }

        return fichasCorrida;
    }

    // METODO PARA MENU OFICINA/DECISÃO
    public void decisaoMenuOficina (Piloto piloto, Oficina oficina){
        Scanner input = new Scanner(System.in);

        int opcao= 0;
        do {
            System.out.println("\n[DECISÃO]");
            System.out.println("[1]. OFICINA GARAGEM");
            System.out.println("[2]. OFICINA ITENS");
            System.out.println("[3]. PILOTO ITENS");
            System.out.println("[4]. PISTAS/CONTINUAR");
            System.out.print("> ");
            opcao = input.nextInt();
            switch (opcao){
                case 1:
                    oficina.venderVeiculo(piloto);
                    break;
                case 2:
                    oficina.venderItem(piloto);
                    break;
                case 3:
                    piloto.usarItem(2);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }while(opcao!=4);
    }


    // METODO PARA MENU COMPETIR/DECISÃO
    public void decisaoMenuCompetir (Piloto piloto, Pista pista){
        Scanner input = new Scanner(System.in);

        int opcao= 0;
        do {
            System.out.println("\n[DECISÃO]");
            System.out.println("[1]. COMPETIR");
            System.out.println("[2]. PISTAS/VOLTAR");
            System.out.print("> ");
            opcao = input.nextInt();
            switch (opcao){
                case 1:
                    piloto.corrida(pista);
                    pista.listarMomentos();
                    break;
                case 2:// VOLTAR
                    System.out.println("___________________________");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }while(opcao != 2);
    }


    // METODO PARA ESPERAR ATE USER PRESSIONE ENTER
    public static void esperarEnter(Scanner input) {
        System.out.println("\n[Enter] para continuar...");
        input.nextLine();
    }




    public void simuladorCorridas(Piloto piloto) {

        Oficina oficina = new Oficina();

        // Instanciar veículos (16 no total, 10 carros e 6 motas)
        Carro carro1 = new Carro("Toyota", "GR86", 234, 1276, 0, 3000, TipoCarro.GT);
        Carro carro2 = new Carro("Mercedes", "AMG A45 S 4Matic", 421, 1455, 0, 125000, TipoCarro.GT);
        Carro carro3 = new Carro("BMW", "M5 CS", 625, 1825, 0, 160000, TipoCarro.GT);
        Carro carro4 = new Carro("Ferrari", "SF90 Stradale", 1000, 1435, 0, 300000, TipoCarro.GT);
        Carro carro5 = new Carro("Ferrari", "F8", 720, 1435, 0, 200000, TipoCarro.F1); //*
        Carro carro6 = new Carro("McLaren", "720S", 710, 1419, 0, 300000, TipoCarro.F1);
        Carro carro7 = new Carro("Red Bull Racing", "RB15", 1000, 1419, 0, 1000, TipoCarro.F1); //*
        Carro carro8 = new Carro("Ford", "Mustang", 450, 1650, 0, 60000, TipoCarro.RALLY);
        Carro carro9 = new Carro("Chevrolet", "Camaro", 650, 1690, 0, 66000, TipoCarro.RALLY);
        Carro carro10 = new Carro("Chevrolet", "Camaro", 650, 1690, 0, 66000, TipoCarro.RALLY);

        Mota mota1 = new Mota("Yamaha", "MT-125", 250, 120, 0, 2000);
        Mota mota2 = new Mota("Yamaha", "R1", 200, 201, 0, 12000);
        Mota moto3 = new Mota("Honda", "CBR1000", 217, 201, 0, 13000);
        Mota moto4 = new Mota("Kawasaki", "Ninja 1000", 300, 235, 0, 25000);
        Mota moto5 = new Mota("Honda", "CBR650R", 95, 209, 0, 5000);
        Mota moto6 = new Mota("Aprilia", "RS 457", 50, 159, 0, 4000);

        // Adicionar veículos à garagem da oficina
        oficina.getGaragem().add(carro1);
        oficina.getGaragem().add(carro2);
        oficina.getGaragem().add(carro3);
        oficina.getGaragem().add(carro4);
        oficina.getGaragem().add(carro5);
        oficina.getGaragem().add(carro6);
        oficina.getGaragem().add(carro7);
        oficina.getGaragem().add(carro8);
        oficina.getGaragem().add(carro9);
        oficina.getGaragem().add(carro10);
        oficina.getGaragem().add(mota1);
        oficina.getGaragem().add(mota2);
        oficina.getGaragem().add(moto3);
        oficina.getGaragem().add(moto4);
        oficina.getGaragem().add(moto5);
        oficina.getGaragem().add(moto6);

        // Instanciar 12 itens
        Modificacao mod1 = new Modificacao("Instalar escape Nrf", 200, 100, 50);
        Modificacao mod2 = new Modificacao("Instalar escape Akrapovic", 100, 50, 50);
        Modificacao mod3 = new Modificacao("Instalar travões Brembo", 200, 100, 50);
        Modificacao mod4 = new Modificacao("Aumentar Entradas Ar", 500, 0, 300);
        Modificacao mod5 = new Modificacao("Mudar filtros do motor", 100, 100, 0);
        Modificacao mod6 = new Modificacao("Mudar oleo", 100, 100, 0);

        Habilidade habilidade1 = new Habilidade("Turbo Boost", 100, 50);
        Habilidade habilidade2 = new Habilidade("Nitro Injection", 150, 70);
        Habilidade habilidade3 = new Habilidade("Drift Mastery", 120, 40);
        Habilidade habilidade4 = new Habilidade("Suspensão Avançada", 90, 30);
        Habilidade habilidade5 = new Habilidade("Aerodinâmica Pro", 110, 45);
        Habilidade habilidade6 = new Habilidade("Pneus de Alta Performance", 130, 55);

        // Adicionar itens ao stock da oficina
        oficina.getStock().add(mod1);
        oficina.getStock().add(mod2);
        oficina.getStock().add(mod3);
        oficina.getStock().add(mod4);
        oficina.getStock().add(mod5);
        oficina.getStock().add(mod6);
        oficina.getStock().add(habilidade1);
        oficina.getStock().add(habilidade2);
        oficina.getStock().add(habilidade3);
        oficina.getStock().add(habilidade4);
        oficina.getStock().add(habilidade5);
        oficina.getStock().add(habilidade6);


        // Instanciar pistas
        Pista pista1 = new Pista("Autódromo do Estoril", 120.5, 118.3, 4000, 7);
        Pista pista2 = new Pista("Circuit de Monaco", 95.2, 92.8, 3500, 9);
        Pista pista3 = new Pista("Monza", 150.4, 133.0, 4500, 10);
        Pista pista4 = new Pista("Silverstone", 150.7, 148.5, 4000,10);
        Pista pista5 = new Pista("Circuit Gilles Villeneuve", 105.9, 104.3, 5800, 5);

        // Instanciar momentos para as pistas
        Momento momento1 = new Momento("Curva em U", 1.5, 0.8);
        Momento momento2 = new Momento("Gravilha na pista", 1.8, 1.8);
        Momento momento3 = new Momento("Curva em S", 2.0, 1.2);
        Momento momento4 = new Momento("Borracha na pista", 1.5, 1.5);
        Momento momento5 = new Momento("Reta", 0.0, 1.0);

        // Adicionar momentos às pistas (cada pista pode ter momentos diferentes)
        pista1.adicionarMomento(momento1);
        pista1.adicionarMomento(momento2);
        pista1.adicionarMomento(momento3);

        pista2.adicionarMomento(momento3);
        pista2.adicionarMomento(momento2);
        pista2.adicionarMomento(momento1);

        pista3.adicionarMomento(momento2);
        pista3.adicionarMomento(momento3);
        pista3.adicionarMomento(momento1);

        pista4.adicionarMomento(momento1);
        pista4.adicionarMomento(momento2);
        pista4.adicionarMomento(momento3);
        pista4.adicionarMomento(momento4);
        pista4.adicionarMomento(momento5);

        pista5.adicionarMomento(momento3);
        pista5.adicionarMomento(momento1);
        pista5.adicionarMomento(momento2);


        // REGRAS DO JOGO
        System.out.println("\n[REGRAS]");
        System.out.println("- Tens de vencer em 5 pistas para conquistar o pódio.");
        System.out.println("- Cada pista tem um recorde definido, o teu objetivo é bater esse recorde.");
        System.out.println("- Em competir em pistas ganhas fichas de corrida. ");
        System.out.println("- Se bates o record da pista recebes 100% do prémio (fichas de corrida), caso contrário apenas 50%. ");
        System.out.println("- Quando terminas uma pista, tens a opção de ir à Oficina.");
        System.out.println("- Por cada volta na pista o teu veículo ganha desgaste (+20).");
        System.out.println("- Na Oficina podes comprar itens(habilidades/modificações) ou um veículo novo.");
        System.out.println("- Para realizar compras na Oficina precisas de fichas de corrida.");
        System.out.println("\nO campeonato mais esperado começa agora!\n");

        System.out.println("\n[ENTRAR NA GARAGEM]");

        Scanner input = new Scanner(System.in);
        esperarEnter(input);
        // OBRIGAR O USER A COMPRAR VEICULO NO INICIO DO JOGO
        System.out.println("\n******* Veículos Disponíveis na Oficina *******");
        oficina.venderVeiculo(piloto);


        int opcao = 0;
        do {
            System.out.println("\n[CAMPEONATO JAVANOPODIO]\n");


            piloto.mostrarDetalhes();
            System.out.println("Veículo Atual:");
            Veiculo veiculoAtual = piloto.getVeiculoAtual();
            veiculoAtual.mostrarDetalhes();


            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Escolha a pista para ver mais detalhes:");
            System.out.println("[1]. " + pista1.getNome());
            System.out.println("[2]. " + pista2.getNome());
            System.out.println("[3]. " + pista3.getNome());
            System.out.println("[4]. " + pista4.getNome());
            System.out.println("[5]. " + pista5.getNome());
            System.out.println("_");
            System.out.println("[6]. OFICINA");
            System.out.print("> ");
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("\n[DETALHE PISTA 1]\n");
                    pista1.imprimirDetalhes();
                    decisaoMenuCompetir(piloto,pista1);
                    break;
                case 2:
                    System.out.println("\n[DETALHE PISTA 2]\n");
                    pista2.imprimirDetalhes();
                    decisaoMenuCompetir(piloto,pista2);
                    break;
                case 3:
                    System.out.println("\n[DETALHE PISTA 3]\n");
                    pista3.imprimirDetalhes();
                    decisaoMenuCompetir(piloto,pista3);
                    break;
                case 4:
                    System.out.println("\n[DETALHE PISTA 4]\n");
                    pista4.imprimirDetalhes();
                    decisaoMenuCompetir(piloto,pista4);
                    break;
                case 5:
                    System.out.println("\n[DETALHE PISTA 5]\n");
                    pista5.imprimirDetalhes();
                    decisaoMenuCompetir(piloto,pista5);
                    break;
                case  6:
                    decisaoMenuOficina(piloto,oficina);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao >= 1 || opcao <= 6);










    }

}

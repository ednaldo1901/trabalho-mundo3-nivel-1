package model;

import java.io.IOException;
import java.util.Scanner;

public class MenuPricipal {
    private static final PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
    private static final PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> gerenciarPessoaFisica();
                case 2 -> gerenciarPessoaJuridica();
                case 0 -> System.out.println("Saindo do programa...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Gerenciar Pessoa Física");
        System.out.println("2. Gerenciar Pessoa Jurídica");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void gerenciarPessoaFisica() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Pessoa Física ---");
            System.out.println("1. Inserir");
            System.out.println("2. Alterar");
            System.out.println("3. Excluir");
            System.out.println("4. Listar todas");
            System.out.println("5. Salvar em arquivo");
            System.out.println("6. Recuperar de arquivo");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> inserirPessoaFisica();
                case 2 -> alterarPessoaFisica();
                case 3 -> excluirPessoaFisica();
                case 4 -> listarPessoaFisica();
                case 5 -> salvarPessoaFisica();
                case 6 -> recuperarPessoaFisica();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void gerenciarPessoaJuridica() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Pessoa Jurídica ---");
            System.out.println("1. Inserir");
            System.out.println("2. Alterar");
            System.out.println("3. Excluir");
            System.out.println("4. Listar todas");
            System.out.println("5. Salvar em arquivo");
            System.out.println("6. Recuperar de arquivo");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> inserirPessoaJuridica();
                case 2 -> alterarPessoaJuridica();
                case 3 -> excluirPessoaJuridica();
                case 4 -> listarPessoaJuridica();
                case 5 -> salvarPessoaJuridica();
                case 6 -> recuperarPessoaJuridica();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void inserirPessoaFisica() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();

        PessoaFisica pessoa = new PessoaFisica(id, nome, cpf, idade);
        pessoaFisicaRepo.inserir(pessoa);
    }

    private static void alterarPessoaFisica() {
        System.out.print("ID da Pessoa Física a alterar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nova Idade: ");
        int idade = scanner.nextInt();

        PessoaFisica pessoa = new PessoaFisica(id, nome, cpf, idade);
        pessoaFisicaRepo.alterar(pessoa);
    }

    private static void excluirPessoaFisica() {
        System.out.print("ID da Pessoa Física a excluir: ");
        int id = scanner.nextInt();
        pessoaFisicaRepo.excluir(id);
    }

    private static void listarPessoaFisica() {
        System.out.println("\n--- Lista de Pessoas Físicas ---");
        pessoaFisicaRepo.obterTodos().forEach(PessoaFisica::exibir);
    }

    private static void salvarPessoaFisica() {
        System.out.print("Nome do arquivo para salvar: ");
        String arquivo = scanner.nextLine();
        try {
            pessoaFisicaRepo.persistir(arquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    private static void recuperarPessoaFisica() {
        System.out.print("Nome do arquivo para recuperar: ");
        String arquivo = scanner.nextLine();
        try {
            pessoaFisicaRepo.recuperar(arquivo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar o arquivo: " + e.getMessage());
        }
    }

    private static void inserirPessoaJuridica() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();

        PessoaJuridica pessoa = new PessoaJuridica(id, nome, cnpj);
        pessoaJuridicaRepo.inserir(pessoa);
    }

    private static void alterarPessoaJuridica() {
        System.out.print("ID da Pessoa Jurídica a alterar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo CNPJ: ");
        String cnpj = scanner.nextLine();

        PessoaJuridica pessoa = new PessoaJuridica(id, nome, cnpj);
        pessoaJuridicaRepo.alterar(pessoa);
    }

    private static void excluirPessoaJuridica() {
        System.out.print("ID da Pessoa Jurídica a excluir: ");
        int id = scanner.nextInt();
        pessoaJuridicaRepo.excluir(id);
    }

    private static void listarPessoaJuridica() {
        System.out.println("\n--- Lista de Pessoas Jurídicas ---");
        pessoaJuridicaRepo.obterTodos().forEach(PessoaJuridica::exibir);
    }

    private static void salvarPessoaJuridica() {
        System.out.print("Nome do arquivo para salvar: ");
        String arquivo = scanner.nextLine();
        try {
            pessoaJuridicaRepo.persistir(arquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    private static void recuperarPessoaJuridica() {
        System.out.print("Nome do arquivo para recuperar: ");
        String arquivo = scanner.nextLine();
        try {
            pessoaJuridicaRepo.recuperar(arquivo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar o arquivo: " + e.getMessage());
        }
    }
}


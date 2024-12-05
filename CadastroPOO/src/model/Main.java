package model;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Repositório de Pessoa Física
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            repo1.inserir(new PessoaFisica(1, "Ana", "11111111111", 25));
            repo1.inserir(new PessoaFisica(2, "Carlos", "22222222222", 52));
            repo1.persistir("pessoas_fisicas.dat");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoas_fisicas.dat");
            repo2.obterTodos().forEach(PessoaFisica::exibir);

            // Repositório de Pessoa Jurídica
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            repo3.inserir(new PessoaJuridica(3, "XPTO Sales", "33333333333333"));
            repo3.inserir(new PessoaJuridica(4, "XPTO Solutions", "44444444444444"));
            repo3.persistir("pessoas_juridicas.dat");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoas_juridicas.dat");
            repo4.obterTodos().forEach(PessoaJuridica::exibir);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


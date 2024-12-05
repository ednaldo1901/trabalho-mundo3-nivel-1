package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaRepo {
    private List<PessoaJuridica> pessoas = new ArrayList<>();

    // Método para inserir uma Pessoa Jurídica
    public void inserir(PessoaJuridica pessoa) {
        pessoas.add(pessoa);
    }

    // Método para alterar os dados de uma Pessoa Jurídica
    public void alterar(PessoaJuridica pessoa) {
        PessoaJuridica existente = obter(pessoa.getId());
        if (existente != null) {
            existente.setNome(pessoa.getNome());
            existente.setCnpj(pessoa.getCnpj());
        }
    }

    // Método para excluir uma Pessoa Jurídica pelo ID
    public void excluir(int id) {
        pessoas.removeIf(p -> p.getId() == id);
    }

    // Método para obter uma Pessoa Jurídica pelo ID
    public PessoaJuridica obter(int id) {
        return pessoas.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    // Método para obter todas as Pessoas Jurídicas
    public List<PessoaJuridica> obterTodos() {
        return pessoas;
    }

    // Método para salvar os dados das Pessoas Jurídicas em um arquivo
    public void persistir(String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(pessoas);
        }
    }

    // Método para carregar os dados das Pessoas Jurídicas de um arquivo
    public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            pessoas = (List<PessoaJuridica>) ois.readObject();
        } catch (FileNotFoundException e) {
            pessoas = new ArrayList<>();
        }
    }
}


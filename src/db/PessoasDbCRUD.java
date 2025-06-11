package db;

import java.util.List;

public interface PessoasDbCRUD {

    void createPessoa(String nome, String dt_nascimento, String documento, String email);

    PessoasDb readPessoaByNome(String nome);

    PessoasDb readPessoa(Integer id);

    List<PessoasDb> readPessoas();

    void updatePessoa(PessoasDb pessoasDb);

    void deletePessoa(Integer id);

}

import db.PessoasDbCRUD;
import db.PessoasDbCRUDImpl;

public class Programa {

    public static void main(String[] args) {
        PessoasDbCRUD pessoasDbCRUD = new PessoasDbCRUDImpl();

        //testCriacaoPessoa(pessoasDbCRUD);
        //testObterPessoas(pessoasDbCRUD);
        //testObterPessoa(pessoasDbCRUD,"Joao");
        //testUpdatePessoa(pessoasDbCRUD);
        //testDeletePessoa(pessoasDbCRUD, 18);
    }
    private static void testCriacaoPessoa(PessoasDbCRUD crud){
        var nome = "Mikasa";
        var dt_nascimento = "1999-06-09";
        var documento = "12345678925";
        var email = "mikasa@mail.com";
        crud.createPessoa(nome,dt_nascimento,documento,email);
        System.out.println("Contato criado com sucesso");
    }
    private static void testObterPessoas(PessoasDbCRUD crud){
        var pessoas = crud.readPessoas();
        pessoas.forEach(System.out::println);
    }
    private static void testObterPessoa(PessoasDbCRUD crud, String nome){
        var pessoas = crud.readPessoaByNome(nome);
        System.out.println(pessoas);
    }
    private static void testUpdatePessoa(PessoasDbCRUD crud){
        var pessoaAtualizar = crud.readPessoa(1);
        pessoaAtualizar.setNome("Nome atualizado");
        crud.updatePessoa(pessoaAtualizar);
        System.out.println("Pessoa atualizada");
    }
    private static void testDeletePessoa(PessoasDbCRUD crud, Integer id){
        crud.deletePessoa(id);
        System.out.println("id: " + id +" " + "Deletado com sucesso");
    }
}
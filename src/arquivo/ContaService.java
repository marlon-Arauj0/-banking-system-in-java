package arquivo;

import dominio.Operacao;
import dominio.OperacaoInFile;

import java.time.LocalDateTime;
import java.util.Random;

public class ContaService {

    private static final int TAMANHO_NUMERO_CONTA = 5;
    private static final int RANGE_NUMERO_CONTA = 9;
    ArquivoService arquivoService = new ArquivoService();

    public void cadastrar(String nome, String documento, String dataNascimento, double saldo){
        var numeroConta = gerarNumeroConta();
        OperacaoInFile oif = new OperacaoInFile();
        oif.setDataOperacao(LocalDateTime.now());
        oif.setNumeroConta(numeroConta);
        oif.setDocumento(documento);
        oif.setNomeCliente(nome);
        oif.setDataNascimento(dataNascimento);
        oif.setSaldo(saldo);
        arquivoService.adicionarOperacaoArquivo(oif, Operacao.CADASTRO);
    }
    private Integer gerarNumeroConta(){
        Random random = new Random();
        StringBuilder n = new StringBuilder();

        for (int i = 0; i < TAMANHO_NUMERO_CONTA; i++){
            int numero = random.nextInt(RANGE_NUMERO_CONTA);
            n.append(numero);
        }
        return Integer.parseInt(n.toString());
    }
}

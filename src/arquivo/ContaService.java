package arquivo;

import dominio.Operacao;
import dominio.OperacaoInFile;
import utils.DataUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Random;

public class ContaService {

    private static final int TAMANHO_NUMERO_CONTA = 5;
    private static final int RANGE_NUMERO_CONTA = 10;
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

    // todo - fazer distincao de CPF e CNPJ no documento
    // todo - verficar se ja tem uma conta
    // todo - verificar se os compos nao estao nulos
    // todo - validar documento
    // todo - validar idade minima
    // todo - validar saldo minimo

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

package arquivo;

import dominio.Operacao;
import dominio.OperacaoInFile;

import java.util.List;

public class CaixaService {

    private final ArquivoService arquivoService = new ArquivoService();

    public void sacar(Integer numeroConta, Double valor) {
        List<OperacaoInFile> eventosConta = arquivoService.getLinhasPorConta(numeroConta);
        if (eventosConta.isEmpty()) throw new IllegalArgumentException("Conta não existe");

        var saldo = calcularSaldo(eventosConta);

        if (valor > saldo) throw new RuntimeException("Saldo insuficiente");

        var eventoSaque = OperacaoInFile.createOperacaoSaque(numeroConta, valor);
        arquivoService.adicionarOperacaoArquivo(eventoSaque, Operacao.SAQUE);
    }

    public double calcularSaldo(List<OperacaoInFile> eventos){
        var eventoCadastro = eventos
                .stream()
                .filter(operacaoInFile -> operacaoInFile.getCodigoOperacao().equals("CADASTRO"))
                .findAny()
                .orElse(new OperacaoInFile());

        var eventosDeposito = eventos
                .stream()
                .filter(operacaoInFile -> operacaoInFile.getCodigoOperacao().equals("DEPOSITO"))
                .toList();

        var eventosSaque = eventos
                .stream()
                .filter(operacaoInFile -> operacaoInFile.getCodigoOperacao().equals("SAQUE"))
                .toList();

        double saldoInicial = eventoCadastro.getSaldo();

        double totalDepositos = eventosDeposito
                .stream()
                .map(OperacaoInFile::getValor)
                .reduce(0.0, Double::sum);

        double totalSaques = eventosSaque
                .stream()
                .map(OperacaoInFile::getValor)
                .reduce(0.0, Double::sum);

        return (saldoInicial + totalDepositos) - totalSaques;
    }
}

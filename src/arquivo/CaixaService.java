package arquivo;

import dominio.Operacao;
import dominio.OperacaoInFile;

import java.util.List;

public class CaixaService {

    private final ArquivoService arquivoService = new ArquivoService();

    public void sacar(Integer numeroConta, Double valor) {
        List<OperacaoInFile> eventosConta = arquivoService.getLinhasPorConta(numeroConta);
        checarSaldoInsuficiente(eventosConta, valor);
        checarContaExistente(eventosConta);
        var eventoSaque = OperacaoInFile.createOperacaoSaque(numeroConta, valor);
        arquivoService.adicionarOperacaoArquivo(eventoSaque, Operacao.SAQUE);

        System.out.println("Saque da conta: " + numeroConta + " realizado com sucesso");
    }
    public void depositar(Integer numeroConta, Double valor) {
        List<OperacaoInFile> eventosConta = arquivoService.getLinhasPorConta(numeroConta);
        checarContaExistente(eventosConta);
        var eventoDeposito = OperacaoInFile.createOperacaoDeposito(numeroConta, valor);
        arquivoService.adicionarOperacaoArquivo(eventoDeposito, Operacao.DEPOSITO);

        System.out.println("Deposito na conta: " + numeroConta + " realizado com sucesso");
    }

    public void transferir(Integer contaOrigem, Integer contaDestino, final Double valor) {
        try {
            sacar(contaOrigem, valor);
        } catch (Exception e) {
            throw new RuntimeException("Erro na transferencia - Operação saque conta origem:" + e.getMessage());
        }
        try {
            depositar(contaDestino, valor);
        }catch (Exception e){
                depositar(contaOrigem, valor);
                throw new RuntimeException("Erro na transferencia - Operação deposito conta destino:" + e.getMessage());
        }
        var eventoTransferir = OperacaoInFile.createOperacaoTransferencia(contaOrigem,contaDestino, valor);
        arquivoService.adicionarOperacaoArquivo(eventoTransferir, Operacao.TRANSFERENCIA);
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

    private  void checarContaExistente(List<OperacaoInFile> eventosConta ){
        if (eventosConta.isEmpty()) throw new IllegalArgumentException("Conta não existe");
    }
    private void checarSaldoInsuficiente(List<OperacaoInFile> eventosConta, Double valor){
        var saldo = calcularSaldo(eventosConta);
        if (valor > saldo) {
            throw new RuntimeException("Saldo insuficiente");
        }
    }
}
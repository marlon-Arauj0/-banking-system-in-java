package dominio;

import java.time.LocalDateTime;

public class OperacaoInFile {

    private String codigoOperacao;
    private String nomeCliente;
    private String documento;
    private Integer numeroConta;
    private double saldo;
    private double valor;
    private Integer numeroContaDestino;
    private String dataNascimento;
    private LocalDateTime dataOperacao;

    public static OperacaoInFile createOperacaoSaque(Integer numeroConta, double valor){
        var operacaoLinha = new OperacaoInFile();

        operacaoLinha.numeroConta = numeroConta;
        operacaoLinha.valor = valor;
        operacaoLinha.dataOperacao = LocalDateTime.now();
        operacaoLinha.codigoOperacao = Operacao.SAQUE.name();

        return operacaoLinha;
    }
    public static OperacaoInFile createOperacaoDeposito(Integer numeroConta, double valor){
        var operacaoLinha = new OperacaoInFile();

        operacaoLinha.numeroConta = numeroConta;
        operacaoLinha.valor = valor;
        operacaoLinha.dataOperacao = LocalDateTime.now();
        operacaoLinha.codigoOperacao = Operacao.DEPOSITO.name();

        return operacaoLinha;
    }
    public static OperacaoInFile createOperacaoTransferencia(Integer contaOrigem, Integer numeroContaDestino, double valor){
        var operacaoLinha = new OperacaoInFile();

        operacaoLinha.numeroConta = contaOrigem;
        operacaoLinha.valor = valor;
        operacaoLinha.numeroContaDestino = numeroContaDestino;
        operacaoLinha.dataOperacao = LocalDateTime.now();
        operacaoLinha.codigoOperacao = Operacao.TRANSFERENCIA.name();

        return operacaoLinha;
    }
    public String getCodigoOperacao() {
        return codigoOperacao;
    }

    public void setCodigoOperacao(String codigoOperacao) {
        this.codigoOperacao = codigoOperacao;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getNumeroContaDestino() {
        return numeroContaDestino;
    }

    public void setNumeroContaDestino(Integer numeroContaDestino) {
        this.numeroContaDestino = numeroContaDestino;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(LocalDateTime dataOperacao) {
        this.dataOperacao = dataOperacao;
    }
}

package dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OperacaoInFile {

    private String codigoOperacao;
    private String nomeCliente;
    private String documento;
    private Integer numeroConta;
    private Double saldo;
    private Double valor;
    private Integer numeroContaDestino;
    private String dataNascimento;
    private LocalDateTime dataOperacao;

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

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
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

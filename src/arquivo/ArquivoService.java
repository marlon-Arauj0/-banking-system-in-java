package arquivo;

import dominio.Operacao;
import dominio.OperacaoInFile;
import utils.DataUtil;
import utils.IOUtil;

import java.util.List;

import static utils.DataUtil.getDataFormatada;

public class ArquivoService {

public static final  String CAMINHO_DO_ARQUIVO = "/home/marlon/StudioProjects/sistema-bancario/sistema-bancario-v1/eventos-bancarios.txt";

    public void adicionarOperacaoArquivo(OperacaoInFile OperacaoInFile, Operacao operacao){
        StringBuilder OperacaoInFileStr = new StringBuilder(operacao.name()).append(",");

        switch (operacao){
            case SAQUE, DEPOSITO ->
                OperacaoInFileStr.append(getDataFormatada(OperacaoInFile.getDataOperacao())).append(",")
                        .append(OperacaoInFile.getNumeroConta()).append(",")
                        .append(OperacaoInFile.getValor());
            case CADASTRO ->
                OperacaoInFileStr.append(getDataFormatada(OperacaoInFile.getDataOperacao())).append(",")
                        .append(OperacaoInFile.getNumeroConta()).append(",")
                        .append(OperacaoInFile.getDocumento()).append(",")
                        .append(OperacaoInFile.getNomeCliente()).append(",")
                        .append(OperacaoInFile.getDataNascimento()).append(",")
                        .append(OperacaoInFile.getSaldo());
            case TRANSFERENCIA ->
                OperacaoInFileStr.append(getDataFormatada(OperacaoInFile.getDataOperacao())).append(",")
                        .append(OperacaoInFile.getNumeroConta()).append(",")
                        .append(OperacaoInFile.getNumeroContaDestino()).append(",")
                        .append(OperacaoInFile.getValor());
            default -> throw new IllegalArgumentException("Operação invalida");
        }

        OperacaoInFileStr.append("\n");

        IOUtil.addLinha(CAMINHO_DO_ARQUIVO, OperacaoInFileStr.toString());
    }

    public OperacaoInFile getLinhaPorCodigoOperacao(String codigo){
        return null;
    }
    public List<OperacaoInFile> getLinhasPorConta(Integer numero){
        List<String> linhasString = IOUtil.getLinhas(CAMINHO_DO_ARQUIVO);
        return linhasString
                .stream()
                .map(operacaoInFileString -> {
                    String[] operacaoToken = operacaoInFileString.split(",");

                    var operacao = operacaoToken[0];
                    var operacaoData = DataUtil.dataStringToLocalDateTime(operacaoToken[1]);
                    var numConta = Integer.parseInt(operacaoToken[2]);

                    var operacaoInFile = new OperacaoInFile();
                    operacaoInFile.setCodigoOperacao(operacao);
                    operacaoInFile.setDataOperacao(operacaoData);
                    operacaoInFile.setNumeroConta(numConta);

                    switch (operacao){
                        case "CADASTRO" -> {
                            operacaoInFile.setDocumento(operacaoToken[3]);
                            operacaoInFile.setNomeCliente(operacaoToken[4]);
                            operacaoInFile.setDataNascimento(operacaoToken[5]);
                            operacaoInFile.setSaldo(Double.parseDouble(operacaoToken[6]));
                        }
                        case "SAQUE", "DEPOSITO" -> {
                            operacaoInFile.setValor(Double.parseDouble(operacaoToken[3]));
                        }
                        case "TRANSFERENCIA" -> {
                            operacaoInFile.setCodigoOperacao(operacao);
                            operacaoInFile.setDataOperacao(operacaoData);
                            operacaoInFile.setNumeroConta(numConta);
                        }
                        default -> throw new IllegalArgumentException("Operação invalida");
                    }
                    return operacaoInFile;

                })
                .filter(operacaoInFile -> operacaoInFile.getNumeroConta().equals(numero))
                .toList();
    }

    public List<OperacaoInFile> getLinhaPorOperacao(Operacao operacao){
        return null;
    }
    public List<OperacaoInFile> getTodoConteudo(){
        return null;
    }
}
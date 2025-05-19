package arquivo;

import dominio.Operacao;
import dominio.OperacaoInFile;

import java.util.List;

import static utils.DataUtil.getDataFormatada;

public class ArquivoService {

    public static final  String CAMINHO_DO_ARQUIVO = "/home/marlon/StudioProjects/operacoes-bancarias.txt";

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
                        .append(getDataFormatada(OperacaoInFile.getDataNascimento()))
                        .append(OperacaoInFile.getSaldo());
            case TRANSFERENCIA ->
                OperacaoInFileStr.append(getDataFormatada(OperacaoInFile.getDataOperacao())).append(",")
                        .append(OperacaoInFile.getNumeroConta()).append(",")
                        .append(OperacaoInFile.getNumeroContaDestino()).append(",")
                        .append(OperacaoInFile.getValor());
            default -> throw new IllegalArgumentException("Operação invalida");
        }
    }

    public OperacaoInFile getlinhaPorcodigoOperacao(String codigo){
        return null;
    }
    public List<OperacaoInFile> getLinhaPorConta(Integer numero){
        return null;
    }
    public List<OperacaoInFile> getLinhaPorOperacao(Operacao operacao){
        return null;
    }
    public List<OperacaoInFile> getTodoConteudo(){
        return null;
    }
}


package arquivo;

import dominio.Operacao;
import dominio.OperacaoInFile;
import utils.IOUtil;

import java.util.List;

import static utils.DataUtil.getDataFormatada;

public class ArquivoService {

public static final  String CAMINHO_DO_ARQUIVO = "/home/marlon/StudioProjects/operacoes-bancarias.txt";

    public void adicionarOperacaoArquivo(OperacaoInFile OperacaoInFile, Operacao operacao){
        StringBuilder OperacaoInFileStr = new StringBuilder(operacao.name()).append(", ");

        switch (operacao){
            case SAQUE, DEPOSITO ->
                OperacaoInFileStr.append(getDataFormatada(OperacaoInFile.getDataOperacao())).append(", ")
                        .append(OperacaoInFile.getNumeroConta()).append(", ")
                        .append(OperacaoInFile.getValor()).append(" || ");
            case CADASTRO ->
                OperacaoInFileStr.append(getDataFormatada(OperacaoInFile.getDataOperacao())).append(", ")
                        .append(OperacaoInFile.getNumeroConta()).append(", ")
                        .append(OperacaoInFile.getDocumento()).append(", ")
                        .append(OperacaoInFile.getNomeCliente()).append(", ")
                        .append(OperacaoInFile.getDataNascimento()).append(", ")
                        .append(OperacaoInFile.getSaldo()).append(" || ");
            case TRANSFERENCIA ->
                OperacaoInFileStr.append(getDataFormatada(OperacaoInFile.getDataOperacao())).append(", ")
                        .append(OperacaoInFile.getNumeroConta()).append(", ")
                        .append(OperacaoInFile.getNumeroContaDestino()).append(", ")
                        .append(OperacaoInFile.getValor()).append(" || ");
            default -> throw new IllegalArgumentException("Operação invalida");
        }

        IOUtil.addLinha(CAMINHO_DO_ARQUIVO, OperacaoInFileStr.toString());
    }

    public OperacaoInFile getLinhaPorCodigoOperacao(String codigo){
        return null;
    }
    public List<OperacaoInFile> getLinhasPorConta(Integer numero){
        return null;
    }
    public List<OperacaoInFile> getLinhaPorOperacao(Operacao operacao){
        return null;
    }
    public List<OperacaoInFile> getTodoConteudo(){
        return null;
    }
}


package arquivo;

import dominio.Operacao;
import dominio.OperacaoInFile;

import java.util.List;

public class CaixaService {

    private final ArquivoService arquivoService = new ArquivoService();

    public void sacar(Integer numeroConta, Double valor) {
        List<OperacaoInFile> conta = arquivoService.getLinhasPorConta(numeroConta);

        if (conta.isEmpty()) throw new IllegalArgumentException("Conta não existe");
    }

    public double calcularSaldo(List<OperacaoInFile> eventos){
        OperacaoInFile  eventoCadastro = eventos
                .stream()
                .filter(operacaoInFile -> isLinhaOperacaoCadastro(operacaoInFile))
                .findAny()
                .get();

        return 0.0;
    }
    private boolean isLinhaOperacaoCadastro(OperacaoInFile operacaoInFile){
        return  operacaoInFile.getCodigoOperacao().equals(Operacao.CADASTRO.name());
    }
}

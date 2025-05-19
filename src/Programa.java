import arquivo.ArquivoService;
import dominio.Operacao;

public class Programa {

    public static void main(String[] args) {

        var test = new ArquivoService();

        test.adicionarOperacaoArquivo(null, Operacao.DEPOSITO);
    }
}
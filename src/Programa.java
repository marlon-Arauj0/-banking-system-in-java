import arquivo.ArquivoService;
import dominio.Operacao;
import utils.IOUtil;
import arquivo.ContaService;

public class Programa {

    public static void main(String[] args) {
        var ContaService = new ContaService();
        ContaService.cadastrar("Maria","123456789","13/03/2005",2000);

    }
}
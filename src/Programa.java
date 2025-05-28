import arquivo.ArquivoService;
import arquivo.CaixaService;
import dominio.Operacao;
import utils.IOUtil;
import arquivo.ContaService;

import java.util.Scanner;

public class Programa {

    static Scanner sc = new Scanner(System.in);
    static CaixaService caixaService = new CaixaService();

    public static void main(String[] args) {
        while (true) {

            var opcao = exibirMenu();

            switch (opcao) {
                case 1 -> {
                    System.out.println("cadastra selecionado");
                }
                case 2 -> {
                    System.out.println("Informe o numero da conta para o saque:");
                    int conta = sc.nextInt();

                    System.out.println("Informe o valor do saque:");
                    double valor = sc.nextDouble();

                    caixaService.sacar(conta, valor);
                }
                case 3 -> {
                    System.out.println("Informe o numero da conta para o deposito:");
                    int conta = sc.nextInt();

                    System.out.println("Informe o valor do deposito:");
                    double valor = sc.nextDouble();

                    caixaService.depositar(conta, valor);
                }
                case 4 -> {
                    System.out.println("transferencia selecionada");
                    int conta = sc.nextInt();

                    System.out.println("Informe o valor da transferencia:");
                    double valor = sc.nextDouble();

                }
                case 5 -> {
                    System.out.println("Fechando o sistema");
                    System.exit(0);
                }
            }
        }

    }

    private static int exibirMenu() {
        System.out.println("========================================");
        System.out.println("         SISTEMA BANCÁRIO - CAIXA       ");
        System.out.println("========================================");
        System.out.println("              MENU PRINCIPAL            ");
        System.out.println("----------------------------------------");
        System.out.println("  1 - Cadastrar conta");
        System.out.println("  2 - Saque");
        System.out.println("  3 - Depósito");
        System.out.println("  4 - Transferência");
        System.out.println("  5 - Sair");
        System.out.println("----------------------------------------");
        System.out.print("Informe a opção desejada: ");

        while (!sc.hasNextInt()) {
            System.out.print("Opção inválida. Digite um número: ");
            sc.next();
        }

        return sc.nextInt();
    }
}
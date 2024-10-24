import br.com.conversor.Cambio;
import br.com.conversor.ConsultaCambio;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada =  new Scanner(System.in);
        ConsultaCambio consultaCambio = new ConsultaCambio();
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("=====================================================");
            System.out.println("Seja bem-vindo(a) ao Conversor de Moedas\n");
            System.out.println("[1] - Real para Dólar Americano");
            System.out.println("[2] - Real para Euro");
            System.out.println("[3] - Real para Dólar Canadense");
            System.out.println("[4] - Dólar Americano para Real");
            System.out.println("[5] - Euro para Dólar Real");
            System.out.println("[6] - Dólar Canadense para Dólar Real");
            System.out.println("[7] - SAIR");
            System.out.println("\n Escolha uma opção válida");
            System.out.println("=====================================================");

            opcao = entrada.nextInt();

            if (opcao < 1 || opcao > 7) {
                System.out.println("Opção inválida! Tente novamente.");
            } else if (opcao == 7) {
                System.out.println("Volte sempre!");
            } else {
                System.out.println("Informe o valor que deseja converter:");
                double valorBase = entrada.nextDouble();
                Cambio meuCambio = null;

                switch (opcao) {
                    case 1:
                        meuCambio = consultaCambio.realToAmericanDollar(valorBase);
                        break;
                    case 2:
                        meuCambio = consultaCambio.realToEuro(valorBase);
                        break;
                    case 3:
                        meuCambio = consultaCambio.realToCanadianDollar(valorBase);
                        break;
                    case 4:
                        meuCambio = consultaCambio.americanDollarToReal(valorBase);
                        break;
                    case 5:
                        meuCambio = consultaCambio.euroToReal(valorBase);
                        break;
                    case 6:
                        meuCambio = consultaCambio.canadianDollarToReal(valorBase);
                        break;
                }

                if (meuCambio != null) {
                    System.out.println("Valor " + valorBase + " [" + meuCambio.base_code() + "] corresponde ao valor final de " + meuCambio.conversion_result() + " [" + meuCambio.target_code() + "]");
                }
            }
        }
    }
}
import java.util.Scanner;

public class ContaBanco {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, digite o número da conta !");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Por favor, digite o número da Agência !");
        String numeroAgencia = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Por favor, digite o seu nome !");
        String nomeCliente = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Por favor, digite o seu saldo !");
        float saldoConta = scanner.nextFloat();
        scanner.nextLine();

        ContaTerminal contaTerminal = new ContaTerminal(numeroConta, numeroAgencia, nomeCliente, saldoConta);

        System.out.println(contaTerminal.toString());

    }
}

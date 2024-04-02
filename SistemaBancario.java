import java.util.Scanner;

// Classe principal do programa
public class SistemaBancario {

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação de uma conta bancária
        ContaBancaria conta = new ContaBancaria("João", 1000);

        // Exibição do menu
        System.out.println("Bem-vindo ao Sistema Bancário!");
        System.out.println("1. Ver Saldo");
        System.out.println("2. Depositar");
        System.out.println("3. Sacar");
        System.out.println("4. Sair");

        boolean sair = false;
        while (!sair) {
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    // Ver saldo
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    break;
                case 2:
                    // Depositar
                    System.out.print("Digite o valor para depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso.");
                    break;
                case 3:
                    // Sacar
                    System.out.print("Digite o valor para sacar: ");
                    double valorSaque = scanner.nextDouble();
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso.");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 4:
                    // Sair do programa
                    sair = true;
                    System.out.println("Operação finalizada");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        // Fechar o scanner
        scanner.close();
    }
}

// Classe para representar uma conta bancária
class ContaBancaria {
    @SuppressWarnings("unused")
    private String titular;
    private double saldo;

    // Construtor
    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    // Método para depositar dinheiro na conta
    public void depositar(double valor) {
        saldo += valor;
    }

    // Método para sacar dinheiro da conta
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    // Método para obter o saldo atual
    public double getSaldo() {
        return saldo;
    }
}

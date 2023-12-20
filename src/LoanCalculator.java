import java.text.NumberFormat;
import java.util.Scanner;

public class LoanCalculator {

    private static final int MONTHS_IN_YEAR = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double principal = readDouble(scanner, "Inserir o valor do empréstimo:");
        float annualInterestRate = readFloat(scanner, "Inserir taxa de juros anual:");
        int loanTerm = readInt(scanner, "Prazo do empréstimo à habitação (Anos): ");

        double monthlyPayment = calculateMonthlyPayment(principal, annualInterestRate, loanTerm);
        displayMonthlyPayment(monthlyPayment);

        displaypayback(monthlyPayment, loanTerm * MONTHS_IN_YEAR);

    }

    private static double readDouble(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.nextDouble();
    }

    private static float readFloat(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.nextFloat()/100;
    }

    private static int readInt(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }

    private static double calculateMonthlyPayment(double principal, float annualInterestRate, int loanTerm) {
        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;
        int numberOfPayments = loanTerm * MONTHS_IN_YEAR;

        double monthlyPayment = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) /
                (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return monthlyPayment;
    }

    private static void displayMonthlyPayment(double monthlyPayment) {
        System.out.println("Prestação Mensal: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));
    }

    private  static void displaypayback(double monthlyPayment , int numberOfPayments){
        System.out.println("Prestação Mensal: " + NumberFormat.getCurrencyInstance().format(monthlyPayment * numberOfPayments));
    }
}
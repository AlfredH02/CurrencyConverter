package main;

import facade.CurrencyConverterFacade;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverterFacade converterFacade = new CurrencyConverterFacade();
        String[] currencies = {"ARS", "EUR", "BRL", "JPY", "GBP", "USD"};

        while (true) {
            System.out.println("Bem-vindo ao Conversor de Moedas!");
            System.out.println("Selecione a moeda de origem:");
            for (int i = 0; i < currencies.length; i++) {
                System.out.println((i + 1) + ". " + currencies[i]);
            }

            int choice = scanner.nextInt();
            if (choice < 1 || choice > currencies.length) {
                System.out.println("Opção inválida.");
                continue;
            }

            String fromCurrency = currencies[choice - 1];

            System.out.println("Selecione a moeda de destino:");
            for (int i = 0; i < currencies.length; i++) {
                System.out.println((i + 1) + ". " + currencies[i]);
            }

            choice = scanner.nextInt();
            if (choice < 1 || choice > currencies.length) {
                System.out.println("Opção inválida.");
                continue;
            }

            String toCurrency = currencies[choice - 1];

            System.out.print("Digite o valor a ser convertido: ");
            double amount = scanner.nextDouble();

            try {
                double convertedAmount = converterFacade.convert(fromCurrency, toCurrency, amount);
                System.out.printf("%.2f %s é igual a %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao obter a taxa de câmbio: " + e.getMessage());
            }

            System.out.print("Deseja realizar outra conversão? (s/n): ");
            String repeat = scanner.next().toLowerCase();
            if (!repeat.equals("s")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Obrigado por usar o Conversor de Moedas!");
    }
}

package com.nish.Assignment_2.Model;
import java.util.Scanner;

public class BalancedBrackets {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter expression: ");
        String str = scanner.nextLine();

        int round = 0, square = 0, curly = 0;

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            switch (c) {

                case '(':
                    round++;
                    break;

                case ')':
                    round--;
                    break;

                case '[':
                    square++;
                    break;

                case ']':
                    square--;
                    break;

                case '{':
                    curly++;
                    break;

                case '}':
                    curly--;
                    break;
            }

            if (round < 0 || square < 0 || curly < 0) {
                System.out.println("Not Balanced");
                scanner.close();
                return;
            }
        }

        if (round == 0 && square == 0 && curly == 0)
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");

        scanner.close();
    }
}
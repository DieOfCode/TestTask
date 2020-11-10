package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var inputValue= new Scanner(System.in);
        var calculator = new Calculator();
        while(true) {
            var request = inputValue.nextLine();
            if (request.equals("стоп"))  break;
            try {
                System.out.println(calculator.calculate(request));
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

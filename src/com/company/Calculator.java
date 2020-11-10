package com.company;

import javax.script.ScriptException;

public class Calculator {
    public Integer calculate(String expression) {
        var list = Parser.parseExpression(expression);

        var result = Integer.MIN_VALUE;
        var first = list.get(0);
        var second =list.get(2);
        var operation = list.get(1);

        if(isInteger(first) && isInteger(second)){
            result=this.getResult(operation,first,second);
        }
        else if (!(isInteger(first) && isInteger(second))){
            result=this.getResult(operation,
                    Converter.romanToArabic(first).toString(),
                    Converter.romanToArabic(second).toString());
        }
        return result;
    }
    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    public Integer getResult(String operation,String first,String second){
        switch (operation){
            case "-" -> {
                return Integer.parseInt(first)-Integer.parseInt(second);
            }
            case "*" -> {
                return Integer.parseInt(first)*Integer.parseInt(second);
            }

            case "/" -> {
                return Integer.parseInt(first)/Integer.parseInt(second);
            }

            case "+" -> {
                return Integer.parseInt(first)+Integer.parseInt(second);
            }
            default -> {
                return Integer.MIN_VALUE;
            }

        }
    }
}

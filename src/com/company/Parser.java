package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Parser {
    public static ArrayList<String> parseExpression(String expression){
        var pattern = Pattern.compile("(?<first>[I,V,X,L,C,D,M,\\d]+)(?<operator>[/,\\-,+,*])(?<second>[I,V,X,L,C,D,M,\\d]+)", Pattern.CASE_INSENSITIVE);
        expression = expression.replaceAll("\\s","");
        var matcher = pattern.matcher(expression);
        var expressionList = new ArrayList<String>();
        if(matcher.find()) {
            expressionList.addAll(new ArrayList<>(Arrays
                    .asList(matcher
                            .group("first"), matcher
                            .group("operator"), matcher
                            .group("second"))));

        }
        return expressionList;
    }
}


